package com.cpnv.angrybob3;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Music;
import com.cpnv.angrybob3.Providers.FontProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

// Import all activities
import com.cpnv.angrybob3.Activities.*;


public class AngryBob extends Game {

	private static AngryBob angryBob;

	public static AngryBob getInstance() {
		return angryBob == null ? angryBob = new AngryBob() : angryBob;
	}

	private Stack<Game> gameActivities;

	private HashMap<ACTIVITY, Game>  activityGameMap;

	public enum ACTIVITY {
		Pause,
		Play,
		Score,
		Welcome,
		MenuSelector,
		GameOver
	}

	// Music Core
	private Music music;

	// General Random
	public static Random random;

	@Override
	public void create () {

		// Prepare the (Hash)Map
		activityGameMap = new HashMap<>();
		activityGameMap.put(ACTIVITY.Welcome, new Welcome());
		activityGameMap.put(ACTIVITY.Play, new Play());
		activityGameMap.put(ACTIVITY.Pause, new Pause());
		activityGameMap.put(ACTIVITY.Score, new Score());
		activityGameMap.put(ACTIVITY.GameOver, new GameOver());

		// Music
		music = Gdx.audio.newMusic(Gdx.files.internal("lacoucatrouba.mp3"));
		music.setLooping(true);
		music.setVolume(1f);
		music.play();

		// Create a new Random object
		random = new Random();

		// Load Font Provider
		FontProvider.load();

		gameActivities = new Stack<>();

		// Display Loading Scene
		push(ACTIVITY.Welcome);

		//gameActivities.push(new Welcome());
	}

	public void push(ACTIVITY activity) {
		// Extract Key-Value
		Game game = activityGameMap.get(activity);
		game.create();
		gameActivities.push(game);
		updateInputActivity();
	}

	public void pop(){
		gameActivities.pop();
		updateInputActivity();
	}

	public void updateInputActivity(){
		Gdx.input.setInputProcessor((InputProcessor) gameActivities.peek());
	}

	@Override
	public void render () {
		gameActivities.peek().render();
	}
	
	@Override
	public void dispose () {
		super.dispose();
	}
}
