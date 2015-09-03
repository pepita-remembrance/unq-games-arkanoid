package ar.edu.unq.games.arkanoid.layers

import com.badlogic.gdx.graphics.g2d.SpriteBatch

trait PhysicsLayer extends Layer {
//  var world:World

  override def init(): Unit = {
    super.init()
  }

  override def act(delta: Float): Unit = super.act(delta)

  override def draw(spriteBatch: SpriteBatch): Unit = super.draw(spriteBatch)
}
