package ar.edu.unq.games.arkanoid.controllers;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.uwsoft.editor.renderer.SceneLoader;
import com.uwsoft.editor.renderer.utils.ItemWrapper;

import ar.edu.unq.games.arkanoid.scripts.Ball;
import ar.edu.unq.games.arkanoid.scripts.Bar;
import ar.edu.unq.games.arkanoid.stages.UIStage;

public class MainController extends ApplicationAdapter {

	private SceneLoader sceneLoader;
	private Viewport viewport;
	private Ball ball;
	private Bar bar;

	private UIStage uiStage;
    private Box2DDebugRenderer debugRenderer;

    @Override
	public void create () {
		viewport = new FitViewport(400, 300);
		sceneLoader = new SceneLoader();
		sceneLoader.loadScene("MainScene", viewport);

		ItemWrapper root = new ItemWrapper(sceneLoader.getRoot());
        debugRenderer = new Box2DDebugRenderer();
		bar = new Bar(sceneLoader.world);
		root.getChild("bar").addScript(bar);
		ball = new Ball(sceneLoader.world);
		root.getChild("ball").addScript(ball);

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
        debugRenderer.render(sceneLoader.world, viewport.getCamera().combined);

//		uiStage.act();
//		uiStage.draw();


	}
}
