package ar.edu.unq.games.arkanoid.layers

import com.badlogic.gdx.graphics.g2d.SpriteBatch

trait LayerGroup extends Layer {

  def layers: List[Layer]

  override def init(): Unit = propagate(_.init())

  override def act(delta: Float): Unit = propagate(_.act(delta))

  override def resize(width: Int, height: Int): Unit = propagate(_.resize(width, height))

  override def dispose(): Unit = propagate(_.dispose())

  override def pause(): Unit = propagate(_.pause())

  override def draw(spriteBatch: SpriteBatch): Unit = propagate(_.draw(spriteBatch))

  override def resume(): Unit = propagate(_.resume())

  private def propagate(function: Layer => Unit) = layers.foreach(function)

}
