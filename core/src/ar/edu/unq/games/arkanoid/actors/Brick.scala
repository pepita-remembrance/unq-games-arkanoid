package ar.edu.unq.games.arkanoid.actors

import ar.edu.unq.games.arkanoid.events._
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType
import com.badlogic.gdx.physics.box2d.{FixtureDef, PolygonShape, World}
import rx.lang.scala.Subscription

class Brick(val initialPosition: Vector2, width: Float = 60, height: Float = 30) extends PhysicActor {
  val brickTexture = new Texture("brick.jpg")
  val bodyType = BodyType.StaticBody
  var subscription: Subscription = _
  var world: World = _


  val collisionConsumer: (RxEvent) => Unit = {
    case Collision(brick: Brick, ball: Ball) if brick == this => onCollisionWithBall(ball)
    case Collision(ball: Ball, brick: Brick) if brick == this => onCollisionWithBall(ball)
    case _ =>
  }

  def onCollisionWithBall(ball: Ball): Unit = {
    body.setActive(false)
    world.destroyBody(body)
    println("choque")
  }

  override def init(world: World): Unit = {
    super.init(world)
    createBody(world)
    this.world = world
    subscription = RxBus.toObservable.subscribe(collisionConsumer)
  }

  def createBody(world: World): Unit = {
    initBody(world)

    val shape = new PolygonShape()
    shape.setAsBox(width / 2, height / 2)
    val fixtureDef = new FixtureDef()
    fixtureDef.shape = shape
    body.createFixture(fixtureDef)
    body.setUserData(this)
    shape.dispose()
  }

  override def draw(spriteBatch: SpriteBatch): Unit = {
    spriteBatch.draw(brickTexture, pos.x - brickTexture.getWidth / 2, pos.y - brickTexture.getHeight / 2)
  }

  override def dispose(): Unit = {
    subscription.unsubscribe()
  }

}
