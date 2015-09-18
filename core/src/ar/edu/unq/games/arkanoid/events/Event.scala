package ar.edu.unq.games.arkanoid.events

trait RxEvent
case class InputEvent(input:InputEventType) extends RxEvent


trait InputEventType {
  def send(): Unit ={
    RxBus.send(InputEvent(this))
  }
}

object MoveLeft  extends InputEventType
object MoveRight extends InputEventType
object Stop      extends InputEventType
