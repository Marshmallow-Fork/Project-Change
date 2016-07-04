package com.marshmallow.change.backend.objects;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

public class SolidEntity extends Entity{


	private Rectangle bounds;
	private ShapeRenderer sRen;
	
	public SolidEntity(float x, float y, float originX, float originY,
			float width, float height, float scaleX, float scaleY,
			float degrees, FileHandle texture) {
		super(x, y, originX, originY, scaleX, scaleY, texture);
		
		sRen = new ShapeRenderer();
		bounds = new Rectangle(x - originX, y - originY, width, height);

	}

	public void update(float delta) {
		super.update(delta);
		bounds.setPosition(pos.x - origin.x, pos.y - origin.y);
	}
	
	public void debugDraw(OrthographicCamera cam) {
		sRen.setProjectionMatrix(cam.combined);
		sRen.begin(ShapeType.Line);
		sRen.setColor(Color.GOLD);
		sRen.rect(bounds.x, bounds.y, origin.x, origin.y, bounds.width, bounds.height, 1, 1, 0);
		sRen.end();
	}


	public Rectangle getBounds() { return bounds; }
	public void setBounds(Rectangle param) { bounds.set(param); }
}
