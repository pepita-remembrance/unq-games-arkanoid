package ar.edu.unq.games.arkanoid.actors

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType
import com.badlogic.gdx.physics.box2d._

class Ball extends PhysicActor {
  val ball = new Texture("ball.png")
  val bodyType = BodyType.DynamicBody
  val initialPosition = new Vector2(200f, 300f)

  override def init(world: World): Unit = {
    super.init(world)
    createBody(world)
    val scalarVelocity: Float = -600
    body.setLinearVelocity(new Vector2(0, scalarVelocity))
  }

  //=================================================================

  def createBody(world: World): Unit = {
    initBody(world)

    val shape = new CircleShape()
    val radius: Float = ball.getWidth / 2
    shape.setRadius(radius)
    shape.setPosition(new Vector2(radius, radius))

    val fixtureDef = new FixtureDef()
    fixtureDef.shape = shape
    fixtureDef.density = 1f
    fixtureDef.friction = 0f
    fixtureDef.restitution = 1f
    body.setUserData(this)
    body.createFixture(fixtureDef)
    shape.dispose()
  }

  override def draw(spriteBatch: SpriteBatch): Unit = {
    spriteBatch.draw(ball, pos.x, pos.y)
  }

}
