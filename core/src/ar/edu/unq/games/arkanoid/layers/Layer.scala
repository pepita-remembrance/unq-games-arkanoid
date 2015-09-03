package ar.edu.unq.games.arkanoid.layers

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.Disposable

trait Layer extends Disposable {

  def dispose() {}

  def init() {}

  def act(delta: Float) {}

  def draw(spriteBatch: SpriteBatch) {}

  def resize(width: Int, height: Int) {}

  def pause() {}

  def resume() {}
}
