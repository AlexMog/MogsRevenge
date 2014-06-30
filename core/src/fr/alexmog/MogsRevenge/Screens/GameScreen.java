package fr.alexmog.MogsRevenge.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.alexmog.MogsRevenge.MogsRevenge;
import fr.alexmog.MogsRevenge.Datas.DataGestionnary;
import fr.alexmog.MogsRevenge.Map.Map;

public class GameScreen implements MyScreen {
	private Map map;
	private OrthographicCamera camera;
	private OrthographicCamera guiCamera;
	private BitmapFont font;
	private SpriteBatch batch;
	private float fpsTimer;
	private int fps;

	public GameScreen(MogsRevenge mogsRevenge) {
		// TODO Auto-generated constructor stubgrass.jpg
	}

	@Override
	public void render(float delta) {
		// UPDATE
		if (Gdx.input.isKeyPressed(Keys.UP))
			camera.position.y += 200 * delta;
		else if (Gdx.input.isKeyPressed(Keys.DOWN))
			camera.position.y -= 200 * delta;
		if (Gdx.input.isKeyPressed(Keys.RIGHT))
			camera.position.x += 200 * delta;
		else if (Gdx.input.isKeyPressed(Keys.LEFT))
			camera.position.x -= 200 * delta;
		camera.update();
		guiCamera.update();

		// DRAWS
		Gdx.gl.glClearColor(0f, 0f, 0f, 0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		map.render(delta, camera);
		
		// DrawFPS
		batch.setProjectionMatrix(guiCamera.combined);
		batch.begin();
		if (fpsTimer >= 1) {
			fps = (int)(1 / delta);
			fpsTimer = 0;
		}
		font.draw(batch, "FPS: " + fps, 1, 1);
		batch.end();
		fpsTimer += delta;
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		map = new Map(20, 20);
		map.generateMap();
		DataGestionnary.getInstance().setMap(map);
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
		font.dispose();
		batch.dispose();
	}

	@Override
	public void create() {
		camera = new OrthographicCamera(800, 600);
		font = new BitmapFont();
		guiCamera = new OrthographicCamera(800, 600);
		guiCamera.translate(400, -300);
		batch = new SpriteBatch();
	}

}
