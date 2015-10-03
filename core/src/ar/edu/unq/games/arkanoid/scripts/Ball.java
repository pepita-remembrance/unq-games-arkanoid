package ar.edu.unq.games.arkanoid.scripts;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.uwsoft.editor.renderer.components.DimensionsComponent;
import com.uwsoft.editor.renderer.components.physics.PhysicsBodyComponent;
import com.uwsoft.editor.renderer.scripts.IScript;
import com.uwsoft.editor.renderer.utils.ComponentRetriever;

public class Ball implements IScript {

    private Entity ball;
    private DimensionsComponent dimensionsComponent;
    private PhysicsBodyComponent physicsBodyComponent;
    private boolean isMoving = false;

    private World world;

    private Vector2 speed;

    public Ball(World world) {
        this.world = world;
    }


    @Override
    public void init(Entity entity) {
        ball = entity;

//        dimensionsComponent = ComponentRetriever.get(entity, DimensionsComponent.class);
        physicsBodyComponent = ComponentRetriever.get(entity, PhysicsBodyComponent.class);

        speed = new Vector2(0, 10);

    }

    @Override
    public void act(float delta) {
        if (!isMoving) {
            isMoving = true;
            physicsBodyComponent.body.applyForce(speed, new Vector2(0, 0), true);
        }
    }

    @Override
    public void dispose() {

    }

}
