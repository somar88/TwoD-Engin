package com.abraham.gfx;

import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

public class SpriteSheet {

	public URL sheet_url;
	public int sheet_width;
	public int sheet_height;
	private BufferedImage sheet_img;
	public int[] sheet_pixels;

	public static SpriteSheet SS = new SpriteSheet("/SpriteSheets/MiscDummy.png");

	public SpriteSheet(String path) {

		try {
			sheet_img = ImageIO.read(SpriteSheet.class.getResourceAsStream(path));
			sheet_height = sheet_img.getHeight();
			sheet_width = sheet_img.getWidth();
			sheet_pixels = new int[sheet_height * sheet_width];
			sheet_img.getRGB(0, 0, sheet_img.getWidth(), sheet_img.getHeight(), sheet_pixels, 0, sheet_img.getWidth());
			// System.out.println("Sprite sheet loaded and ready.\n");
		} catch (Exception e) {

			System.out.println("Error by Loading Spritesheet image:\n");
			System.out.println(e.getMessage());
		}
	}

}
