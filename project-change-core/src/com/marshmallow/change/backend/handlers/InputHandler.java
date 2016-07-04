package com.marshmallow.change.backend.handlers;


import com.badlogic.gdx.InputAdapter;

public class InputHandler extends InputAdapter {
	
	public static final int numKeys = 255;
	
	private static Boolean oState[] = new Boolean[numKeys];
	private static Boolean cState[] = new Boolean[numKeys];
	private static Boolean p[] = new Boolean[numKeys];
	private static Boolean r[] = new Boolean[numKeys];
	
	public InputHandler() {
		for (int i = 0; i < numKeys; i++) {
			oState[i] = false;
			cState[i] = false;
			p[i] = false;
			r[i] = false;
		}
	}

	public void update() {
		for(int i = 0; i < numKeys; i++) {
			p[i] = false;
			if(oState[i] != cState[i] && cState[i] == true) {
				p[i] = true;
			}
			
			oState[i] = cState[i];
			
			if(r[i] == true) {
				cState[i] = false;
				r[i] = false;
			}
		}
	}
	
	public static boolean isKeyPressed(int keycode) {
		return p[keycode];
	}

	public static boolean isKeyHeld(int keycode) {
		return cState[keycode];
	}
	
	public static boolean isKeyReleased(int keycode) {
		return r[keycode];
	}
	
	@Override
	public boolean keyDown(int keycode) {
		cState[keycode] = true;
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		r[keycode] = true;
		return false;
	}
	
	/*
	 // Currently unimplemented Mouse Input //
	
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
	
	*/

}
