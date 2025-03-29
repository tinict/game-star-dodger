package core;

import modules.DrawGraphic.StdDraw;

public class Gem {
    private final String image;
    private final int width;
    private final int height;
    private double x;
    private double y;
    private final int speed;

    public Gem(double x, double y) {
        this.x = x;
        this.y = y;
        this.width = 16;
        this.height = 16;
        this.image = "D:/prm25/star-dodger/game-star-dodger/app/src/resources/assets/gem.png";
        this.speed = (int) (2 + Math.random() * 5);
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

    public boolean isTouching(Player player) {
        int hitzone = 16;
        boolean touchingX = this.x <= player.getX() + hitzone && player.getX() <= this.x + hitzone;
        boolean touchingY = this.y <= player.getY() + hitzone && player.getY() <= this.y + hitzone;
        return touchingX && touchingY;
    }
}