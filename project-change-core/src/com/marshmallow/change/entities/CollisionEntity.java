package com.marshmallow.change.entities;

import com.marshmallow.change.utilities.CollisionCallback;

public interface CollisionEntity {

	
	public void update(float delta);
	public void onCollision(CollisionCallback callback);
}
