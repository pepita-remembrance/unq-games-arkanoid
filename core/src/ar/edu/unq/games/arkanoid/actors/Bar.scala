package ar.edu.unq.games.arkanoid.actors

import ar.edu.unq.games.arkanoid.events._
import ar.edu.unq.games.arkanoid.inputProcessor.RxBus
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import rx.lang.scala.Subscription

class Bar extends Actor {
  var pos: Vector2 = _
  val bar = new Texture("barra.jpg")

  var movementDirection = 0

  var subscription:Subscription = _

  val inputConsumer: (RxEvent) => Unit = {

    case InputEvent(MoveLeft)  =>
      movementDirection =  -1

    case InputEvent(MoveRight) => movementDirection = 1
    case InputEvent(Stop)      => movementDirection = 0
  }

  override def init(): Unit = {
    super.init()
    pos = new Vector2(200f,200f)
    subscription = RxBus.toObservable.subscribe(inputConsumer)
  }

  override def draw(spriteBatch: SpriteBatch): Unit = {
    spriteBatch.draw(bar, pos.x, pos.y)
  }

  override def act(delta: Float): Unit = {
    pos = pos.add(50*delta*movementDirection, 0)
  }

  override def dispose(): Unit = {
    subscription.unsubscribe()
  }
}
