package com.abraham.worktest.gameloop;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

public class MainLoop extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int WIDTH = 640;
	public int HEIGHT = 480;

	public static Random random = new Random();

	// Timing controllers
	public static double FRAME_LIMITER = 1000_000_000d / 60d;
	double reference_time;
	double current_time;

	// Global default position
	public int GLO_XPOS = WIDTH / 2 - 16;
	public int GLO_YPOS = HEIGHT / 2 - 16;
	public int GLO_Movement = 0;

	public int screenXPos = WIDTH / 2;
	public int screenYPos = HEIGHT / 2;

	// Functionality Variables
	public KeyboardListner kbl = new KeyboardListner();
	private Thread thread;
	private boolean running = false;

	// Main screen drawing sheet
	private BufferedImage drawingBoard = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] gl_pixels = ((DataBufferInt) drawingBoard.getRaster().getDataBuffer()).getData();

	// Test objects
	private BufferedImage entity_01 = new BufferedImage(32, 32, BufferedImage.TYPE_INT_RGB);
	private int[] glPixels01 = ((DataBufferInt) entity_01.getRaster().getDataBuffer()).getData();

	public MainLoop() {
		this.setSize(WIDTH, HEIGHT);
		this.addKeyListener(kbl);
	}

	public MainLoop(int width, int hight) {
		HEIGHT = hight;
		WIDTH = width;
		this.setSize(WIDTH, HEIGHT);
	}

	@Override
	public void run() {

		reference_time = System.nanoTime();
		int fps = 0;
		int tps = 0;
		long fpsMeter = System.currentTimeMillis();
		double d_Time = 0D;
		while (running) {
			current_time = System.nanoTime();
			d_Time += (current_time - reference_time) / FRAME_LIMITER;
			reference_time = current_time;
			if (d_Time >= 1) {
				tick(d_Time);
				d_Time--;
				tps++;
			}
			render(d_Time);
			fps++;

			if (System.currentTimeMillis() - fpsMeter >= 1000) {
				System.out.println("fps = " + fps + " , tps = " + tps);
				fpsMeter += 1000;
				fps = 0;
				tps = 0;
			}

		}
	}

	public void start() {
		if (running == true)
			return;
		else {
			running = true;
			thread = new Thread(this, "GameLoop");
			thread.start();
		}

	}

	public void stop() {
		if (running == false)
			return;
		else {
			running = false;
			try {
				this.thread.join();
			} catch (InterruptedException e) {
				System.out.println("Error by closing the Thread with the error message:");
				System.out.println(e.getMessage());

			}
		}
	}

	private void tick(double d_time) {

		clearImage(gl_pixels); // Clearing the drawing sheet for redrawing the
								// whole things
		// GLO_Movement += (int) d_time;
		// if (GLO_Movement > 60) {
		
		
		GLO_YPOS = (GLO_YPOS + kbl.dir[0]);
		if (GLO_YPOS >= HEIGHT - 32)
			GLO_YPOS = HEIGHT - 32;
		GLO_YPOS = (GLO_YPOS - kbl.dir[1]);
		if (GLO_YPOS <= 0)
			GLO_YPOS = 0;
		GLO_XPOS = (GLO_XPOS + kbl.dir[2]);
		if (GLO_XPOS >= WIDTH - 32)
			GLO_XPOS = WIDTH - 32;
		GLO_XPOS = (GLO_XPOS - kbl.dir[3]);
		if (GLO_XPOS <= 0)
			GLO_XPOS = 0;
		// GLO_Movement = 0;
		// }

		// System.out.println("(" + GLO_XPOS + ", " + GLO_YPOS + ")");

	}

	private void render(double d_time) {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		//////////////////////////////////

		// g.drawLine(0, 0, WIDTH, HIGHT);

		// g.drawImage(img01, WIDTH / 2 - WIDTH / 4, HEIGHT / 2 - HEIGHT / 4,
		// null);

		// g.setColor(Color.WHITE);
		//
		// g.drawLine(0, 0, WIDTH / 2 - WIDTH / 4, HEIGHT / 2 - HEIGHT / 4);
		// g.drawLine(WIDTH, HEIGHT, WIDTH - WIDTH / 4, HEIGHT - HEIGHT / 4);
		// g.drawLine(0, 0, WIDTH / 2 - WIDTH / 4, HEIGHT / 2 - HEIGHT / 4);
		// g.drawLine(0, 0, WIDTH / 2 - WIDTH / 4, HEIGHT / 2 - HEIGHT / 4);

		drawEntityAtPosition(GLO_XPOS, GLO_YPOS, glPixels01, entity_01.getWidth(), entity_01.getHeight());
		// drawEntityAtPosition(random.nextInt(WIDTH), random.nextInt(HEIGHT),
		// glPixels01, entity_01.getWidth(),entity_01.getHeight());
		g.drawImage(drawingBoard, 0, 0, null);
		// Stuff drawing area

		//////////////////////////////////

		g.dispose();
		bs.show();
	}

	private void drawEntityAtPosition(int xPos, int yPos, int[] item, int itemWidth, int itemHeight) {
		for (int x = 0; x < itemWidth; x++) {

			if (x + xPos >= WIDTH || x + xPos < 0) {
				continue;
			}

			for (int y = 0; y < itemHeight; y++) {
				// when the y position is more that what we have on the main
				// screen we have to stop displaying
				// and move forward with drawing loop

				if (y + yPos >= HEIGHT || y + yPos < 0) {
					continue;
				}

				gl_pixels[((y + yPos) * WIDTH) + (x + xPos)] = item[(y * itemWidth) + (x)];
			}

		}
	}

	private void clearImage(int[] imagePixelsArray) {
		for (int i = 0; i < imagePixelsArray.length; i++) {
			imagePixelsArray[i] = 0xff00ff;
		}
	}

	private class KeyboardListner implements KeyListener {

		public int[] dir = new int[4];

		@Override
		public void keyPressed(KeyEvent e) {

			if (e != null) {
				// System.out.println("Hey Dude!!!");
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
				if (screenYPos > 0) {
					// Go Down
					// GLO_YPOS++;
					if (dir[0] != 1) {
						dir[0] = 1;
					}
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
				if (screenYPos < (HEIGHT - 1)) {
					// Go Up
					// GLO_YPOS--;
					if (dir[1] != 1) {
						dir[1] = 1;
					}
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
				if (screenXPos < (WIDTH - 1)) {
					// Go right
					// GLO_XPOS++;
					if (dir[2] != 1) {
						dir[2] = 1;
					}
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
				if (screenXPos > 0) {
					// Go Left
					// GLO_XPOS--;
					if (dir[3] != 1) {
						dir[3] = 1;
					}
				}
			}

		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
				dir[0] = 0;
			}
			if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
				dir[1] = 0;
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
				dir[3] = 0;
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
				dir[2] = 0;
			}

		}

		@Override
		public void keyTyped(KeyEvent e) {

		}
	}

}
