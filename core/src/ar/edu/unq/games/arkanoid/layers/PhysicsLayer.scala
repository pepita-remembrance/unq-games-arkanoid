package ar.edu.unq.games.arkanoid.layers

import ar.edu.unq.games.arkanoid.actors._
import ar.edu.unq.games.arkanoid.events.{Collision, RxBus}
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d._

import scala.collection.mutable.ListBuffer

trait PhysicsLayer extends Layer {
  var world: World = _

  lazy val physicElements = ListBuffer(
    new Bound(new Vector2(0, 0), new Vector2(20, Gdx.graphics.getHeight)),
    new Bound(new Vector2(Gdx.graphics.getWidth - 20, 0), new Vector2(20, Gdx.graphics.getHeight)),
    new Bound(new Vector2(0, Gdx.graphics.getHeight - 20), new Vector2(Gdx.graphics.getWidth, 20)),
    new Bar,
    new Ball,
    new Brick(new Vector2(200, 400))
  )

  override def init(): Unit = {
    world = new World(new Vector2(0f, 0f), true)
    world.setContactListener(new CollisionListener())
    physicElements.foreach(_.init(world))
    super.init()
  }

  override def act(delta: Float): Unit = {
    world.step(delta, 8, 3)
    physicElements.foreach(_.act(delta))
    super.act(delta)
  }

  override def draw(spriteBatch: SpriteBatch): Unit = {
    physicElements.foreach(_.draw(spriteBatch))
    super.draw(spriteBatch)
  }

  override def dispose(): Unit = {
    world.dispose()
    physicElements.foreach(_.dispose())
    super.dispose()
  }
}

class CollisionListener extends ContactListener {
  override def postSolve(contact: Contact, impulse: ContactImpulse): Unit = {
    (contact.getFixtureA.getUserData, contact.getFixtureB.getUserData) match {
      case (a: PhysicActor, b: PhysicActor) => RxBus.send(Collision(a, b))  //TODO: Nunca manda la colision, la tupla se resuelve a (null, null)
      case _ =>
    }
  }

  override def endContact(contact: Contact): Unit = {}

  override def beginContact(contact: Contact): Unit = {}

  override def preSolve(contact: Contact, oldManifold: Manifold): Unit = {}
}