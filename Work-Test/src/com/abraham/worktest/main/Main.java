package com.abraham.worktest.main;

import javax.swing.JFrame;

import com.abraham.worktest.gameloop.GameLoop;

public class Main {

	public static void main(String args[]) {
		GameLoop gl = new GameLoop();
		JFrame frm = new JFrame();

		frm.setSize(gl.WIDTH, gl.HEIGHT);
		frm.add(gl);
		frm.addKeyListener(gl.kbl);
		frm.setResizable(false);
		frm.pack();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLocationRelativeTo(null);
		frm.setVisible(true);
		gl.start();

	}

}