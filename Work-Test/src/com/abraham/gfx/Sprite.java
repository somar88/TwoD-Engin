package com.abraham.gfx;

public class Sprite {

	public int sprite_width = 32;
	public int sprite_length = 32;
	public int sprite_XPos;
	public int sprite_YPos;
	public int[] sprite;

	public Sprite(SpriteSheet s_Sheet, int sprite_XPos, int sprite_YPos) {
		load_sprite(s_Sheet, sprite_XPos, sprite_YPos);
	}

	private void load_sprite(SpriteSheet s_Sheet, int sprite_XPos, int sprite_YPos) {
		for (int x = 0; x < sprite_width; x++) {
			for (int y = 0; y < sprite_length; y++) {
				sprite[x + (y * sprite_width)] = s_Sheet.sheet_pixels[((sprite_XPos * sprite_width) + x)
						+ ((sprite_YPos * sprite_width) + y)];
			}
		}
	}

}