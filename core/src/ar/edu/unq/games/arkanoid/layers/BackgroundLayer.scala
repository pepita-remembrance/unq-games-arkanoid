package ar.edu.unq.games.arkanoid.layers

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch

trait BackgroundLayer extends Layer {

  val background = new Texture("background.jpg")

  override def draw(spriteBatch: SpriteBatch): Unit = {
    spriteBatch.draw(background, 0, 0)
    super.draw(spriteBatch)
  }

}
