package com.cpnv.angrybob3;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cpnv.angrybob3.Models.Activities.GameActivityManager;
import com.cpnv.angrybob3.Models.Activities.Welcome;
import com.cpnv.angrybob3.Providers.FontProvider;

import java.util.Random;

public class AngryBob extends ApplicationAdapter {

	private Music music;
	public static Random random;
	static public GameActivityManager gameActivityManager = new GameActivityManager();

	@Override
	public void create () {

		// Music
		music = Gdx.audio.newMusic(Gdx.files.internal("lacoucatrouba.mp3"));
		music.setLooping(true);
		music.setVolume(1f);
		music.play();

		random = new Random();
		FontProvider.load();
		gameActivityManager.push(new Welcome());
	}

	@Override
	public void render () {
		gameActivityManager.handleInput();
		gameActivityManager.update(Gdx.graphics.getDeltaTime());
		gameActivityManager.render();
	}
	
	@Override
	public void dispose () {
	}
}
