package com.abraham.gfx;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Map {

	private int map_width;
	private int map_height;

	public int[] map_pixels;

	public Map() {
		map_width = 640;
		map_height = map_width * (9 / 16);
	}

	public Map(String path) {
		map_load(path);
	}

	private void map_load(String path) {
		try {
			BufferedImage map_img = ImageIO.read(SpriteSheet.class.getResourceAsStream(path));
			map_height = map_img.getHeight();
			map_width = map_img.getWidth();
			map_pixels = new int[map_height * map_width];
			map_img.getRGB(0, 0, map_img.getWidth(), map_img.getHeight(), map_pixels, 0, map_img.getWidth());
			// System.out.println("Map is loaded and ready.\n");
		} catch (Exception e) {
			System.out.println("Error by Loading Map image image:\n");
			System.out.println(e.getMessage());
		}
	}

	public int getMap_width() {
		return map_width;
	}

	public int getMap_height() {
		return map_height;
	}

	public void setMap_width(int map_width) {
		this.map_width = map_width;
	}

	public void setMap_height(int map_height) {
		this.map_height = map_height;
	}

}
