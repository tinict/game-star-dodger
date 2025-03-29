package core;

import modules.DrawGraphic.StdDraw;

public class Enemy {
    /*Attributes: Instance Variables*/
    private final String image;
    private final int width;
    private final int height;
    private double x;
    private double y;
    private final int speed;

    public Enemy(double x, double y, int level) {
        this.x = x; //set x position
        this.y = y; //set y position
        this.width = 32; //set width
        this.height = 32; //set height
        this.image = "D:/prm25/star-dodger/game-star-dodger/app/src/resources/assets/asteroid.png"; //set image filename
        this.speed = (int) (3 + Math.random() * 10 + level * 2);
    }

    public void draw() {
        StdDraw.picture(x, y, image, width, height);
    }

    public void move() {
        this.y += this.speed;
    }

    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }

}
