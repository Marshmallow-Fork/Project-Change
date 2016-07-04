package com.marshmallow.change.backend.objects;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Frame {
	
	/** Called when this screen becomes the current screen. */
	public void show ();

	/** Called when the frame should update itself.
	 * @param delta The time in seconds since the last update. */
	public void update (float delta);

	/** Called when the frame should render itself.
	 * @param batch The global {@link SpriteBatch SpriteBatch}, DO NOT create a new batch. */
	public void render (SpriteBatch batch);

	/**  */
	public void debugRender (OrthographicCamera cam);

	/** @see ApplicationListener#resize(int, int) */
	public void resize (int width, int height);

	/** Called when this screen is no longer the current screen. */
	public void hide ();

	/** Called when this screen should release all resources. */
	public void dispose ();
}
