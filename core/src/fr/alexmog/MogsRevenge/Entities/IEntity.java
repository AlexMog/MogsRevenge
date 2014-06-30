package fr.alexmog.MogsRevenge.Entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.alexmog.MogsRevenge.Map.Cell;

public interface IEntity {
	public void display(SpriteBatch spriteBatch);
	public void update(float delta);
	public void onInterraction(IEntity entity);
	public void onInterraction(Cell cell);
}
