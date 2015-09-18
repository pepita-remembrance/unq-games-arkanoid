package ar.edu.unq.games.arkanoid.actors

import ar.edu.unq.games.arkanoid.events._
import ar.edu.unq.games.arkanoid.physics.{STOP, RIGHT, LEFT}
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType
import com.badlogic.gdx.physics.box2d._
import rx.lang.scala.Subscription

class Bar extends PhysicActor {
  val bar = new Texture("barra.jpg")
  val INITIAL_POSITION = new Vector2(200f, 50f)

  var subscription: Subscription = _

  var body: Body = _

  object Velocities {
    val left  = LEFT.scl(100)
    val right = RIGHT.scl(100)
    val stop  = STOP
  }

  def direction(vector2: Vector2): Unit = body.setLinearVelocity(vector2)

  val inputConsumer: (RxEvent) => Unit = {

    case InputEvent(MoveLeft) =>  direction(Velocities.left)
    case InputEvent(MoveRight) => direction(Velocities.right)
    case InputEvent(Stop) =>      direction(Velocities.stop)
  }

  override def init(): Unit = {
    super.init()
    subscription = RxBus.toObservable.subscribe(inputConsumer)
  }

  override def init(world: World): Unit = {
    super.init(world)
    createBody(world)
  }

  //=========================== PHYSICS =============================

  def initBody(world: World) = {
    val definition = new BodyDef()
    definition.`type` = BodyType.KinematicBody
    definition.position.set(INITIAL_POSITION)
    body = world.createBody(definition)
  }

  override def pos: Vector2 = body.getPosition


  //=================================================================

  def createBody(world: World): Unit = {
    initBody(world)

    val shape = new PolygonShape()
    shape.setAsBox(bar.getWidth, bar.getHeight)
    val fixtureDef = new FixtureDef()
    fixtureDef.shape = shape
    body.createFixture(fixtureDef)
    body.setUserData(this)
    shape.dispose()
  }

  override def draw(spriteBatch: SpriteBatch): Unit = {
    spriteBatch.draw(bar, pos.x, pos.y)
  }

  override def dispose(): Unit = {
    subscription.unsubscribe()
  }
}
