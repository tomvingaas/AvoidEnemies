package main;

import java.awt.*;
import java.util.Random;

public class BossEnemy extends GameObject {

    private Handler handler;
    Random rand = new Random();

    private int timer = 80;
    private int timer2 = 50;

    public BossEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        velX = 0;
        velY = 2;
        this.handler = handler;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if (timer <= 0){
            velY = 0;
        }else {
            timer --;
        }

        if (timer <= 0){
            timer2--;
        }

        if (timer2 <= 0){
            if (velX == 0){
                velX = 2;
            }
            if (velX > 0){
                velX += 0.005f;
            }else if (velX < 0){
                velX -= 0.005f;
            }
            velX = Game.clamp(velX, -10, 10);
            int spawn = rand.nextInt(10);
            if (spawn == 0){
                handler.addObject(new BossEnemyBullet((int)x + 48, (int)y + 48, ID.BasicEnemy, handler));
            }
        }

        if ( x <= 0 || x >= Game.WIDTH -110){
            velX *= -1;
        }
//        handler.addObject(new Trail(x, y, ID.Trail, Color.red,96,96, 0.02f, handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int)x,(int)y,96,96);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16,16);
    }
}