package com.marshmallow.change.backend.objects;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.marshmallow.change.backend.utilities.CollisionCallback;

public class Entity implements Collidible{
	
	protected String[] tag;
	
	protected Texture image;
	protected Sprite sprite;
	
	protected Vector2 pos;
	protected Vector2 origin;
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param originX
	 * @param originY
	 * @param width
	 * @param height
	 * @param scaleX
	 * @param scaleY
	 * @param degrees
	 * @param texture
	 */
	public Entity(float x, float y, float originX, float originY, float scaleX, float scaleY, FileHandle texture) {
		pos = new Vector2(x, y);
		origin = new Vector2(originX, originY);
		
		image = new Texture(texture);
		sprite = new Sprite(image);
		sprite.setScale(scaleX, scaleY);
	}

	
 	public void update(float delta) {
		sprite.setPosition(pos.x - origin.x, pos.y - origin.y);
	}
	
	/**
	 * Must be surrounded by {@link SpriteBatch#begin() SpriteBatch.begin()} and {@link SpriteBatch#end() SpriteBatch.end()} */
	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
	}
	
	public void dispose() {
		image.dispose();
	}
	
	public void onCollision(CollisionCallback callback) {}
	public Vector2 getPosition() { return pos; }
	public Vector2 getOrigin() { return origin; }
	

	public void setX(float val) { this.pos.x = val; }
	public void setY(float val) { this.pos.y = val; }
	public void setPosition(float x, float y) { this.pos.set(x, y); }
	public void setPosition(Vector2 pos) { this.pos.set(pos); }
	
	public void setOriginX(float val) { this.origin.x = val; }
	public void setOriginY(float val) { this.origin.y = val; }
	public void setOrigin(float x, float y) { this.origin.set(x, y); }
	public void setOrigin(Vector2 origin) { this.origin.set(origin); }
}
