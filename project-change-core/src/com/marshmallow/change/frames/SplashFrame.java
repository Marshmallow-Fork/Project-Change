package com.marshmallow.change.frames;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.marshmallow.change.backend.handlers.EntityHandler;
import com.marshmallow.change.backend.handlers.InputHandler;
import com.marshmallow.change.backend.objects.Entity;
import com.marshmallow.change.backend.objects.Frame;
import com.marshmallow.change.backend.utilities.Buttons;
import com.marshmallow.change.entities.Barrier;
import com.marshmallow.change.entities.Player;

public class SplashFrame implements Frame {

	public EntityHandler entities;
	
	public SplashFrame() {
		entities = new EntityHandler();
		entities.addEntity(new Player(0, 0, 16, 16, 32, 32, 1, 1, 0, Gdx.files.internal("images/icon32.png")));
	}

	@Override
	public void show() {
		
	}

	@Override
	public void update(float delta) {
		entities.update(delta);
		if(InputHandler.isKeyPressed(Buttons.LEFT)) {
			System.out.println("BOOP!");
		}
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
