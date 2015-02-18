package com.tsuro.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.tsuro.game.TsuroGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		
		cfg.title = TsuroGame.TITLE;
		cfg.height = TsuroGame.V_HEIGHT * TsuroGame.SCALE;
		cfg.width = TsuroGame.V_WIDTH * TsuroGame.SCALE;
		
		new LwjglApplication(new TsuroGame(), cfg);
	}
}
