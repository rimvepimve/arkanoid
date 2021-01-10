package arkanoid;

import javafx.scene.paint.Color;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class PaddleTest {

    int x;
    int y;

    @Test
    public void testPaddleMoveLeft() {
        x = Constants.PADDLE_INIT_X;
        y = Constants.PADDLE_INIT_Y;
        Paddle newPaddle = new Paddle(x,y, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, Color.GRAY);

        newPaddle.moveLeft();

        assertNotEquals(x, (int)newPaddle.getTranslateX());
    }

    @Test
    public void testPaddleMoveRight() {
        x = Constants.PADDLE_INIT_X;
        y = Constants.PADDLE_INIT_Y;
        Paddle newPaddle = new Paddle(x,y, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, Color.GRAY);

        newPaddle.moveRight();

        assertNotEquals(x, (int)newPaddle.getTranslateX());
    }
}
