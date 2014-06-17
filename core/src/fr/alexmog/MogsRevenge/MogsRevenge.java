package fr.alexmog.MogsRevenge;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

import fr.alexmog.MogsRevenge.Screens.GameScreen;
import fr.alexmog.MogsRevenge.Screens.LoadingScreen;
import fr.alexmog.MogsRevenge.Screens.MyScreen;
import fr.alexmog.MogsRevenge.Screens.Screens;

public class MogsRevenge extends Game {
	private HashMap<Screens, MyScreen> screens = new HashMap<Screens, MyScreen>();
	
	public void setScreen(Screens screen) {
		setScreen(screens.get(screen));
	}

	@Override
	public void create() {
		screens.put(Screens.GAME, new GameScreen(this));
		screens.put(Screens.LOAD, new LoadingScreen(this));
		Set<Screens> set = screens.keySet();
		Iterator<Screens> it = set.iterator();
		while (it.hasNext())
		{
			Screens id = it.next();
			MyScreen screen = screens.get(id);
			screen.create();
		}
		setScreen(Screens.LOAD);
	}

	@Override
	public void dispose() {
		Set<Screens> set = screens.keySet();
		Iterator<Screens> it = set.iterator();
		while (it.hasNext())
		{
			Screens id = it.next();
			Screen screen = screens.get(id);
			screen.dispose();
		}
	}
}
