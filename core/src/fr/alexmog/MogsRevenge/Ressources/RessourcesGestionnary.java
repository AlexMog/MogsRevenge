package fr.alexmog.MogsRevenge.Ressources;

import com.badlogic.gdx.assets.AssetManager;

// LETS DO A FUCKING CLASS OMG!
public class RessourcesGestionnary {
	private static RessourcesGestionnary instance;
	private AssetManager assetManager = new AssetManager();
	
	private RessourcesGestionnary() {} // HAHA! CANNOT BE INSTANCIATED BIATCH!
	
	public static RessourcesGestionnary getInstance() {
		return (instance == null ? (instance = new RessourcesGestionnary()) : instance);
	}
	
	public AssetManager getAssetManager() {
		return (assetManager);
	}
}
