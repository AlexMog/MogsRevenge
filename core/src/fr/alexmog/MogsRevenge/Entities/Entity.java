package fr.alexmog.MogsRevenge.Entities;

import com.badlogic.gdx.math.Vector2;

public abstract class Entity implements IEntity {
	protected int life;
	protected Vector2 pos;
	protected float speed;
	protected int size;
	
	public void setLife(int life) {
		this.life = life;
	}
	
	public int getLife() {
		return (life);
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return (size);
	}
	
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	public float getSpeed() {
		return (speed);
	}
	
	public Vector2 getPos() {
		return (pos);
	}
	
	public void setPos(Vector2 pos) {
		this.pos = pos;
	}
	
	public void goRight(float delta) {
		pos.x += speed * delta;
	}
	
	public void goLeft(float delta) {
		pos.x -= speed * delta;
	}
	
	public void goUp(float delta) {
		pos.y += speed * delta;
	}
	
	public void goDown(float delta) {
		pos.y -= speed * delta;
	}
}
