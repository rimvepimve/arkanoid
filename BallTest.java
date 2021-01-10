package arkanoid;

import javafx.scene.paint.Color;
import org.junit.Test;

import static arkanoid.Constants.*;
import static org.junit.Assert.assertEquals;

public class BallTest {
    Ball ball = new Ball(BALL_INIT_X,  BALL_INIT_Y, BALL_RADIUS, BALL_RADIUS, Color.BLACK);

    @Test
    public void bounceFromLeftWall(){
        ball.setTranslateX(BALL_RADIUS);
        ball.move();

        assertEquals(1, ball.getXVector());
    }

    @Test
    public void bounceFromRightWall(){
        ball.setTranslateX(WIDTH - BALL_RADIUS);
        ball.move();

        assertEquals(-1, ball.getXVector());
    }

    @Test
    public void bounceFromTopWAll(){
        ball.setTranslateY(BALL_RADIUS);
        ball.move();

        assertEquals(1, ball.getYVector());
    }

}
