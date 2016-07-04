package com.marshmallow.change.entities;

import com.badlogic.gdx.files.FileHandle;
import com.marshmallow.change.backend.objects.Entity;
import com.marshmallow.change.backend.objects.SolidEntity;
import com.marshmallow.change.backend.utilities.CollisionCallback;

public class Barrier extends SolidEntity {

	public Barrier(float x, float y, float originX, float originY, float width,
			float height, float scaleX, float scaleY, float degrees,
			FileHandle texture) {
		super(x, y, originX, originY, width, height, scaleX, scaleY, degrees,
				texture);
	}
	
	@Override
	public void onCollision(CollisionCallback c) {
		System.out.println("Collision");
		c.getOther().setPosition((float)Math.random() * 300 - 150, (float)Math.random() * 300 - 150);
	}

}
