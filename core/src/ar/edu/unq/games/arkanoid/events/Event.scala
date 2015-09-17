package ar.edu.unq.games.arkanoid.events

import ar.edu.unq.games.arkanoid.inputProcessor.RxBus


trait RxEvent
case class InputEvent(input:InputEventType) extends RxEvent


trait InputEventType {
  def send(): Unit ={
    RxBus.send(InputEvent(this))
  }
}
case class MoveLeft(isPressed:Boolean) extends InputEventType
case class MoveRight(isPressed:Boolean) extends InputEventType