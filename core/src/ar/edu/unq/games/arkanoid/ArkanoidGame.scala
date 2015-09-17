package ar.edu.unq.games.arkanoid

import ar.edu.unq.games.arkanoid.inputProcessor.ArkanoidInputProcessor
import ar.edu.unq.games.arkanoid.layers.{PhysicsLayer, UILayer, BackgroundLayer, Layer}
import com.badlogic.gdx.Gdx

class ArkanoidGame extends Layer
  with UILayer
  with PhysicsLayer
  with BackgroundLayer {

  override def init(): Unit = {
    val inputProcessor: ArkanoidInputProcessor = new ArkanoidInputProcessor
    Gdx.input.setInputProcessor(inputProcessor)
    super.init()
  }

}