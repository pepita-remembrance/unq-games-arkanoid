package ar.edu.unq.games.arkanoid.actors

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.World

trait Actor {

  def init():Unit={}

  def pos:Vector2

  def act(delta: Float)

  def draw(spriteBatch: SpriteBatch)

  def dispose():Unit={}

}

trait PhysicActor extends Actor {
  def init(world:World):Unit = {
    init()
  }

  override def act(delta: Float): Unit = {}
}

