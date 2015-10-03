package ar.edu.unq.games.arkanoid.controllers;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.uwsoft.editor.renderer.SceneLoader;
import com.uwsoft.editor.renderer.utils.ItemWrapper;

import ar.edu.unq.games.arkanoid.components.PlatformComponent;
import ar.edu.unq.games.arkanoid.systems.PlatformSystem;
import ar.edu.unq.games.arkanoid.scripts.Player;
import ar.edu.unq.games.arkanoid.stages.UIStage;

public class MainController extends ApplicationAdapter {

	private SceneLoader sceneLoader;
	private Viewport viewport;
	private Player player;

	private UIStage uiStage;

	@Override
	public void create () {
		viewport = new FitViewport(400, 300);
		sceneLoader = new SceneLoader();
		sceneLoader.loadScene("MainScene", viewport);

		ItemWrapper root = new ItemWrapper(sceneLoader.getRoot());

		player = new Player(sceneLoader.world);
		root.getChild("bar").addScript(player);

//		uiStage = new UIStage(sceneLoader.getRm());

//        sceneLoader.addComponentsByTagName("platform", PlatformComponent.class);
//        sceneLoader.addComponentsByTagName("block", PlatformComponent.class);

//        sceneLoader.getEngine().addSystem(new PlatformSystem());
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		sceneLoader.getEngine().update(Gdx.graphics.getDeltaTime());

//		uiStage.act();
//		uiStage.draw();

	}
}
