package com.abraham.gfx;

public class Tile {
	public String TileName;
	private int squaredTSize;
	public int XPos;
	public int YPos;
	public int[] tilePixels;

	public Tile(String name,int size) {
		squaredTSize = size;
		tilePixels = new int[squaredTSize * squaredTSize];
		generateTileSprite();
	}

	public Tile(int MXPos, int MYPos, int size, SpriteSheet SS) {
		squaredTSize = size;
		tilePixels = new int[squaredTSize * squaredTSize];
		XPos = MXPos;
		YPos = MYPos;
		loadTileSprite(XPos, YPos, SS);
	}

	public void loadTileSprite(int xpos, int ypos, SpriteSheet SS) {
		for (int x = 0; x < squaredTSize; x++) {
			for (int y = 0; y < squaredTSize; y++) {
				tilePixels[x + (y * squaredTSize)] = SS.sheet_pixels[((xpos * squaredTSize) + x) + ((ypos * squaredTSize) + y) * SS.sheet_width];
			}
		}
	}

	public void generateTileSprite() {
		for (int i = 0; i < tilePixels.length; i++) {
			tilePixels[i] = (int) System.nanoTime() % 16;
		}
	}
}
