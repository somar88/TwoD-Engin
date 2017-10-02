package com.abraham.gfx.worktest.main;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.abraham.gfx.worktest.mainloop.MainLoop;

public class Main {

	public static void main(String args[]) {

		JFrame frm = new JFrame();
		MainLoop ml = new MainLoop();
		Dimension d = new Dimension(ml.WIDTH * 3, ml.HEIGHT * 3);
		frm.setPreferredSize(d);
		frm.add(ml);
		frm.addKeyListener(ml.kbl);
		frm.setResizable(false);
		frm.pack();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLocationRelativeTo(null);
		frm.setVisible(true);
		ml.start();

	}

}