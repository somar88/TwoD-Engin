package project.gop.main;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

public class GW extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	boolean fse = false;
	int fsm = 0;

	GraphicsDevice monitors = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[1];

	public GW(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		requestFocus();
	}

	private void setfullscreen() {

		switch (fsm) {
		case 0:
			setUndecorated(false);
			System.out.println("Windowed");
			break;
		case 1:
			setUndecorated(true);
			setExtendedState(JFrame.MAXIMIZED_BOTH);
			break;
		case 2:
			setUndecorated(true);
			monitors.setFullScreenWindow(this);
			break;

		}

	}

	public void setFullscreen(int fsnm) {
		fse = true;
		if (fsm <= 2) {
			this.fsm = fsnm;
			setfullscreen();
		} else {
			System.err.println("Error " + fsnm + " is not supported!");
		}

	}

}
