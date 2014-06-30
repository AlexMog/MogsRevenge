package fr.alexmog.MogsRevenge.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

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
		Vector<Vector2> road = new Vector<Vector2>();
		
		// Generate a fxcking road!
		int roadSize = rand.nextInt(20) + 50;
		System.out.println("Road size: " + roadSize);
		road.setSize(roadSize);
		int xStart = rand.nextInt(width - 1) + 1;
		int yStart = rand.nextInt(height - 1) + 1;
		road.set(0, new Vector2(xStart, yStart));
		int way = 0;
		for (int i = 1; i < roadSize; ++i)
		{
			boolean alreadyPassed = false;
			int newSens = rand.nextInt(100);
			if (newSens <= 10)
				way++;
			else if (newSens >= 10 && newSens <= 20)
				way--;
			Vector2 newVector = new Vector2();
			if (way == 0) // Up
			{
				newVector.x = road.get(i - 1).x;
				newVector.y = road.get(i - 1).y + 1;
			}
			else if (way == 1) // Right
			{
				newVector.x = road.get(i - 1).x + 1;
				newVector.y = road.get(i - 1).y;
			}
			else if (way == 2) // Down
			{
				newVector.x = road.get(i - 1).x;
				newVector.y = road.get(i - 1).y - 1;
			}
			else if (way == 3) // Left
			{
				newVector.x = road.get(i - 1).x - 1;
				newVector.y = road.get(i - 1).y;
			}
			System.out.println("Trying Cell: " + newVector.x + ", " + newVector.y);
			if (newVector.x >= width || newVector.y >= height
					|| newVector.x <= 0 || newVector.y <= 0)
			{
				i--;
				System.out.println("\tNot validated.");
				continue;
			}
			for (int j = 0; j < i; ++j) {
				Vector2 roadCell = road.get(j);
				if (roadCell.x == newVector.x && roadCell.y == newVector.y) {
					alreadyPassed = true;
					break;
				}
			}
			if (alreadyPassed)
			{
				i--;
				System.out.println("\tNot validated.");
			}else {
				road.set(i, newVector);
				System.out.println("\tValidated!");
			}
		}
		
		for (int y = 0; y < height; ++y)
			for (int x = 0; x < width; ++x) {
				boolean isRoad = false;
				Cell cell = new Cell();
				for (Vector2 roadCell : road) {
					if (roadCell.x == x && roadCell.y == y) {
						isRoad = true;
						break;
					}
				}
				if (!isRoad)
					cell.setStage(0, RessourcesGestionnary.getInstance().getAssetManager().get("data/images/map/Wall.png", Texture.class));
				else
					cell.setStage(0, RessourcesGestionnary.getInstance().getAssetManager().get("data/images/map/Grass.png", Texture.class));
				setCell(x, y, cell);
			}
	}
	
	public void render(float delta, OrthographicCamera camera) {
		spriteBatch.setProjectionMatrix(camera.combined);
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
