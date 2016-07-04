package com.marshmallow.change.entities;

import com.badlogic.gdx.files.FileHandle;
import com.marshmallow.change.backend.objects.MovableEntity;

public class Player extends MovableEntity {

	public Player (float x, float y, float originX, float originY,
			float width, float height, float scaleX, float scaleY,
			float degrees, FileHandle texture) {
		super(x, y, originX, originY, width, height, scaleX, scaleY, degrees,
				texture);
	}
	
	public void update(float delta) {
		super.update(delta);
	}
}
