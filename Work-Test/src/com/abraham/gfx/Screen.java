package com.abraham.gfx;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Screen {

	public int Screen_Width;
	public int Screen_Height;

	private int Screen_X_Pos = 0;
	private int Screen_Y_Pos = 0;
	public BufferedImage drawingBoard;
	public int[] screen_pixels;

	public Screen(int width, int height) {

		drawingBoard = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		screen_pixels = ((DataBufferInt) drawingBoard.getRaster().getDataBuffer()).getData();

		setScreen_Width(width);
		setScreen_Height(height);
		setScreen_X_Pos(0);
		setScreen_Y_Pos(0);
	}

	public int getScreen_Width() {
		return Screen_Width;
	}

	public void setScreen_Width(int screen_Width) {
		Screen_Width = screen_Width;
	}

	public int getScreen_Height() {
		return Screen_Height;
	}

	public void setScreen_Height(int screen_Heiht) {
		Screen_Height = screen_Heiht;
	}

	public int getScreen_X_Pos() {
		return Screen_X_Pos;
	}

	public void setScreen_X_Pos(int screen_X_Pos) {
		Screen_X_Pos = screen_X_Pos;
	}

	public int getScreen_Y_Pos() {
		return Screen_Y_Pos;
	}

	public void setScreen_Y_Pos(int screen_Y_Pos) {
		Screen_Y_Pos = screen_Y_Pos;
	}

}
