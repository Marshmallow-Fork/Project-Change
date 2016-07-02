package com.marshmallow.change.desktop;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.marshmallow.change.ProjectChange;

public class DesktopLauncher {
	public static void main (String[] arg) {
		for(int i = 0;i < arg.length;i++) {
			if(arg[i].equals("debug")) { ProjectChange.DEBUG = true; }
		}
		
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = ProjectChange.DEFAULT_TITLE + " - " + ProjectChange.VERSION;
		config.width = ProjectChange.DEFAULT_WIDTH;
		config.height = ProjectChange.DEFAULT_HEIGHT;
		config.resizable = false;
		config.addIcon("images/icon128.png", FileType.Internal);
		config.addIcon("images/icon32.png", FileType.Internal);
		config.addIcon("images/icon16.png", FileType.Internal);
		
		new LwjglApplication(new ProjectChange(), config);
	}
}
