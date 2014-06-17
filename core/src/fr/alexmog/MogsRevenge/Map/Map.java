package fr.alexmog.MogsRevenge.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.alexmog.MogsRevenge.Datas.DataGestionnary;
import fr.alexmog.MogsRevenge.Entities.Entity;
import fr.alexmog.MogsRevenge.Ressources.RessourcesGestionnary;

public class Map {
	private Vector<Cell> cells = new Vector<Cell>();
	private int width, height;
	private SpriteBatch spriteBatch = new SpriteBatch();
	private List<Entity> entities = new ArrayList<Entity>();
	
	public Map(int width, int height) {
		this.width = width;
		this.height = height;
		cells.setSize(width * height);
	}
	
	public Cell getCell(int x, int y) {
		return (cells.get(x + y * width));
	}
	
	public void setCell(int x, int y, Cell value) {
		cells.set(x + y * width, value);
	}
	
	public void generateMap() {
		Random rand = DataGestionnary.getInstance().rand;
		
		for (int y = 0; y < height; ++y)
			for (int x = 0; x < width; ++x) {
				Cell cell = new Cell();
				cell.setStage(0, RessourcesGestionnary.getInstance().getAssetManager().get("data/images/map/Wall.png", Texture.class));
				setCell(x, y, cell);
			}
	}
	
	public void render(float delta, OrthographicCamera camera) {
		spriteBatch.begin();
		for (int y = 0; y < height; ++y)
			for (int x = 0; x < height; ++x) {
				Cell cell = getCell(x, y);
				if (cell.getStage(0) != null)
					spriteBatch.draw(cell.getStage(0), x * 32, y * 32, 32, 32);
				if (cell.getStage(1) != null)
					spriteBatch.draw(cell.getStage(1), x * 32, y * 32, 32, 32);
			}
		for (Entity entity : entities)
			entity.display(spriteBatch);
		for (int y = 0; y < height; ++y)
			for (int x = 0; x < height; ++x) {
				Cell cell = getCell(x, y);
				if (cell.getStage(2) != null)
					spriteBatch.draw(cell.getStage(2), x * 32, y * 32, 32, 32);
			}
		spriteBatch.end();
	}
}
