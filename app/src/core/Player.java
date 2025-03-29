package core;

import modules.DrawGraphic.StdDraw;

public class Player {
    /*Attributes: Instance Variables*/
    private final String image;
    private final int width;
    private final int height;
    private double x;
    private double y;
    private int speed;

    public void draw() {
        StdDraw.picture(x, y, image, width, height);
    }

    /* Constructor */
    public Player(double x, double y) {
        this.x = x; //set x position
        this.y = y; //set y position
        this.width = 32; //set width
        this.height = 32; //set height
        this.image = "D:/prm25/star-dodger/game-star-dodger/app/src/resources/assets/spaceman.png"; //set image filename
        this.speed = 10;
    }

    public void move(double x, double y) {
        this.y = y;
        this.x = x;
    }

    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }
    public double getSpeed() {
        return this.speed;
    }

    public boolean isTouchingX( Enemy gameObject ) {
        int hitzone = 24;
        return this.x <= gameObject.getX()+hitzone && gameObject.getX() <= this.x+hitzone;
    }

    public boolean isTouchingY( Enemy gameObject ) {
        int hitzone = 24;
        return this.y <= gameObject.getY()+hitzone && gameObject.getY() <= this.y+hitzone;
    }

    public boolean isTouching( Enemy gameObject ) {
        return this.isTouchingX(gameObject) && this.isTouchingY(gameObject);
    }

}
