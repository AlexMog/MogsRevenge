package fr.alexmog.MogsRevenge.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

import fr.alexmog.MogsRevenge.MogsRevenge;
import fr.alexmog.MogsRevenge.Datas.DataGestionnary;
import fr.alexmog.MogsRevenge.Map.Map;

public class GameScreen implements MyScreen {
	private Map map;
	private OrthographicCamera camera;

	public GameScreen(MogsRevenge mogsRevenge) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(float delta) {
		// UPDATE
		camera.update();

		// DRAWS
		Gdx.gl.glClearColor(0f, 0f, 0f, 0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		map.render(delta, camera);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create() {
		camera = new OrthographicCamera(800, 600);
	}

}
