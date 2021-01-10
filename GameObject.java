package arkanoid;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


abstract class GameObject extends Rectangle {

    boolean destroyed;


    GameObject(int w, int h, Color color) {
        super(w, h, color);
        destroyed = false;

    }

    GameObject(int w, int h) {
        super(w, h);

    }

    void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    boolean isDestroyed() {
        return this.destroyed;
    }

}
