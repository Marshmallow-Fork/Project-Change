package com.marshmallow.change.backend.objects;

import com.marshmallow.change.backend.utilities.CollisionCallback;

public interface CollisionEntity {

	
	public void update(float delta);
	public void onCollision(CollisionCallback callback);
}
