package core;

import modules.DrawGraphic.StdDraw;

import java.util.ArrayList;

public class DodgerGame {
    private boolean isOver;
    private final Scene scene;
    private long startTime;
    private final Controller controller;
    private int timer;
    private int score;
    private double oxygen;
    private int level;

    /*Create a new Dodger Game*/
    public DodgerGame() {
        isOver = false;
        scene = new Scene();
        startTime = System.currentTimeMillis();
        Player player = new Player(250, 187.5);
        this.scene.setPlayer( player );
        controller = new Controller( player );
        this.timer = 0;
        this.score = 0;
        this.oxygen = 100.0;
        this.level = 1;
    }

    public void update() {
        controller.update();
        long now = System.currentTimeMillis();
        if (now - this.startTime > 200 ) { // 1/5th sec duration //
            scene.addMonster();
            this.timer++;
            this.oxygen -= 0.1 * level;

            if (Math.random() < 0.3 / level) {
                scene.addGem();
            }
            if (Math.random() < 0.2) {
                scene.addOxygenTank();
            }

            this.startTime = now;
            if (this.timer % 150 == 0) {
                this.level++;
                scene.setLevel(this.level);
            }
        }

        // Kiểm tra oxy về 0
        if (this.oxygen <= 0) {
            isOver = true;
        }

        scene.update();
        Player player = scene.getPlayer();

        ArrayList<Enemy> monsters = scene.getMonsters();
        monsters.removeIf(monster -> {
            if (player.isTouching(monster)) {
                isOver = true;
                return false;
            }
            return false;
        });

        // Xử lý Gem
        ArrayList<Gem> gems = scene.getGems();
        gems.removeIf(gem -> gem.isTouching(player) && (score++ >= 0));

        // Xử lý OxygenTank
        ArrayList<Oxygen> tanks = scene.getOxygenTanks();
        tanks.removeIf(tank -> tank.isTouching(player) && ((this.oxygen = Math.min(100.0, this.oxygen + 20.0)) > 0));
    }

    public void render() {
        //game draw code
        scene.draw(); //draw scene
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(64,32,"Time: " + timer/5 );
        StdDraw.text(64, 48, "Score: " + score);
        StdDraw.text(64, 64, "Oxygen: " + String.format("%.1f", oxygen));
        StdDraw.text(64, 112, "Level: " + level);
        StdDraw.show(100);
    }

    public static void main(String[] args) {
        DodgerGame game = new DodgerGame();
        while (!game.isOver) {
            game.update();
            game.render();
        }
    }
}
