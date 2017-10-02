package com.abraham.gfx.worktest.render;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import com.abraham.gfx.Screen;
import com.abraham.gfx.TileMap;
import com.abraham.gfx.worktest.mainloop.MainLoop;

public class Render {

	public MainLoop mainLoop;

	int v;
	int u;

	public Render() {
	}

	public Render(MainLoop meinLoop) {
		this.mainLoop = meinLoop;
	}

	public void render(double d_time) {
		BufferStrategy bs = mainLoop.getBufferStrategy();
		if (bs == null) {
			mainLoop.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		drawScreen(); 
		// test
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
		/*
		 * drawEntityAtPosition(ml.GLO_XPOS, ml.GLO_YPOS, ml.glPixels01, ml.entity_01.getWidth(), ml.entity_01.getHeight(), ml);
		 */

		// drawEntityAtPosition(random.nextInt(WIDTH), random.nextInt(HEIGHT),
		// glPixels01, entity_01.getWidth(),entity_01.getHeight());
		g.drawImage(mainLoop.screen.drawingBoard, 0, 0, mainLoop.screen.getScreen_Width() * mainLoop.SCALE, mainLoop.screen.getScreen_Height() * mainLoop.SCALE, null);
		// Stuff drawing area

		//////////////////////////////////

		g.dispose();
		bs.show();
		clearImage(mainLoop.screen.screen_pixels);

	}

	public void drawEntityAtPosition(int xPos, int yPos, int[] item, int itemWidth, int itemHeight, MainLoop ml) {
		for (int x = 0; x < itemWidth; x++) {

			if (x + xPos >= ml.WIDTH || x + xPos < 0) {
				continue;
			}

			for (int y = 0; y < itemHeight; y++) {
				// when the y position is more that what we have on the main
				// screen we have to stop displaying
				// and move forward with drawing loop

				if (y + yPos >= ml.HEIGHT || y + yPos < 0) {
					continue;
				}
				// TODO: do not forget this
				// ml.ml_pixels[((y + yPos) * ml.WIDTH) + (x + xPos)] = item[(y * itemWidth) + (x)];
			}

		}
	}

	public void drawScreen() {

		for (int x = 0; x < mainLoop.screen.Screen_Width; x++) {
			for (int y = 0; y < mainLoop.screen.Screen_Height; y++) {

				if (x + mainLoop.screen.getScreen_X_Pos() < mainLoop.map.getMap_width()) {
					if (y + mainLoop.screen.getScreen_Y_Pos() < mainLoop.map.getMap_height()) {
						mainLoop.screen.screen_pixels[x + (y * mainLoop.screen.Screen_Width)] = mainLoop.map.map_pixels[((mainLoop.screen.getScreen_Y_Pos() + y) * mainLoop.map.getMap_width()) + (x + mainLoop.screen.getScreen_X_Pos())];
					} else {
						mainLoop.screen.screen_pixels[x + (y * mainLoop.screen.Screen_Width)] = 0xff00ff;
					}
				}
			}
		}

	}

	public void drawScreen(Screen screen, TileMap tileMap) {

		for (int x = 0; x < screen.Screen_Width; x++) {
			for (int y = 0; y < screen.Screen_Height; y++) {
			}
		}

	}

	private void clearImage(int[] imagePixelsArray) {
		for (int i = 0; i < imagePixelsArray.length; i++) {
			imagePixelsArray[i] = 0xff00ff;
		}
	}

}
