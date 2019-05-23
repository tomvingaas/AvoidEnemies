package main;

import java.util.Random;

public class Spawn {
    private Handler handler;
    private HUD hud;
    private int scoreKeep = 0;
    private Random rand = new Random();

    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick(){
        scoreKeep++;
        if (scoreKeep >= 150){
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);

            if (hud.getLevel() == 2){
                handler.addObject(new BasicEnemy(rand.nextInt(Game.WIDTH - 50), rand.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
            }else if (hud.getLevel() == 3){
                handler.addObject(new BasicEnemy(rand.nextInt(Game.WIDTH - 50), rand.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
            }else if (hud.getLevel() == 4){
                handler.addObject(new FastEnemy(rand.nextInt(Game.WIDTH - 50), rand.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
            }else if (hud.getLevel() == 5){
                handler.addObject(new SmartEnemy(rand.nextInt(Game.WIDTH - 50), rand.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
            }else if (hud.getLevel() == 6){
                handler.addObject(new FastEnemy(rand.nextInt(Game.WIDTH - 50), rand.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
            }else if (hud.getLevel() == 7){
                handler.addObject(new SmartEnemy(rand.nextInt(Game.WIDTH - 50), rand.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
            }else if (hud.getLevel() == 10){
                handler.clearEnemies();
                handler.addObject(new BossEnemy((Game.WIDTH / 2) - 48,-120, ID.BossEnemy, handler));
            }


        }
    }
}
