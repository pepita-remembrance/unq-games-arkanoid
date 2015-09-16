package ar.edu.unq.games.arkanoid.layers

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.{SpriteBatch, BitmapFont}

trait UILayer extends Layer {

  val font = new BitmapFont()
  val text = "hola"

  override def init(): Unit = {
    font.setColor(Color.WHITE)
    super.init()
  }

  override def draw(spriteBatch: SpriteBatch): Unit = {
    font.draw(spriteBatch, text, 20, 20)
    super.draw(spriteBatch)
  }
}
