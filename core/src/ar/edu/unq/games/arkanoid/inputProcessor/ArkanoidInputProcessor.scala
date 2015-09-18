package ar.edu.unq.games.arkanoid.inputProcessor

import ar.edu.unq.games.arkanoid.events._
import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.{Gdx, InputAdapter}
import rx.lang.scala.{Subject, Observable}
import rx.lang.scala.subjects.{PublishSubject, SerializedSubject}

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

object RxBus {
  val _bus:Subject[RxEvent] = SerializedSubject[RxEvent](PublishSubject())
  def send(o:RxEvent) = {
    Gdx.app.log("RxBus", s"SEND $o")
    _bus.onNext(o)
  }
  def toObservable:Observable[RxEvent] = _bus
}
