package com.marshmallow.change.frames;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.marshmallow.change.backend.handlers.EntityHandler;
import com.marshmallow.change.backend.objects.Entity;
import com.marshmallow.change.entities.Barrier;

public class SplashFrame implements Frame {

	public EntityHandler entities;
	
	public SplashFrame() {
		entities = new EntityHandler();
		entities.addEntity(new Barrier(0, 0, 16, 16, 32, 32, 1, 1, 0, Gdx.files.internal("images/icon32.png")));
		entities.addEntity(new Barrier(0, 0, 16, 16, 32, 32, 1, 1, 0, Gdx.files.internal("images/icon32.png")));
	}

	@Override
	public void show() {
		
	}

	@Override
	public void update(float delta) {
		 entities.update(delta);
	}

	@Override
	public void render(SpriteBatch batch) {
		entities.render(batch);
	}
	
	public void debugRender(OrthographicCamera cam) {
		entities.debugRender(cam);
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
