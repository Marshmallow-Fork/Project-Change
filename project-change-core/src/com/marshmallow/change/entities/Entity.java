package com.marshmallow.change.entities;

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
import com.marshmallow.change.utilities.CollisionCallback;

public class Entity implements CollisionEntity{
	
	private String[] tag;
	
	private Texture img;
	private Sprite spr;
	
	private Vector2 pos;
	private Vector2 origin;
	private Rectangle bounds;
	private ShapeRenderer sRen;
	private float rotation;
	
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
	public Entity(float x, float y, float originX, float originY, float width, float height, float scaleX, float scaleY, float degrees, FileHandle texture) {
		pos = new Vector2(x, y);
		origin = new Vector2(originX, originY);
		bounds = new Rectangle(x - originX, y - originY, width, height);
		
		rotation = 0.0f;
		rotate(degrees);
		
		img = new Texture(texture);
		spr = new Sprite(img);
		
		sRen = new ShapeRenderer();
	}

	public void update(float delta) {
		spr.setPosition(pos.x - origin.x, pos.y - origin.y);
		spr.setRotation(rotation);
		
	}
	
	/**
	 * Must be surrounded by {@link SpriteBatch#begin() SpriteBatch.begin()} and {@link SpriteBatch#end() SpriteBatch.end()} */
	public void draw(SpriteBatch batch) {
		spr.draw(batch);
	}
	
	public void debugDraw(OrthographicCamera cam) {
		sRen.setProjectionMatrix(cam.combined);
		sRen.begin(ShapeType.Line);
		sRen.setColor(Color.GOLD);
		sRen.rect(bounds.x, bounds.y, origin.x, origin.y, bounds.width, bounds.height, 1, 1, 0);
		sRen.end();
	}
	
	public void rotate(float degrees) {}
	
	public void dispose() {
		sRen.dispose();
		img.dispose();
	}
	
	public void onCollision(CollisionCallback callback) {}

	public Rectangle getBounds() { return bounds; }
	public Vector2 getPosition() { return pos; }
	public Vector2 getOrigin() { return origin; }
	public float getRotation() { return rotation; }
	
	public void setBounds(Rectangle param) { bounds.set(param); }
	public void setPosition(Vector2 param) { pos.set(param); }
	public void setPosition(float x, float y) { pos.set(x, y); }
	public void setOrigin(Vector2 param) { origin.set(param); }
	public void setOrigin(float x, float y) { origin.set(x, y); }
	public void setRotation(float param) { rotation = param; }
}
