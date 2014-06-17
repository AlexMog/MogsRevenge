package fr.alexmog.MogsRevenge.Datas;

import java.util.Random;

import fr.alexmog.MogsRevenge.Map.Map;

public class DataGestionnary {
	private static DataGestionnary instance;
	private Map map;
	public Random rand = new Random();
	
	public static DataGestionnary getInstance() {
		return (instance == null ? (instance = new DataGestionnary()) : instance);
	}
	
	public void setMap(Map map2) {
		this.map = map2;
	}
	
	public Map getMap() {
		return (map);
	}
}
