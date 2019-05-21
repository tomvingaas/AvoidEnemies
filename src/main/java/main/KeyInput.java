package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.objects.size(); i++){
            GameObject object = handler.objects.get(i);

            if (object.getId().equals(ID.Player)){
                if (key == KeyEvent.VK_W){
                    object.setVelY(-5);
                }
                if (key == KeyEvent.VK_S){
                    object.setVelY(5);
                }
                if (key == KeyEvent.VK_D){
                    object.setVelX(5);
                }
                if (key == KeyEvent.VK_A){
                    object.setVelX(-5);
                }
            }

            if (object.getId().equals(ID.Player2)){
                if (key == KeyEvent.VK_UP){
                    object.setVelY(-5);
                }
                if (key == KeyEvent.VK_DOWN){
                    object.setVelY(5);
                }
                if (key == KeyEvent.VK_RIGHT){
                    object.setVelX(5);
                }
                if (key == KeyEvent.VK_LEFT){
                    object.setVelX(-5);
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.objects.size(); i++){
            GameObject object = handler.objects.get(i);

            if (object.getId().equals(ID.Player)){
                if (key == KeyEvent.VK_W){
                    object.setVelY(0);
                }
                if (key == KeyEvent.VK_S){
                    object.setVelY(0);
                }
                if (key == KeyEvent.VK_D){
                    object.setVelX(0);
                }
                if (key == KeyEvent.VK_A){
                    object.setVelX(0);
                }
            }

            if (object.getId().equals(ID.Player2)){
                if (key == KeyEvent.VK_UP){
                    object.setVelY(0);
                }
                if (key == KeyEvent.VK_DOWN){
                    object.setVelY(0);
                }
                if (key == KeyEvent.VK_RIGHT){
                    object.setVelX(0);
                }
                if (key == KeyEvent.VK_LEFT){
                    object.setVelX(0);
                }
            }
        }

    }
}
