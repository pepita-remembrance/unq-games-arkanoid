package ar.edu.unq.games.arkanoid

import ar.edu.unq.games.arkanoid.layers.{BackgroundLayer, Layer}
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class ArkanoidGame extends Layer with BackgroundLayer {

  override def draw(spriteBatch: SpriteBatch): Unit = {
    Gdx.gl.glClearColor(0, 0, 0, 1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    spriteBatch.begin()
    super.draw(spriteBatch)
    spriteBatch.end()
  }

}