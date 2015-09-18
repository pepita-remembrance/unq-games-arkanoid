package ar.edu.unq.games.arkanoid.inputProcessor

import ar.edu.unq.games.arkanoid.events._
import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.InputAdapter

class ArkanoidInputProcessor extends InputAdapter {

  override def keyDown(keycode: Int): Boolean = {
    keycode match {
      case Keys.LEFT  => MoveLeft.send()
      case Keys.RIGHT => MoveRight.send()
      case _ =>
    }
    true
  }

  override def keyUp(keycode: Int): Boolean = {
    keycode match {
      case Keys.LEFT | Keys.RIGHT => Stop.send()
      case _ =>
    }
    true
  }

}


