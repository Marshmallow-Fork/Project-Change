package com.marshmallow.change.backend.utilities;

import com.marshmallow.change.backend.objects.Entity;

/**
 * Contains information on 
 * @author Northern Sprint
 *
 */
public class CollisionCallback {

	private Entity other;
	private Entity root;
	
	public CollisionCallback(Entity root, Entity other) {
		this.root = root;
		this.other = other;
	}

	public Entity getOther() { return other; }
	public Entity getRoot() { return root; }
}
