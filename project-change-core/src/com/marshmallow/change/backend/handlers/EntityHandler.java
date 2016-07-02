package com.marshmallow.change.backend.handlers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.marshmallow.change.backend.objects.Entity;
import com.marshmallow.change.backend.utilities.CollisionCallback;

public class EntityHandler {

	protected Array<Entity> entities;
	
	public EntityHandler() {
		entities = new Array<Entity>();
	}

	public void update(float delta) {
		for(int i = 0; i < entities.size; i++) {
			entities.get(i).update(delta);
		}
		
		for(int i = 0; i < entities.size; i++) {
			for(int n = 0; n < entities.size; n++) {
				if (i != n && entities.get(i).getBounds().overlaps(entities.get(n).getBounds())) {
					entities.get(i).onCollision(new CollisionCallback(entities.get(i), entities.get(n)));
				}
			}
			entities.get(i).update(delta);
		}
	}
	
	public void render(SpriteBatch batch) {
		for(int i = 0; i < entities.size; i++) {
			entities.get(i).draw(batch);
		}
	}
	
	public void debugRender(OrthographicCamera cam) {
		for(int i = 0; i < entities.size; i++) {
			entities.get(i).debugDraw(cam);
		}
	}
	
	public void addEntity(Entity ent) {
		this.entities.add(ent);
	}
	
	public void removeEntity(Entity entity) {
		entities.removeValue(entity, false);
	}
	
	public void removeEntityByClass(Class<Entity> c) {
		for(int i = entities.size - 1; i >= 0; i--) {
			if (entities.get(i).getClass().equals(c)) {
				entities.removeIndex(i);
			}
		}
	}
}
