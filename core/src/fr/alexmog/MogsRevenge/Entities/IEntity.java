package fr.alexmog.MogsRevenge.Entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface IEntity {
	public void display(SpriteBatch spriteBatch);
	public void update();
}
