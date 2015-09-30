package ar.edu.unq.games.arkanoid.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

public class PlatformComponent implements Component {
    public Vector2 originalPosition;
    public float timePassed = 0;
}
