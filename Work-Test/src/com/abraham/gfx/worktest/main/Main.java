package com.abraham.gfx.worktest.main;

import javax.swing.JFrame;

import com.abraham.gfx.worktest.mainloop.MainLoop;

public class Main {

	public static void main(String args[]) {

		JFrame frm = new JFrame();
		MainLoop gl = new MainLoop();

		frm.setSize(gl.WIDTH, gl.HEIGHT);
		frm.add(gl);
		frm.addKeyListener(gl.kbl);
		frm.setResizable(false);
		frm.pack();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLocationRelativeTo(null);
		frm.setVisible(true);
		frm.setUndecorated(true);
		gl.start();

	}

}