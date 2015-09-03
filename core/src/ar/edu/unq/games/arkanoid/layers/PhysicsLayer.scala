package ar.edu.unq.games.arkanoid.layers

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.World

trait PhysicsLayer extends Layer {
  var world: World = _

  override def init(): Unit = {
    world = new World(new Vector2(0f, 0f), true)
    super.init()
  }

  override def act(delta: Float): Unit = {
    world.step(delta, 8, 3)
    super.act(delta)
  }

  override def draw(spriteBatch: SpriteBatch): Unit = {
    super.draw(spriteBatch)
  }

  override def dispose(): Unit = {
    world.dispose()
    super.dispose()
  }
}
