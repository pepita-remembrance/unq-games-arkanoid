package ar.edu.unq.games.arkanoid.actors

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType
import com.badlogic.gdx.physics.box2d._

class Bounds extends PhysicActor {
  val bar = new Texture("barra.jpg")
  val INITIAL_POSITION = new Vector2(0f, 0f)

  var body: Body = _

  override def init(world: World): Unit = {
    super.init(world)
    createBody(world)
  }

  //=========================== PHYSICS =============================

  def initBody(world: World) = {
    val definition = new BodyDef()
    definition.`type` = BodyType.StaticBody
    definition.position.set(INITIAL_POSITION)
    body = world.createBody(definition)
  }

  override def pos: Vector2 = body.getPosition


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

  override def draw(spriteBatch: SpriteBatch): Unit = { }

}
