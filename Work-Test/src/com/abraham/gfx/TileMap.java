package com.abraham.gfx;

public class TileMap {

	private int map_width;
	private int map_height;
	public Tile[] Tiles;
	public int[] map_pixels;

	public static Map emptyMap = new Map("/SpriteSheets/MiscDummy.png");

	public TileMap(int width, int height) {
		map_height = height;
		map_width = width;
		map_pixels = new int[map_height * map_width];
		map_generate();
	}

	public TileMap(String path) {
		map_load(path);
	}

	private void map_load(String path) {

	}

	private void map_generate() {
		for (int x = 0; x < map_width; x++) {
			for (int y = 0; y < map_height; y++) {
				map_pixels[x + (y * map_width)] = 0xff00ff;
			}
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
