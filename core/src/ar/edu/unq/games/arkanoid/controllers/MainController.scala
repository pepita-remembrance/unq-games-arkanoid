package ar.edu.unq.games.arkanoid.controllers

import ar.edu.unq.games.arkanoid.ArkanoidGame
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.{Gdx, ApplicationAdapter}
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class MainController extends ApplicationAdapter {
  var spriteBatch: SpriteBatch = _
  var arkanoidGame: ArkanoidGame = _

  override def create(): Unit = {
    spriteBatch = new SpriteBatch
    arkanoidGame = new ArkanoidGame
    arkanoidGame.init()
  }

  override def render(): Unit = {
    Gdx.gl.glClearColor(0, 0, 0, 1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    spriteBatch.begin()
    arkanoidGame.draw(spriteBatch)
    spriteBatch.end()
  }

}
