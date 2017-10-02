package com.abraham.gfx.worktest.main;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.abraham.gfx.worktest.mainloop.MainLoop;

public class Main {

	public static void main(String args[]) {

		JFrame frm = new JFrame();
		MainLoop gl = new MainLoop();
		Dimension d = new Dimension(gl.WIDTH * 3, gl.HEIGHT * 3);

		frm.setPreferredSize(d);
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