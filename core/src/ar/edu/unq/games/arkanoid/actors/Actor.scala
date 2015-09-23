package ar.edu.unq.games.arkanoid.actors

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType
import com.badlogic.gdx.physics.box2d.{BodyDef, Body, World}

trait Actor {

  def init():Unit={}

  def pos:Vector2

  def act(delta: Float)

  def draw(spriteBatch: SpriteBatch)

  def dispose():Unit={}

}

trait PhysicActor extends Actor {
  val bodyType:BodyType
  val initialPosition:Vector2
  var body: Body = _

  def init(world:World):Unit = {
    init()
  }

  def initBody(world: World) = {
    val definition = new BodyDef()
    definition.`type` = bodyType
    definition.position.set(initialPosition)
    body = world.createBody(definition)
  }

  override def pos: Vector2 = body.getPosition

  override def act(delta: Float): Unit = {}
}

