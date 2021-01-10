package arkanoid;

import javafx.scene.paint.Color;


class Brick extends GameObject {

    Brick(int x, int y, int width, int height, Color color){
        super(width, height, color);
        setTranslateX(x);
        setTranslateY(y);
    }


}
