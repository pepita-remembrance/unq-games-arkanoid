package ar.edu.unq.games.arkanoid.inputProcessor

import ar.edu.unq.games.arkanoid.events.{MoveRight, MoveLeft, InputEvent, RxEvent}
import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.InputAdapter
import rx.lang.scala.{Subject, Observable}
import rx.lang.scala.subjects.{PublishSubject, SerializedSubject}

class ArkanoidInputProcessor extends InputAdapter {

  override def keyDown(keycode: Int): Boolean = {
    keycode match {
      case Keys.LEFT => MoveLeft(isPressed=true).send()
      case Keys.RIGHT => MoveRight(isPressed=true).send()
    }
    true
  }

  override def keyUp(keycode: Int): Boolean = {
    keycode match {
      case Keys.LEFT => MoveLeft(isPressed=false).send()
      case Keys.RIGHT => MoveRight(isPressed=false).send()
    }
    true
  }

}

object RxBus {
  val _bus:Subject[RxEvent] = new SerializedSubject[RxEvent](PublishSubject())
  def send(o:RxEvent) = _bus.onNext(o)
  def toObservable:Observable[RxEvent] = _bus
}
