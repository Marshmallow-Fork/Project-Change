package com.marshmallow.change.frames;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.marshmallow.change.entities.Barrier;
import com.marshmallow.change.entities.Entity;
import com.marshmallow.change.utilities.EntityHandler;

public class SplashFrame implements Frame {

	public EntityHandler entities;
	public Entity temp;
	
	public SplashFrame() {
		entities = new EntityHandler();
		entities.addEntity(new Barrier(0, 0, 16, 16, 32, 32, 1, 1, 0, Gdx.files.internal("images/icon32.png")));
		temp = new Barrier(50, 50, 16, 16, 32, 32, 1, 1, 0, Gdx.files.internal("images/icon32.png"));
	}

	@Override
	public void show() {
		
	}

	@Override
	public void update(float delta) {
		 entities.update(delta);
		 temp.update(delta);
	}

	@Override
	public void render(SpriteBatch batch) {
		entities.render(batch);
		temp.draw(batch);
	}
	
	public void debugRender(OrthographicCamera cam) {
		entities.debugRender(cam);
		temp.debugDraw(cam);
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		
	}

}
