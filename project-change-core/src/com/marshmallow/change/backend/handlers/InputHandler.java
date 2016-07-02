package com.marshmallow.change.backend.handlers;


import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class InputHandler extends InputAdapter {

	public static final int numKeys = 8;
	public static final int KEY_ARROWUP = 0;
	public static final int KEY_ARROWDOWN = 1;
	public static final int KEY_ARROWLEFT = 2;
	public static final int KEY_ARROWRIGHT = 3;
	public static final int KEY_W = 4;
	public static final int KEY_S = 5;
	public static final int KEY_A = 6;
	public static final int KEY_D = 7;

	private Vector2 lDir = new Vector2();
	private Vector2 rDir = new Vector2();
	
	private Boolean k_held[] = new Boolean[numKeys];
	private Boolean k_pressed[] = new Boolean[numKeys];
	private Boolean k_released[] = new Boolean[numKeys];
	
	public InputHandler() {
		System.out.println("INITIALIZING");
		for (int i = 0; i < numKeys; i++) {
			k_held[i] = false;
			k_pressed[i] = false;
			k_released[i] = false;
		}
	}

	public void preUpdate() {
		updateLeftDirectional();
		updateRightDirectional();
	}

	private void updateLeftDirectional() {
		if((k_pressed[KEY_W] == true || k_held[KEY_W] == true) && !(k_pressed[KEY_S] == true || k_held[KEY_S] == true)) {
			lDir.set(lDir.x, 1);
		}
		else if(!(k_pressed[KEY_W] == true || k_held[KEY_W] == true) && (k_pressed[KEY_S] == true || k_held[KEY_S] == true)) {
			lDir.set(lDir.x, -1);
		}
		else {
			lDir.set(lDir.x, 0);
		}
		
		if((k_pressed[KEY_D] == true || k_held[KEY_D] == true) && !(k_pressed[KEY_A] == true || k_held[KEY_A] == true)) {
			lDir.set(1f, lDir.y);
		}
		else if(!(k_pressed[KEY_D] == true || k_held[KEY_D] == true) && (k_pressed[KEY_A] == true || k_held[KEY_A] == true)) {
			lDir.set(-1f, lDir.y);
		}
		else {
			lDir.set(0f, lDir.y);
		}
		
		if(!lDir.isZero()) {
			lDir.setLength(1f);
		}
	}

	private void updateRightDirectional() {
		if((k_pressed[KEY_ARROWUP] == true || k_held[KEY_ARROWUP] == true) && !(k_pressed[KEY_ARROWDOWN] == true || k_held[KEY_ARROWDOWN] == true)) {
			rDir.set(rDir.x, 1);
		}
		else if(!(k_pressed[KEY_ARROWUP] == true || k_held[KEY_ARROWUP] == true) && (k_pressed[KEY_ARROWDOWN] == true || k_held[KEY_ARROWDOWN] == true)) {
			rDir.set(rDir.x, -1);
		}
		else {
			rDir.set(rDir.x, 0);
		}
		
		if(!(k_pressed[KEY_ARROWLEFT] == true || k_held[KEY_ARROWLEFT] == true) && (k_pressed[KEY_ARROWRIGHT] == true || k_held[KEY_ARROWRIGHT] == true)) {
			rDir.set(1f, rDir.y);
		}
		else if((k_pressed[KEY_ARROWLEFT] == true || k_held[KEY_ARROWLEFT] == true) && !(k_pressed[KEY_ARROWRIGHT] == true || k_held[KEY_ARROWRIGHT] == true)) {
			rDir.set(-1f, rDir.y);
		}
		else {
			rDir.set(0f, rDir.y);
		}
		
		if(!rDir.isZero()) {
			rDir.setLength(1f);
		}
	}
	
	public void postUpdate() {
		for(int i = 0; i < numKeys; i++) {
			if(k_pressed[i] == true) {
				k_held[i] = k_pressed[i];
				k_pressed[i] = false;
			}
			if(k_released[i] == true) {
				k_held[i] = false;
				k_pressed[i] = false;
				k_released[i] = false;
			}
		}
	}
	
	@Override
	public boolean keyDown(int keycode) {
		System.out.println("Pressed " + keycode);
		switch(keycode) {
		case Keys.UP:
			k_pressed[KEY_ARROWUP] = true;
			break;
		case Keys.DOWN:
			k_pressed[KEY_ARROWDOWN] = true;
			break;
		case Keys.LEFT:
			k_pressed[KEY_ARROWLEFT] = true;
			break;
		case Keys.RIGHT:
			k_pressed[KEY_ARROWRIGHT] = true;
			break;
		case Keys.W:
			k_pressed[KEY_W] = true;
			break;
		case Keys.S:
			k_pressed[KEY_S] = true;
			break;
		case Keys.A:
			k_pressed[KEY_A] = true;
			break;
		case Keys.D:
			k_pressed[KEY_D] = true;
			break;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		System.out.println("Released " + keycode);
		switch(keycode) {
		case Keys.UP:
			k_released[KEY_ARROWUP] = true;
			break;
		case Keys.DOWN:
			k_released[KEY_ARROWDOWN] = true;
			break;
		case Keys.LEFT:
			k_released[KEY_ARROWLEFT] = true;
			break;
		case Keys.RIGHT:
			k_released[KEY_ARROWRIGHT] = true;
			break;
		case Keys.W:
			k_released[KEY_W] = true;
			break;
		case Keys.S:
			k_released[KEY_S] = true;
			break;
		case Keys.A:
			k_released[KEY_A] = true;
			break;
		case Keys.D:
			k_released[KEY_D] = true;
			break;
		}
		return false;
	}
	
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

}
