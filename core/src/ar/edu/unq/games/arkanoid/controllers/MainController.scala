package ar.edu.unq.games.arkanoid.controllers

import ar.edu.unq.games.arkanoid.ArkanoidGame
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class MainController extends ApplicationAdapter {
  var spriteBatch: SpriteBatch = _
  var arkanoidGame: ArkanoidGame = _

  override def create(): Unit = {
    spriteBatch = new SpriteBatch
    arkanoidGame = new ArkanoidGame
  }

  override def render(): Unit = arkanoidGame draw spriteBatch

}
