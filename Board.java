package arkanoid;



import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;

import static arkanoid.Constants.*;

class Board extends GameObject {

    private static Board board;
    private int score;
    private double ballAcceleration;
    private Paddle paddle;
    private Ball ball;
    private ArrayList<Brick> bricks = new ArrayList<>();
    private ArrayList<BallSpeedStrategy> ballSpeedStrategy;

    private Board() {
        super(WIDTH,HEIGHT);
        initGameObjects();
    }

    static Board getBoard() {
        if (board == null) {
            board = new Board();
        }
        return board;
    }

    private void initGameObjects() {
        paddle = new Paddle(PADDLE_INIT_X, PADDLE_INIT_Y, PADDLE_WIDTH, PADDLE_HEIGHT, Color.GRAY);
        ball = new Ball(BALL_INIT_X, BALL_INIT_Y, BALL_RADIUS,BALL_RADIUS, Color.BLACK);
        ballSpeedStrategy = new ArrayList<>(Arrays.asList(new AccelerationStrategy(), new DecelerationStrategy()));

        for (int i=0; i<BRICK_ROWS; i++) {
            for (int j=0; j<BRICK_COLUMNS; j++) {
                Brick newBrick = new Brick(j*80+70, i*30+80, 60,20, Color.BLUE);
                bricks.add(newBrick);
            }
        }

    }

    void updateBoard() {
        ball.move();
        if (ball.getBoundsInParent().intersects(paddle.getBoundsInParent())) {
            ballPaddleCollision();
            return;
        }
        checkBallAndBrickCollision();
    }

    private void ballPaddleCollision() {
        double ballLPos = ball.getTranslateX();
        double paddlePos = paddle.getTranslateX();
        double firstHalf = paddlePos + PADDLE_WIDTH/2.0;
        ball.setYVector(-1);
        if (ballLPos < firstHalf) {
            ball.setXVector(-1);
        } else {
            ball.setXVector(1);
        }

    }

    private void checkBallAndBrickCollision() {
        for(Brick b: new ArrayList<Brick>(bricks)) {
            if (ball.getBoundsInParent().intersects(b.getBoundsInParent())) {
                ballBrickCollision();
                b.setDestroyed(true);
                bricks.remove(b);
                return;
            }
        }

    }

    private void ballBrickCollision() {
        ball.setYVector(-1*ball.getYVector());
        score++;
        setBallAcceleration();
    }


    private void setBallAcceleration() {
        for(BallSpeedStrategy strategy: ballSpeedStrategy) {
            if(strategy.isApplicable(score)){
                ballAcceleration = strategy.execute(ballAcceleration);
            }
        }
    }

    int getScore() {
        return score;
    }

    double getBallAcceleration() {
        return ballAcceleration;
    }

    Paddle getPaddle() {
        return paddle;
    }

    Ball getBall() {
        return ball;
    }

    ArrayList<Brick> getBricks() {
        return bricks;
    }
}
