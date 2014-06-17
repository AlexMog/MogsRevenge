package fr.alexmog.MogsRevenge.Map;

import java.util.Vector;

import com.badlogic.gdx.graphics.Texture;

public class Cell {
	private Vector<Attributes> attributes = new Vector<Attributes>();
	private Texture[] stages = new Texture[3]; // 0 = sol, 1 = au dessus du sol, sous le joueur, 2 = au dessus du sol, au dessus du joueur
	
	public void addAttribute(Attributes attribute) {
		attributes.add(attribute);
	}
	
	public void remAttribute(Attributes attribute) {
		attributes.remove(attribute);
	}
	
	public Vector<Attributes> getAttributes() {
		return (attributes);
	}
	
	public void setStage(int id, Texture texture) {
		stages[id] = texture;
	}
	
	public Texture[] getStages() {
		return (stages);
	}
	
	public Texture getStage(int id) {
		return (stages[id]);
	}
}
