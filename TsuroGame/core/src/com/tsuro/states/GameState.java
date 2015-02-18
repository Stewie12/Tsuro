package com.tsuro.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tsuro.game.TsuroGame;
import com.tsuro.handlers.GameStateManager;

public abstract class GameState {
	
	protected GameStateManager gsm;
	protected TsuroGame tsuro;
	
	// ?
	protected SpriteBatch sb;
	protected OrthographicCamera cam;
	
	protected GameState(GameStateManager gsm) {
		this.gsm = gsm;
		tsuro = gsm.getTsuro();
		sb = tsuro.getSpriteBatch();
		cam = tsuro.getCamera();
	}
	
	public abstract void handleInput();
	public abstract void update(float dt);
	public abstract void render();
	public abstract void dispose();
	
}
