package fr.alexmog.MogsRevenge.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import fr.alexmog.MogsRevenge.MogsRevenge;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 800;
		config.height = 600;
		config.resizable = false;
		config.title = "Mon jeu qui tue sa race!";
		
		new LwjglApplication(new MogsRevenge(), config);
	}
}
