package fr.alexmog.MogsRevenge.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.alexmog.MogsRevenge.MogsRevenge;
import fr.alexmog.MogsRevenge.Ressources.RessourcesGestionnary;

public class LoadingScreen implements MyScreen {
	private SpriteBatch spriteBatch;
	private BitmapFont font;
	private MogsRevenge mogsRevenge;

	public LoadingScreen(MogsRevenge mogsRevenge) {
		this.mogsRevenge = mogsRevenge;
	}
	
	@Override
	public void create() {
		spriteBatch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		
		// LOADING FILES
		RessourcesGestionnary.getInstance().getAssetManager().load("data/images/backgrounds/main.jpeg", Texture.class);
		RessourcesGestionnary.getInstance().getAssetManager().load("data/images/map/Wall.png", Texture.class);
		RessourcesGestionnary.getInstance().getAssetManager().load("data/images/map/Grass.png", Texture.class);
		RessourcesGestionnary.getInstance().getAssetManager().load("data/images/entities/player/player.png", Texture.class);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		spriteBatch.begin();
		if (RessourcesGestionnary.getInstance().getAssetManager().update()) {
			mogsRevenge.setScreen(Screens.GAME);
			return ;
		}
		TextBounds bounds = font.getBounds(RessourcesGestionnary.getInstance().getAssetManager().getProgress() * 100 + "%");
		font.draw(spriteBatch,  RessourcesGestionnary.getInstance().getAssetManager().getProgress() * 100 + "%",
				(Gdx.graphics.getWidth() - bounds.width) / 2, (Gdx.graphics.getHeight() - bounds.height) / 2);
		spriteBatch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
