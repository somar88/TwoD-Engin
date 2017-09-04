package com.abraham.gfx;

import java.awt.image.DataBufferInt;
import java.net.URL;
import javax.imageio.ImageIO;

public class SpriteSheet {

	public int sheet_width;
	public int sheet_height;
	public int[] sheet_pixels;
	public URL sheet_url;

	public SpriteSheet(String path) {
		
		try {
			sheet_url = new URL(path);
			this.sheet_height = ImageIO.read(sheet_url).getHeight();
			this.sheet_width = ImageIO.read(sheet_url).getWidth();
			sheet_pixels = ((DataBufferInt) (ImageIO.read(sheet_url)).getRaster().getDataBuffer()).getData();
		} catch (Exception e) {
			System.out.println("Image not found, please provide a valid URL");
		}
	}

}
