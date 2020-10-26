import java.io.IOException;

public class Arkanoid {
  static int playground[][] = new int[][] {
          {1,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,1},
          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
          {1,0,0,0,0,0,0,0,0,0,0,0,6,6,6,6,0,10,10,10,10,0,14,14,14,14,0,18,18,18,18,0,22,22,22,22,0,26,26,26,26,0,0,0,0,0,0,0,0,0,0,1},
          {1,0,0,0,0,0,0,0,0,0,0,0,7,7,7,7,0,11,11,11,11,0,15,15,15,15,0,19,19,19,19,0,23,23,23,23,0,27,27,27,27,0,0,0,0,0,0,0,0,0,0,1},
          {1,0,0,0,0,0,0,0,0,0,0,0,8,8,8,8,0,12,12,12,12,0,16,16,16,16,0,20,20,20,10,0,24,24,24,24,0,28,28,28,28,0,0,0,0,0,0,0,0,0,0,1},
          {1,0,0,0,0,0,0,0,0,0,0,0,9,9,9,9,0,13,13,13,13,0,17,17,17,17,0,21,21,21,21,0,25,25,25,25,0,29,29,29,29,0,0,0,0,0,0,0,0,0,0,1},
          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
          {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
  };

  static int paddleX = playground[0].length / 2 - 4;
  static int paddleY = playground.length - 2 ;
  static int ballX = playground[0].length / 2 - 4;
  static int ballY = playground.length - 4;
  static int ballDx = 1;
  static int ballDy = 1;
  static int score = 0;

  private static void moveBall(){
    ballY+=ballDy;
    ballX+=ballDx;
  }

  private static void movePaddleLeft(){
    if(playground[paddleY][paddleX-2] == 0)
      paddleX = paddleX - 2;
  }

  private static void movePaddleRight(){
    if(playground[paddleY][paddleX+9] == 0)
      paddleX = paddleX  + 2;
  }


  private static void printPlayground() {
        for (int y = 0; y < playground.length; y++) {
          for (int x = 0; x < playground[0].length; x++) {
            if(x == ballX && y  == ballY ) {
              System.out.print("o");
              continue;
            }
            if (playground[y][x]==1 || playground[y][x]==3) {
              System.out.print("#");
            }
            if (playground[y][x]==0) {
              System.out.print(" ");
            }
            if(playground[y][x]==2) {
              System.out.print(".");
            }
            if(playground[y][x]==4 || playground[y][x]== 5) {
              System.out.print("_");
            }
            if(playground[y][x]> 5)
              System.out.print("x");
          }
          System.out.println();
        }
    }

    private static void setPaddleToPlayground(){
      for(int i = 0; i < 8; i++) {
        if(i<4)
          playground[paddleY][paddleX + i] = 4;
        else
          playground[paddleY][paddleX + i] = 5;
      }
    }

  private static void clearPaddleFromPlayground(){
    for(int i = 0; i < 8; i++) {
      playground[paddleY][paddleX + i] = 0;
    }
  }

  private static void changeBallDirection() {
    if(playground[ballY][ballX] == 4) {
      ballDy = -1;
      ballDx = -1;
      return;
    }
    if(playground[ballY][ballX] == 5) {
      ballDy = -1;
      ballDx = 1;
      return;
    }
    if(playground[ballY][ballX] > 5 || playground[ballY][ballX] == 3) {
      ballDy = -1 * ballDy;
      return;
    }
    if(playground[ballY][ballX] == 1) {
      ballDx = -1 * ballDx;
      return;
    }
    if(playground[ballY][ballX] == 2) {
      System.out.println("GameOver. Your score: " + score);
      System.exit(0);
    }
  }


  private static boolean isBrickHitted() {
    return playground[ballY][ballX] > 5;
  }

  private static void destroyBrick() {
    int valueToErase = playground[ballY][ballX];
    for(int i = 0; i < playground[0].length; i++){
      if(playground[ballY][i] == valueToErase)
        playground[ballY][i] = 0;
    }
  }


  public static void main(String[] args) throws IOException {

    boolean gameOver = false;
    while(!gameOver) {
      if(score == 24) {
        System.out.println("You Won!");
        gameOver = true;
      }
      setPaddleToPlayground();
      printPlayground();
      if(isBrickHitted()){
        score++;
        changeBallDirection();
        destroyBrick();
      }
      else if (playground [ballY][ballX] != 0) {
        changeBallDirection();
      }

      moveBall();
      clearPaddleFromPlayground();
      int key = 0;
      do {
        key = System.in.read();
      } while(key == 13 || key ==  10);
      switch (key) {
        case 'q':
          gameOver = true;
          break;
        case 'a':
          movePaddleLeft();
          break;
        case 'd':
          movePaddleRight();
          break;
      }
    }
    System.out.println("GameOver. Your score: " + score);
  }
}
