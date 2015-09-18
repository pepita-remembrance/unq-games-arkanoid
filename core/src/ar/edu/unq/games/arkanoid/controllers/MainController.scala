package ar.edu.unq.games.arkanoid.controllers

import ar.edu.unq.games.arkanoid.ArkanoidGame
import com.badlogic.gdx.graphics.{OrthographicCamera, GL20}
import com.badlogic.gdx.{Gdx, ApplicationAdapter}
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class MainController extends ApplicationAdapter {
  val VIEWPORT_WIDTH  = 5.0f
  val VIEWPORT_HEIGHT = 5.0f

  var spriteBatch: SpriteBatch = _
  var arkanoidGame: ArkanoidGame = _

  lazy val camera = new OrthographicCamera( 30, 30*( Gdx.graphics.getHeight/ Gdx.graphics.getWidth))

  override def create(): Unit = {
    spriteBatch = new SpriteBatch
    arkanoidGame = new ArkanoidGame
    camera.position.set(0f,0f,0f)
    camera.update()
    arkanoidGame.init()
  }

  override def render(): Unit = {

    Gdx.gl.glClearColor(0, 0, 0, 1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

    spriteBatch.begin()
    arkanoidGame.act(Gdx.graphics.getDeltaTime)
    arkanoidGame.draw(spriteBatch)
    spriteBatch.end()
  }

  override def resize(width: Int, height: Int): Unit = {
    super.resize(width, height)
    camera.viewportWidth = (VIEWPORT_HEIGHT/height)*width
    camera.update()
    arkanoidGame.resize(width,height)
  }
}
