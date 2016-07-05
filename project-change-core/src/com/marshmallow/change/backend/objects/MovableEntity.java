package com.marshmallow.change.backend.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.Vector2;
import com.marshmallow.change.backend.handlers.InputHandler;

public class MovableEntity extends SolidEntity {

	private float direction;
	private float maxSpeed;
	private float friction, iFr, accel;
	private Vector2 nA, oA, dA, speed;
	private Vector2 nF;
	
	public MovableEntity(float x, float y, float originX, float originY,
			float width, float height, float scaleX, float scaleY,
			float degrees, FileHandle texture) {
		super(x, y, originX, originY, width, height, scaleX, scaleY, degrees,
				texture);
		direction = 0;
		speed = new Vector2();
		maxSpeed = 5;
		nA = new Vector2();
		oA = new Vector2();
		oA = new Vector2();
		friction = 0.99f;
		iFr = 1/(1-friction) - 1;
		accel = 3;
		nF = new Vector2();
	}
	
	public MovableEntity() {
		this(0f,0f,8f,8f,16f,16f,1f,1f,0f,Gdx.files.internal("images/icon16.png"));
	}

	@Override
	public void update(float delta) {
		super.update(delta);
		
		nF.scl(0);
		nA = InputHandler.getPAD(); 
		
		//Add Anti Movement Acceleration
		float temp = maxSpeed * friction * delta;
		if(speed.isZero(temp)) {
			speed.scl(0);
		}
		dA = speed.cpy().setLength(temp);
		System.out.println("Deccel - " + dA.len());
		nF.add(dA.scl(-1));
		
		//Add Movement Acceleration
		nA.scl(iFr * delta * accel);
		System.out.println("Accel  - " + nA.len());
		nF.add(nA); 
		
		speed.add(nF);
		
		speed.limit(maxSpeed);
		pos.add(speed);
		
		//oA.lerp(nA.scl(accel), accel * delta * (1 - friction));
		//if(oA.len() > 0) {
		//	direction = oA.angleRad();
		//}
		
		//if(oA.len() > 0) {
		//	speed.add(oA.cpy().scl(accel * delta * (1 - friction)));
		//}
		//else {
		//	speed.lerp(speed.cpy().scl(-1), delta * (1 - friction));
		//}
	}
}
