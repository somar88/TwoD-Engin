package com.abraham.gfx;

public class Sprite {

	public int sprite_width = 32;
	public int sprite_hight = 32;
	public int sprite_XPos;
	public int sprite_YPos;
	public int[] sprite = new int[sprite_width * sprite_hight];

	public static Sprite S = new Sprite(SpriteSheet.SS, 0, 0);

	public Sprite(SpriteSheet s_Sheet, int sprite_XPos, int sprite_YPos) {

		load_sprite(s_Sheet, sprite_XPos, sprite_YPos);
	}

	private void load_sprite(SpriteSheet s_Sheet, int sprite_XPos, int sprite_YPos) {
		if (s_Sheet.sheet_pixels != null) {
			for (int x = 0; x < sprite_width; x++) {
				for (int y = 0; y < sprite_hight; y++) {
					sprite[x + (y * sprite_width)] = s_Sheet.sheet_pixels[((sprite_XPos * sprite_width) + x) + ((sprite_YPos * sprite_width) + y) * s_Sheet.sheet_width];
				}
			}
		} else {
			System.out.println("There was no Sprit sheet loaded, check again!");
		}
	}

}