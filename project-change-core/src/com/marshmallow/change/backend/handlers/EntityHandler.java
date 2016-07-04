package com.marshmallow.change.backend.handlers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.marshmallow.change.backend.objects.Collidible;
import com.marshmallow.change.backend.objects.Entity;
import com.marshmallow.change.backend.objects.SolidEntity;
import com.marshmallow.change.backend.utilities.CollisionCallback;

public class EntityHandler {

	protected Array<Entity> entities;
	protected Array<SolidEntity> collidible;
	
	public EntityHandler() {
		entities = new Array<Entity>();
		collidible = new Array<SolidEntity>();
	}

	public void update(float delta) {
		for(int i = 0; i < entities.size; i++) {
			entities.get(i).update(delta);
		}
		for(int i = 0; i < collidible.size; i++) {
			collidible.get(i).update(delta);
		}
		
		for(int i = 0; i < collidible.size; i++) {
			for(int n = 0; n < collidible.size; n++) {
				if (i != n && collidible.get(i).getBounds().overlaps(collidible.get(n).getBounds())) {
					collidible.get(i).onCollision(new CollisionCallback(collidible.get(i), collidible.get(n)));
				}
			}
			collidible.get(i).update(delta);
		}
	}
	
	public void render(SpriteBatch batch) {
		for(int i = 0; i < entities.size; i++) {
			entities.get(i).draw(batch);
		}
		for(int i = 0; i < collidible.size; i++) {
			collidible.get(i).draw(batch);
		}
	}
	
	public void debugRender(OrthographicCamera cam) {
		//for(int i = 0; i < entities.size; i++) {
		//	entities.get(i).debugDraw(cam);
		//}
	}
	
	public void addEntity(Entity ent) {
		this.entities.add(ent);
	}
	
	public void addEntity(SolidEntity ent) {
		this.collidible.add(ent);
	}
	
	public void removeEntity(Entity entity) {
		entities.removeValue(entity, false);
	}
	
	public void removeEntity(SolidEntity entity) {
		collidible.removeValue(entity, false);
	}
	
	public void removeEntitiesByClass(Class<Entity> c) {
		for(int i = entities.size - 1; i >= 0; i--) {
			if (entities.get(i).getClass().equals(c)) {
				entities.get(i).dispose();
				entities.removeIndex(i);
			}
		}
		for(int i = collidible.size - 1; i >= 0; i--) {
			if (collidible.get(i).getClass().equals(c)) {
				collidible.get(i).dispose();
				collidible.removeIndex(i);
			}
		}
	}
}
