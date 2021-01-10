package arkanoid;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.util.Optional;

import static arkanoid.Constants.*;


public class Arkanoid extends Application {

    private Board board;
    private Pane root = new Pane();
    private Timeline timeline;
    private Text txtVictory;
    private double acceleration;

    private Parent createContent() {
        board = Board.getBoard();
        acceleration = board.getBallAcceleration();
        root.setPrefSize(board.getWidth(), board.getHeight());
        root.getChildren().add(board.getPaddle());
        root.getChildren().add(board.getBall());
        for(Brick brick: board.getBricks()){
            root.getChildren().add(brick);
        }

        return root;
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Arkanoid");
        Scene scene = new Scene(createContent());
        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case LEFT:
                    board.getPaddle().moveLeft();
                    break;
                case RIGHT:
                    board.getPaddle().moveRight();
                    break;
            }
        });
        stage.setScene(scene);
        stage.show();

        startAnimation();
    }



    private void startAnimation() {
        if(timeline != null) timeline.stop();
        timeline = new Timeline(new KeyFrame(Duration.millis(FRAME_DURATION - acceleration), event -> {
            update();
            checkObjectsLife();
            checkGameStatus();
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void update(){
        board.updateBoard();
        if (board.getBallAcceleration() != acceleration) {
            acceleration = board.getBallAcceleration();
            System.out.println("Acceleration: " + acceleration);
            startAnimation();
        }
    }

    private void checkGameStatus() {
        if (board.getScore() == BRICK_ROWS*BRICK_COLUMNS) {
            timeline.stop();
            txtVictory = new Text((WIDTH/2)-100,HEIGHT/2,"VICTORY!\nscore: " + board.getScore());
            txtVictory.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
            root.getChildren().clear();
            root.getChildren().add(txtVictory);
        }
    }

    private void checkObjectsLife() {
        root.getChildren().removeIf(n -> {
            GameObject obj = (GameObject) n;
            return obj.isDestroyed();
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
