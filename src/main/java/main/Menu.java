package main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import static main.Game.HEIGHT;
import static main.Game.WIDTH;

public class Menu extends MouseAdapter {

    private Game game;
    private Handler handler;
    private Random rand = new Random();

    public Menu(Handler handler, Game game) {
        this.game = game;
        this.handler = handler;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mX = e.getX();
        int mY = e.getY();

        if (game.gameState == Game.STATE.MENU) {

            //play
            if (mouseOver(mX, mY, 210, 150, 200, 64)) {
                game.gameState = Game.STATE.GAME;
                handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player, handler));
                handler.addObject(new BasicEnemy(rand.nextInt(WIDTH), rand.nextInt(HEIGHT), ID.BasicEnemy, handler));
            }

            //help
            if (mouseOver(mX, mY, 210, 250, 200, 64)) {
                game.gameState = Game.STATE.HELP;
            }

            //quit
            if (mouseOver(mX, mY, 210, 350, 200, 64)) {
                System.exit(1);
            }
        }

        if (game.gameState == Game.STATE.HELP) {
            if (mouseOver(mX, mY, 210, 350, 200, 64)) {
                game.gameState = Game.STATE.MENU;
                return;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
    }

    private boolean mouseOver(int mX, int mY, int x, int y, int width, int height){
        if (mX > x && mX < x + width){
            if(mY > y && mY < y + height){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }

    }

    public void tick(){

    }

    public void render(Graphics g){
        Font font = new Font("arial", 1, 50);
        Font font2 = new Font("arial", 1, 30);
        if (game.gameState == Game.STATE.MENU){


            g.setFont(font);
            g.setColor(Color.WHITE);
            g.drawString("Meny", 250, 70);

            g.setFont(font2);
            g.setColor(Color.WHITE);
            g.drawString("Spill", 280, 190);

            g.setFont(font2);
            g.setColor(Color.WHITE);
            g.drawString("Hjelp", 280, 290);

            g.setFont(font2);
            g.setColor(Color.WHITE);
            g.drawString("Avslutt", 260, 390);


            g.drawRect(210, 150, 200, 64);

            g.setColor(Color.WHITE);
            g.drawRect(210, 150, 200, 64);

            g.setColor(Color.WHITE);
            g.drawRect(210, 250, 200, 64);

            g.setColor(Color.WHITE);
            g.drawRect(210, 350, 200, 64);
        }else if (game.gameState == Game.STATE.HELP){

            Font font3 = new Font("arial", 1, 20);

            g.setFont(font);
            g.setColor(Color.WHITE);
            g.drawString("Hjelp", 250, 70);

            g.setFont(font3);
            g.setColor(Color.WHITE);
            g.drawString("Bruk WASD-taster for å", 120, 200);
            g.setFont(font3);
            g.setColor(Color.WHITE);
            g.drawString("bevege spiller og dukke unna fiender", 120, 225);


            g.setFont(font2);
            g.setColor(Color.WHITE);
            g.drawString("Tilbake", 260, 390);

            g.setColor(Color.WHITE);
            g.drawRect(210, 350, 200, 64);
        }
    }

}
