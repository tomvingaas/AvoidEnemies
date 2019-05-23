package main;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    Random rand = new Random();
    Handler handler;

    public Player(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp((int)x, 0, Game.WIDTH-37);
        y = Game.clamp((int)y, 0, Game.HEIGHT-60);
        
        collision();

        handler.addObject(new Trail(x, y, ID.Trail, Color.WHITE,32,32, 0.08f, handler));
    }

    private void collision() {
        for (int i = 0; i < handler.objects.size(); i++){
            GameObject temp = handler.objects.get(i);
            if (temp.getId() == ID.BasicEnemy || temp.getId() == ID.FastEnemy || temp.getId() == ID.SmartEnemy){
                if (getBounds().intersects(temp.getBounds())){
                    //Collision code
                    HUD.HEALTH -= 2;
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect((int)x, (int)y, 32, 32);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int) y, 32,32);
    }
}
