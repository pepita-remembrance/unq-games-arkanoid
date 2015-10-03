package ar.edu.unq.games.arkanoid.scripts;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.uwsoft.editor.renderer.components.DimensionsComponent;
import com.uwsoft.editor.renderer.components.TransformComponent;
import com.uwsoft.editor.renderer.components.physics.PhysicsBodyComponent;
import com.uwsoft.editor.renderer.scripts.IScript;
import com.uwsoft.editor.renderer.utils.ComponentRetriever;

/**
 * Created by azakhary on 8/4/2015.
 */
public class Player implements IScript {

    private Entity player;
    private TransformComponent transformComponent;
    private DimensionsComponent dimensionsComponent;
    private PhysicsBodyComponent physicsBodyComponent;

    private World world;

    private Vector2 speedLeft;
    private Vector2 speedRight;
    private Vector2 speedStop;

    public Player(World world) {
        this.world = world;
    }


    @Override
    public void init(Entity entity) {
        player = entity;

        dimensionsComponent = ComponentRetriever.get(entity, DimensionsComponent.class);
        physicsBodyComponent = ComponentRetriever.get(entity, PhysicsBodyComponent.class);

        speedLeft = new Vector2(-20, 0);
        speedRight = new Vector2(20, 0);
        speedStop = new Vector2(0, 0);
    }

    @Override
    public void act(float delta) {

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            physicsBodyComponent.body.setLinearVelocity(speedLeft);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            physicsBodyComponent.body.setLinearVelocity(speedRight);
        } else {
            physicsBodyComponent.body.setLinearVelocity(speedStop);
        }

    }

//    private void rayCast() {
//        float rayGap = dimensionsComponent.height/2;
//
//        // Ray size is the exact size of the deltaY change we plan for this frame
//        float raySize = -(speedLeft.y)*Gdx.graphics.getDeltaTime();
//
//        //if(raySize < 5f) raySize = 5f;
//
//        // only check for collisions when moving down
//        if(speedLeft.y > 0) return;
//
//        // Vectors of ray from middle middle
//        Vector2 rayFrom = new Vector2((transformComponent.x+dimensionsComponent.width/2)*PhysicsBodyLoader.getScale(), (transformComponent.y+rayGap)* PhysicsBodyLoader.getScale());
//        Vector2 rayTo = new Vector2((transformComponent.x+dimensionsComponent.width/2)*PhysicsBodyLoader.getScale(), (transformComponent.y - raySize)*PhysicsBodyLoader.getScale());
//
//        // Cast the ray
//        world.rayCast(new RayCastCallback() {
//            @Override
//            public float reportRayFixture(Fixture fixture, Vector2 point, Vector2 normal, float fraction) {
//                // Stop the player
//                speedLeft.y = 0;
//
//                // reposition player slightly upper the collision point
//                transformComponent.y  = point.y / PhysicsBodyLoader.getScale() + 0.01f;
//
//                return 0;
//            }
//        }, rayFrom, rayTo);
//    }

    public float getX() {
        return transformComponent.x;
    }

    public float getY() {
        return transformComponent.y;
    }

    @Override
    public void dispose() {

    }

    public float getWidth() {
        return dimensionsComponent.width;
    }
}
