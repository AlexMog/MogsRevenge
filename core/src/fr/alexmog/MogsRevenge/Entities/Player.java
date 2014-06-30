package fr.alexmog.MogsRevenge.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import fr.alexmog.MogsRevenge.Map.Attributes;
import fr.alexmog.MogsRevenge.Map.Cell;
import fr.alexmog.MogsRevenge.Ressources.RessourcesGestionnary;

public class Player extends Entity {
	private Texture texture;
	private Vector2 lastPos;

	public Player(Vector2 vector2) {
		this.setPos(vector2);
		texture = RessourcesGestionnary.getInstance().getAssetManager().get("data/images/entities/player/player.png", Texture.class);
		this.setLife(10);
		this.setSpeed(10);
		this.setSize(32);
	}

	@Override
	public void display(SpriteBatch spriteBatch) {
		// Displays only a small ugly thing
		spriteBatch.draw(texture, this.pos.x * size, this.pos.y * size, this.size, this.size);
	}
	
	private void updateKeys(float delta) {
		lastPos = new Vector2(this.pos.x, this.pos.y);
		if (Gdx.input.isKeyPressed(Keys.Z))
			this.goUp(delta);
		else if (Gdx.input.isKeyPressed(Keys.S))
			this.goDown(delta);
		if (Gdx.input.isKeyPressed(Keys.Q))
			this.goLeft(delta);
		else if (Gdx.input.isKeyPressed(Keys.D))
			this.goRight(delta);
	}

	@Override
	public void update(float delta) {
		updateKeys(delta);
	}

	@Override
	public void onInterraction(IEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onInterraction(Cell cell) {
		if (cell.getAttributes().contains(Attributes.BLOCKING))
			this.pos = lastPos;
	}

}
