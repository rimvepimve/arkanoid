package arkanoid;

import javafx.scene.paint.Color;

import static arkanoid.Constants.*;

class Ball extends GameObject {

    private int xVector;
    private int yVector;

    Ball(int x, int y, int width, int height, Color color){
        super(width, height, color);
        xVector = 0;
        yVector = 1;
        setTranslateX(x);
        setTranslateY(y);
        setFill(color);

    }

    void move() {
        setTranslateX(getTranslateX() + xVector);
        setTranslateY(getTranslateY() + yVector);

        if(getTranslateX() == BALL_RADIUS) {
            setXVector(1);
        }
        if (getTranslateX() >= WIDTH - BALL_RADIUS) {
            setXVector(-1);
        }
        if (getTranslateY() == BALL_RADIUS) {
            setYVector(1);
        }
        if (getTranslateY() == HEIGHT - BALL_RADIUS ) {
            resetState();
        }
    }

    private void resetState() {
        setTranslateX(BALL_INIT_X);
        setTranslateY(BALL_INIT_Y);
        this.xVector = 1;
        this.yVector = -1;
    }

    void setXVector(int vector) {
        this.xVector = vector;
    }

    void setYVector(int vector) {
        this.yVector = vector;
    }

    int getXVector() {
        return xVector;
    }

    int getYVector() {
        return yVector;
    }
}
