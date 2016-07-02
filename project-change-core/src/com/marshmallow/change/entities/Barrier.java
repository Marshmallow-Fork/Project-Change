package com.marshmallow.change.entities;

import com.badlogic.gdx.files.FileHandle;
import com.marshmallow.change.backend.objects.Entity;

public class Barrier extends Entity {

	public Barrier(float x, float y, float originX, float originY, float width,
			float height, float scaleX, float scaleY, float degrees,
			FileHandle texture) {
		super(x, y, originX, originY, width, height, scaleX, scaleY, degrees,
				texture);
	}

}
