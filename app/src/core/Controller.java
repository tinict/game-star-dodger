package core;

import modules.DrawGraphic.StdDraw;

public class Controller {
    private final Player player;

    public Controller( Player player) {
        this.player = player;
    }

    public void onMousePress() {
        if ( StdDraw.mousePressed() ) {
            double mouseX = StdDraw.mouseX();
            double mouseY = StdDraw.mouseY();
            double playerX = player.getX();
            double playerY = player.getY();

            if (mouseY < playerY ) playerY -= player.getSpeed();
            if (mouseY > playerY ) playerY += player.getSpeed();
            if (mouseX < playerX ) playerX -= player.getSpeed();
            if (mouseX > playerX ) playerX += player.getSpeed();
            player.move( playerX, playerY );
        }
    }

    public void update() {
        onMousePress();
    }
}
