package ar.edu.unq.games.arkanoid.actors

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType
import com.badlogic.gdx.physics.box2d._

class Bound (val corner:Vector2, val size:Vector2) extends PhysicActor {
  val debug = new Texture("point.jpg")
  val bodyType = BodyType.StaticBody

  val initialPosition:Vector2 = new Vector2(corner.x + size.x/2, corner.y + size.y/2)

  override def init(world: World): Unit = {
    super.init(world)
    createBody(world)
  }

  def createBody(world: World): Unit = {
    initBody(world)

    val shape = new PolygonShape()
    shape.setAsBox(size.x/2, size.y/2)
    val fixtureDef = new FixtureDef()
    fixtureDef.shape = shape
    body.createFixture(fixtureDef)
    body.setUserData(this)
    shape.dispose()
  }

  override def draw(spriteBatch: SpriteBatch): Unit = {
    spriteBatch.draw(debug, corner.x, corner.y, size.x, size.y)
  }

}
