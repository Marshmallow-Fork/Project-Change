package com.marshmallow.change.backend.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class MovableEntity extends Entity {

	private float direction;
	private float speed;
	private float acceleration;
	
	public MovableEntity(float x, float y, float originX, float originY,
			float width, float height, float scaleX, float scaleY,
			float degrees, FileHandle texture) {
		super(x, y, originX, originY, width, height, scaleX, scaleY, degrees,
				texture);
		direction = 0;
	}
	
	public MovableEntity() {
		this(0f,0f,8f,8f,16f,16f,1f,1f,0f,Gdx.files.internal("images/icon16.png"));
	}

	@Override
	public void update(float delta) {
		super.update(delta);
		
	}
}
