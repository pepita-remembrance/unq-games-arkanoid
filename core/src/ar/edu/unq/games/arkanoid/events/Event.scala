package ar.edu.unq.games.arkanoid.events

import ar.edu.unq.games.arkanoid.actors.PhysicActor

trait RxEvent
case class InputEvent(input:InputEventType) extends RxEvent

case class Collision(actor1:PhysicActor, actor2:PhysicActor) extends RxEvent

trait InputEventType {
  def send(): Unit ={
    RxBus.send(InputEvent(this))
  }
}

object MoveLeft  extends InputEventType
object MoveRight extends InputEventType
object Stop      extends InputEventType
