package ar.edu.unq.games.arkanoid.actors

import ar.edu.unq.games.arkanoid.events._
import ar.edu.unq.games.arkanoid.physics.{STOP, RIGHT, LEFT}
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType
import com.badlogic.gdx.physics.box2d._
import rx.lang.scala.Subscription

class Bar(val x:Float = 300f, val y:Float = 50f) extends PhysicActor {
  val bar = new Texture("barra.jpg")
  val bodyType =  BodyType.KinematicBody
  val initialPosition = new Vector2(x, y)
  val VELOCITY = 300

  var subscription: Subscription = _

  object Velocities {
    val left  = LEFT.scl(VELOCITY)
    val right = RIGHT.scl(VELOCITY)
    val stop  = STOP
  }

  def direction(vector2: Vector2): Unit = body.setLinearVelocity(vector2)

  val inputConsumer: (RxEvent) => Unit = {

    case InputEvent(MoveLeft) =>  direction(Velocities.left)
    case InputEvent(MoveRight) => direction(Velocities.right)
    case InputEvent(Stop) =>      direction(Velocities.stop)
  }

  override def init(world: World): Unit = {
    super.init(world)
    createBody(world)
    subscription = RxBus.toObservable.subscribe(inputConsumer)
  }

  //=================================================================

  def createBody(world: World): Unit = {
    initBody(world)

    val shape = new PolygonShape()
    shape.setAsBox(bar.getWidth/2, bar.getHeight/2)
    val fixtureDef = new FixtureDef()
    fixtureDef.shape = shape
    body.createFixture(fixtureDef)
    body.setUserData(this)
    shape.dispose()
  }

  override def draw(spriteBatch: SpriteBatch): Unit = {
    spriteBatch.draw(bar, pos.x-bar.getWidth/2, pos.y-bar.getHeight/2)
  }

  override def dispose(): Unit = {
    subscription.unsubscribe()
  }
}
