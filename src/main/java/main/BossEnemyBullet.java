package main;

import java.awt.*;
import java.util.Random;

public class BossEnemyBullet extends GameObject {

    private Handler handler;
    Random rand = new Random();

    public BossEnemyBullet(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        velX = (rand.nextInt(5 - -5) + -5);
        velY = 5;
        this.handler = handler;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if (y >= Game.HEIGHT){
            handler.removeObject(this);
        }

        handler.addObject(new Trail(x, y, ID.Trail, Color.yellow,16,16, 0.02f, handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect((int)x,(int)y,16,16);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16,16);
    }
}