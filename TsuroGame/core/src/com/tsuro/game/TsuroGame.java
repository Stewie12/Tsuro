package com.tsuro.game;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tsuro.handlers.GameStateManager;

public class TsuroGame extends ApplicationAdapter {
	         
				/* Window Variables */
	public static final String TITLE = "Tsuro Board Game";
	public static final int V_WIDTH = 960;
	public static final int V_HEIGHT = 540;
	public static final int SCALE = 2;
	
				/* Set refresh rate */
	public static final float STEP = 1 / 60f;
	private float accum;		
	
	/* Main game spritebatch, camera, and gamestate manager declaration */
	private SpriteBatch sb;
	private OrthographicCamera cam;
	private GameStateManager gsm;
	
	/* Main list of tiles */
	public ArrayList<Sprite> tiles;
	
	public Texture texGrid;
	
	public Texture tile1, tile2, tile3, tile4, tile5, tile6, tile7, tile8, tile9, tile10, tile11, tile12, tile13,
	               tile14, tile15, tile16, tile17, tile18, tile19, tile20, tile21, tile22, tile23, tile24, tile25,
	               tile26, tile27, tile28, tile29, tile30, tile31, tile32, tile33, tile34, tile35,tile36;
	
	public Sprite sprite1, sprite2, sprite3, sprite4, sprite5, sprite6, sprite7, sprite8, sprite9, sprite10, sprite11, sprite12, sprite13,
				  sprite14, sprite15, sprite16, sprite17, sprite18, sprite19, sprite20, sprite21, sprite22, sprite23, sprite24, sprite25,
				  sprite26, sprite27, sprite28, sprite29, sprite30, sprite31, sprite32, sprite33, sprite34, sprite35, sprite36;
	
	public Sprite grid;
	
	@Override
	public void create () {
		
		gsm = new GameStateManager(this);
		sb = new SpriteBatch();
		cam = new OrthographicCamera();
		cam.setToOrtho(false, V_WIDTH, V_HEIGHT);
		
		generateGrid();
		buildTileArray();
	}

	@Override
	public void render () {
		
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		sb.begin();
		//sb.draw(tiles.get(0), 0, 0);
		//sprite1.draw(sb);
		drawGrid();
		drawSprites();
		sb.end();
		
		touchDown();
		
		accum += Gdx.graphics.getDeltaTime();
		while(accum >= STEP) {
			accum -= STEP;
			gsm.update(STEP);
			gsm.render();
		}
		
	}
		
	@Override
	public void dispose() {}
	
	public void touchDown() {
		if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			int x = Gdx.input.getX();
			int y = Gdx.input.getY();
			
			for (Sprite sprite : tiles) {
				if ((sprite.getX() <= x) &&
					(x <= sprite.getX() + sprite.getWidth()) &&
					(sprite.getY() <= (V_HEIGHT * SCALE - y)) &&
					((V_HEIGHT * SCALE - y) <= sprite.getY() + sprite.getHeight())) {
					
						sprite.rotate90(true);
					
				}
			}
			
		}
	}
	
	public SpriteBatch getSpriteBatch() { return sb; }
	public OrthographicCamera getCamera() { return cam; }
	
	private void generateGrid() {
		texGrid = new Texture("tsurogameboard.jpg");
		grid = new Sprite(texGrid);
		grid.setSize(800, 800);
		grid.setPosition(((V_WIDTH * SCALE) / 2) - (float)(0.5 * grid.getWidth()), V_HEIGHT * SCALE - grid.getHeight());
	}
	
	/* Add each tiles to the array */
	private void buildTileArray() {
		
		// Initialize Array
		tiles = new ArrayList<Sprite>();
		
		
		/* ****** ROW 1 ****** */
		
		tile1 = new Texture("gametiles/piece1.jpg");
		sprite1 = new Sprite(tile1);
		sprite1.setSize(150, 150);
		sprite1.setPosition(500, 50);
		tiles.add(sprite1);
		
		tile2 = new Texture("gametiles/piece2.jpg");
		sprite2 = new Sprite(tile2);
		sprite2.setSize(150, 150);
		sprite2.setPosition(900, 50);
		tiles.add(sprite2);
		
		
		tile3 = new Texture("gametiles/piece3.jpg");
		sprite3 = new Sprite(tile3);
		sprite3.setSize(150, 150);
		sprite3.setPosition(1300, 50);
		tiles.add(sprite3);
		/*
		tile4 = new Texture("gametiles/piece4.jpg");
		sprite4 = new Sprite(tile4);
		sprite4.setSize(106, 80);
		sprite4.setPosition(318, 400);
		tiles.add(sprite4);
		
		tile5 = new Texture("gametiles/piece5.jpg");
		sprite5 = new Sprite(tile5);
		sprite5.setSize(106, 80);
		sprite5.setPosition(424, 400);
		tiles.add(sprite5);
		
		tile6 = new Texture("gametiles/piece6.jpg");
		sprite6 = new Sprite(tile6);
		sprite6.setSize(106, 80);
		sprite6.setPosition(530, 400);
		tiles.add(sprite6);
		*/
		
		/* ****** ROW 2 ****** */
		/*
		tile7 = new Texture("gametiles/piece7.jpg");
		sprite7 = new Sprite(tile7);
		sprite7.setSize(106, 80);
		sprite7.setPosition(0, 320);
		tiles.add(sprite7);
		
		tile8 = new Texture("gametiles/piece8.jpg");
		sprite8 = new Sprite(tile8);
		sprite8.setSize(106, 80);
		sprite8.setPosition(106, 320);
		tiles.add(sprite8);
		
		tile9 = new Texture("gametiles/piece9.jpg");
		sprite9 = new Sprite(tile9);
		sprite9.setSize(106, 80);
		sprite9.setPosition(212, 320);
		tiles.add(sprite9);
		
		tile10 = new Texture("gametiles/piece10.jpg");
		sprite10 = new Sprite(tile10);
		sprite10.setSize(106, 80);
		sprite10.setPosition(318, 320);
		tiles.add(sprite10);
		
		tile11 = new Texture("gametiles/piece11.jpg");
		sprite11 = new Sprite(tile11);
		sprite11.setSize(106, 80);
		sprite11.setPosition(424, 320);
		tiles.add(sprite11);
		
		tile12 = new Texture("gametiles/piece12.jpg");
		sprite12 = new Sprite(tile12);
		sprite12.setSize(106, 80);
		sprite12.setPosition(530, 320);
		tiles.add(sprite12);
		*/
		
		/* ****** ROW 3 ****** */
		/*
		tile13 = new Texture("gametiles/piece13.jpg");
		sprite13 = new Sprite(tile13);
		sprite13.setSize(106, 80);
		sprite13.setPosition(0, 240);
		tiles.add(sprite13);
		
		tile14 = new Texture("gametiles/piece14.jpg");
		sprite14 = new Sprite(tile14);
		sprite14.setSize(106, 80);
		sprite14.setPosition(106, 240);
		tiles.add(sprite14);
		
		tile15 = new Texture("gametiles/piece15.jpg");
		sprite15 = new Sprite(tile15);
		sprite15.setSize(106, 80);
		sprite15.setPosition(212, 240);
		tiles.add(sprite15);
		
		tile16 = new Texture("gametiles/piece16.jpg");
		sprite16 = new Sprite(tile16);
		sprite16.setSize(106, 80);
		sprite16.setPosition(318, 240);
		tiles.add(sprite16);
		
		tile17 = new Texture("gametiles/piece17.jpg");
		sprite17 = new Sprite(tile17);
		sprite17.setSize(106, 80);
		sprite17.setPosition(424, 240);
		tiles.add(sprite17);
		
		tile18 = new Texture("gametiles/piece18.jpg");
		sprite18 = new Sprite(tile18);
		sprite18.setSize(106, 80);
		sprite18.setPosition(530, 240);
		tiles.add(sprite18);
		*/
		
		/* ****** ROW 4 ****** */
		
		/*
		tile19 = new Texture("gametiles/piece19.jpg");
		sprite19 = new Sprite(tile19);
		sprite19.setSize(106, 80);
		sprite19.setPosition(0, 160);
		tiles.add(sprite19);
		
		tile20 = new Texture("gametiles/piece20.jpg");
		sprite20 = new Sprite(tile20);
		sprite20.setSize(106, 80);
		sprite20.setPosition(106, 160);
		tiles.add(sprite20);
		
		tile21 = new Texture("gametiles/piece21.jpg");
		sprite21 = new Sprite(tile21);
		sprite21.setSize(106, 80);
		sprite21.setPosition(212, 160);
		tiles.add(sprite21);
		
		tile22 = new Texture("gametiles/piece22.jpg");
		sprite22 = new Sprite(tile22);
		sprite22.setSize(106, 80);
		sprite22.setPosition(318, 160);
		tiles.add(sprite22);
		
		tile23 = new Texture("gametiles/piece23.jpg");
		sprite23 = new Sprite(tile23);
		sprite23.setSize(106, 80);
		sprite23.setPosition(424, 160);
		tiles.add(sprite23);
		
		tile24 = new Texture("gametiles/piece24.jpg");
		sprite24 = new Sprite(tile24);
		sprite24.setSize(106, 80);
		sprite24.setPosition(530, 160);
		tiles.add(sprite24);
		*/
		
		/* ****** ROW 5 ****** */
		
		/*
		tile25 = new Texture("gametiles/piece25.jpg");
		sprite25 = new Sprite(tile25);
		sprite25.setSize(106, 80);
		sprite25.setPosition(0, 80);
		tiles.add(sprite25);
		
		tile26 = new Texture("gametiles/piece26.jpg");
		sprite26 = new Sprite(tile26);
		sprite26.setSize(106, 80);
		sprite26.setPosition(106, 80);
		tiles.add(sprite26);
		
		tile27 = new Texture("gametiles/piece27.jpg");
		sprite27 = new Sprite(tile27);
		sprite27.setSize(106, 80);
		sprite27.setPosition(212, 80);
		tiles.add(sprite27);
		
		tile28 = new Texture("gametiles/piece28.jpg");
		sprite28 = new Sprite(tile28);
		sprite28.setSize(106, 80);
		sprite28.setPosition(318, 80);
		tiles.add(sprite28);
		
		tile29 = new Texture("gametiles/piece29.jpg");
		sprite29 = new Sprite(tile29);
		sprite29.setSize(106, 80);
		sprite29.setPosition(424, 80);
		tiles.add(sprite29);
		
		tile30 = new Texture("gametiles/piece30.jpg");
		sprite30 = new Sprite(tile30);
		sprite30.setSize(106, 80);
		sprite30.setPosition(530, 80);
		tiles.add(sprite30);
		*/
		
		/* ****** ROW 6 ****** */
		
		/*
		tile31 = new Texture("gametiles/piece31.jpg");
		sprite31 = new Sprite(tile31);
		sprite31.setSize(106, 80);
		sprite31.setPosition(0, 0);
		tiles.add(sprite31);
		
		tile32 = new Texture("gametiles/piece32.jpg");
		sprite32 = new Sprite(tile32);
		sprite32.setSize(106, 80);
		sprite32.setPosition(106, 0);
		tiles.add(sprite32);
		
		tile33 = new Texture("gametiles/piece33.jpg");
		sprite33 = new Sprite(tile33);
		sprite33.setSize(106, 80);
		sprite33.setPosition(212, 0);
		tiles.add(sprite33);
		
		tile34 = new Texture("gametiles/piece34.jpg");
		sprite34 = new Sprite(tile34);
		sprite34.setSize(106, 80);
		sprite34.setPosition(318, 0);
		tiles.add(sprite34);
		
		tile35 = new Texture("gametiles/piece35.jpg");
		sprite35 = new Sprite(tile35);
		sprite35.setSize(106, 80);
		sprite35.setPosition(424, 0);
		tiles.add(sprite35);
		
		tile36 = new Texture("gametiles/piece36.jpg");
		sprite36 = new Sprite(tile36);
		sprite36.setSize(106, 80);
		sprite36.setPosition(530, 0);
		tiles.add(sprite36);
		*/
	}
	
	// Loop through array of tile sprites and draw them
	private void drawSprites() {
		for (Sprite sprite : tiles) {
			sprite.draw(sb);
		}
	}
	
	private void drawGrid() {
		grid.draw(sb);
	}
}
