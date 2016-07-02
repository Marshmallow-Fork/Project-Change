package com.marshmallow.change;

import java.awt.Dimension;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.marshmallow.change.frames.Frame;
import com.marshmallow.change.frames.SplashFrame;
import com.marshmallow.change.utilities.InputHandler;

public class ProjectChange extends ApplicationAdapter {
	
	public static final String DEFAULT_TITLE = "Project Change";
	public static final String VERSION = "0.0.1";
	public static final int DEFAULT_WIDTH = 1080;
	public static final int DEFAULT_HEIGHT = 720;
	
	public static class AppDimensions {
		public static final Dimension X480_Y320 = new Dimension(480, 320);
		public static final Dimension X800_Y480 = new Dimension(800, 480);
		public static final Dimension X1080_Y720 = new Dimension(1080, 720);
		public static final Dimension X1960_Y1080 = new Dimension(1960, 1080);
	}
	
	public static boolean DEBUG = false;
	
	public InputHandler input;
	
	public SpriteBatch batch;
	public OrthographicCamera cam;
	
	private static Frame currentFrame;
	
	@Override
	public void create () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		input = new InputHandler();
		Gdx.input.setInputProcessor(input);
		batch = new SpriteBatch();
		cam = new OrthographicCamera(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		batch.setProjectionMatrix(cam.combined);
		
		currentFrame = new SplashFrame();
		
		if (DEBUG == true) {
			System.out.println("Debug Mode");
		}
	}

	@Override
	public void render () {
		input.preUpdate();
		currentFrame.update(Gdx.graphics.getDeltaTime());
		cam.update();
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		currentFrame.render(batch);
		batch.end();
		if(DEBUG == true) { currentFrame.debugRender(cam); }
		input.postUpdate();
	}
	
	public static void changeFrame(Frame frame) {
		currentFrame.hide();
		if(currentFrame != null) {
			currentFrame.dispose();
		}
		currentFrame = frame;
		currentFrame.show();
	}
}
