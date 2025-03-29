package core;

import modules.DrawGraphic.StdDraw;

import java.util.ArrayList;

public class Scene {
    /*Attributes: Instance Variables*/
    private final String image;
    private final int width;
    private final int height;
    private final ArrayList<Enemy> monsters;
    private final ArrayList<Gem> gems;
    private final ArrayList<Oxygen> oxygens;
    private Player player;
    private int level;


    public Scene() {
        width = 500; //set scene width
        height = 350; //set scene height
        image = "D:/prm25/star-dodger/game-star-dodger/app/src/resources/assets/space-background.png"; //set image filename
        monsters = new ArrayList<Enemy>(); //set a new list of enemies in this scene
        gems = new ArrayList<Gem>();
        oxygens = new ArrayList<Oxygen>();
        this.level = 1;

        StdDraw.setCanvasSize(width, height); //set canvas size for image
        StdDraw.setXscale(0.0, width); //set x=0 from right to left
        StdDraw.setYscale(height, 0.0); //set y=0 from top to bottom
    }


    /*draw method*/
    public void draw() {
        StdDraw.picture((double) width / 2, (double) height / 2, image); //draw background image using center point
        for (Enemy monster : monsters) {
            monster.draw();
        }
        for (Gem gem : gems) {
            gem.draw();
        }
        for (Oxygen tank : oxygens) {
            tank.draw();
        }
        player.draw();
    }

    public void addMonster() {
        double x = 32 + (Math.random() * (width - 64));
        double y = -32;
        Enemy star = new Enemy(x, y, this.level);
        monsters.add(star);
    }

    public void addGem() {
        double x = 16 + (Math.random() * (width - 32));
        double y = -16;
        Gem gem = new Gem(x, y);
        gems.add(gem);
    }

    public void addOxygenTank() {
        double x = 16 + (Math.random() * (width - 32));
        double y = -16;
        Oxygen tank = new Oxygen(x, y);
        oxygens.add(tank);
    }

    public void update() {
        for (Enemy monster : monsters) {
            monster.move();
        }
        for (Gem gem : gems) { // Cập nhật vị trí các viên ngọc
            gem.move();
        }
        for (Oxygen tank : oxygens) {
            tank.move();
        }
        gems.removeIf(gem -> gem.getY() > height);
        oxygens.removeIf(tank -> tank.getY() > height);
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Player getPlayer() {
        return this.player;
    }

    public ArrayList<Enemy> getMonsters() {
        return this.monsters;
    }

    public ArrayList<Gem> getGems() { // Getter cho gems
        return this.gems;
    }

    public ArrayList<Oxygen> getOxygenTanks() { // Getter cho oxygenTanks
        return this.oxygens;
    }
}
