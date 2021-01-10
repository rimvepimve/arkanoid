package arkanoid;


import javafx.scene.paint.Color;

import static arkanoid.Constants.*;

public class Paddle extends GameObject implements IPaddle {
    public Paddle(int x, int y, int width, int height, Color color){
        super(width, height, color);
        setTranslateX(x);
        setTranslateY(y);
    }

   public void moveLeft() {
        setTranslateX(getTranslateX() - PADDLE_SPEED);
        if (getTranslateX() <= 0) {
            setTranslateX(0);
        }
    }

   public void moveRight() {
        setTranslateX(getTranslateX() + PADDLE_SPEED);
        if (getTranslateX() + PADDLE_WIDTH >= WIDTH) {
            setTranslateX(WIDTH - PADDLE_WIDTH);
        }
    }

}
