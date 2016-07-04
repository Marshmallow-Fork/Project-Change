package com.marshmallow.change.backend.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.Vector2;
import com.marshmallow.change.backend.handlers.InputHandler;

public class MovableEntity extends SolidEntity {

	private float direction;
	private float speed, maxSpeed;
	private float accel, friction;
	
	public MovableEntity(float x, float y, float originX, float originY,
			float width, float height, float scaleX, float scaleY,
			float degrees, FileHandle texture) {
		super(x, y, originX, originY, width, height, scaleX, scaleY, degrees,
				texture);
		direction = 0;
		speed = 0;
		maxSpeed = 5;
		accel = 0;
		friction = 3;
	}
	
	public MovableEntity() {
		this(0f,0f,8f,8f,16f,16f,1f,1f,0f,Gdx.files.internal("images/icon16.png"));
	}

	@Override
	public void update(float delta) {
		super.update(delta);
		
		Vector2 temp = InputHandler.getPAD(); 
		
		accel = temp.len() * 5;
		if(accel > 0) {
			direction = temp.angleRad();
		}
		
		speed = Math.min(maxSpeed, delta * (accel - friction) + speed);
		if(speed < 0) { speed = 0; }
		
		pos.add((float)Math.cos(direction) * speed, (float)Math.sin(direction) * speed);
	}
}
