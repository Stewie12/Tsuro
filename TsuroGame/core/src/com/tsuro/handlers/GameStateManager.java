package com.tsuro.handlers;

import java.util.Stack;

import com.tsuro.game.TsuroGame;
import com.tsuro.states.GameState;
import com.tsuro.states.Play;

public class GameStateManager {
	
	private TsuroGame tsuro;
	private Stack<GameState> gameStates;
	
	public static final int PLAY = 9999;
	
	public GameStateManager(TsuroGame tsuro) {
		this.tsuro = tsuro;
		gameStates = new Stack<GameState>();
		pushState(PLAY);
	}
	
	public TsuroGame getTsuro() { return tsuro; }
	
	public void update(float dt) {
		gameStates.peek().update(dt);
	}
	
	public void render() {
		gameStates.peek().render();
	}
	
	private GameState getState(int state) {
		if (state == PLAY) return new Play(this);
		return null;
	}
	
	public void setState(int state) {
		popState();
		pushState(state);
	}
	
	public void pushState(int state) {
		gameStates.push(getState(state));
	}
	
	public void popState() {
		GameState g = gameStates.pop();
		g.dispose();
	}
}
