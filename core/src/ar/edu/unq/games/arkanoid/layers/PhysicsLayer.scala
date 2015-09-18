package ar.edu.unq.games.arkanoid.layers

import ar.edu.unq.games.arkanoid.actors.Bar
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.World

import scala.collection.mutable.ListBuffer

trait PhysicsLayer extends Layer {
  var world: World = _

  lazy val physicElements = ListBuffer(new Bar)

  override def init(): Unit = {
    world = new World(new Vector2(0f, 0f), true)
    physicElements.foreach(_.init())
    super.init()
  }

  override def act(delta: Float): Unit = {
    world.step(delta, 8, 3)
    physicElements.foreach(_.act(delta))
    super.act(delta)
  }

  override def draw(spriteBatch: SpriteBatch): Unit = {
    physicElements.foreach(_.draw(spriteBatch))
    super.draw(spriteBatch)
  }

  override def dispose(): Unit = {
    world.dispose()
    physicElements.foreach(_.dispose())
    super.dispose()
  }
}
