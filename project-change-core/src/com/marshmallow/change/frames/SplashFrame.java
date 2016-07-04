package com.marshmallow.change.frames;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.marshmallow.change.backend.handlers.EntityHandler;
import com.marshmallow.change.backend.handlers.InputHandler;
import com.marshmallow.change.backend.objects.Entity;
import com.marshmallow.change.backend.objects.Frame;
import com.marshmallow.change.backend.utilities.Buttons;
import com.marshmallow.change.entities.Barrier;

public class SplashFrame implements Frame {

	public EntityHandler barriers;
	
	public SplashFrame() {
		barriers = new EntityHandler();
		barriers.addEntity(new Barrier(0, 0, 16, 16, 32, 32, 1, 1, 0, Gdx.files.internal("images/icon32.png")));
		barriers.addEntity(new Barrier(0, 0, 16, 16, 32, 32, 1, 1, 0, Gdx.files.internal("images/icon32.png")));
	}

	@Override
	public void show() {
		
	}

	@Override
	public void update(float delta) {
		barriers.update(delta);
		if(InputHandler.isKeyPressed(Buttons.LEFT)) {
			System.out.println("BOOP!");
		}
	}

	@Override
	public void render(SpriteBatch batch) {
		barriers.render(batch);
	}
	
	public void debugRender(OrthographicCamera cam) {
		barriers.debugRender(cam);
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
