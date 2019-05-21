package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;
    private boolean[] keyDown = new boolean[4];

    public KeyInput(Handler handler) {
        this.handler = handler;

        keyDown[0] = false;//W
        keyDown[1] = false;//S
        keyDown[2] = false;//D
        keyDown[3] = false;//A

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.objects.size(); i++){
            GameObject object = handler.objects.get(i);

            if (object.getId().equals(ID.Player)){
                if (key == KeyEvent.VK_W){
                    object.setVelY(-5);
                    keyDown[0] = true;
                }
                if (key == KeyEvent.VK_S){
                    object.setVelY(5);
                    keyDown[1] = true;
                }
                if (key == KeyEvent.VK_D){
                    object.setVelX(5);
                    keyDown[2] = true;
                }
                if (key == KeyEvent.VK_A){
                    object.setVelX(-5);
                    keyDown[3] = true;
                }
            }
        }

        if (key == KeyEvent.VK_ESCAPE){
            System.exit(1);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.objects.size(); i++){
            GameObject object = handler.objects.get(i);

            if (object.getId().equals(ID.Player)){
                if (key == KeyEvent.VK_W){
                  //  object.setVelY(0);
                    keyDown[0] = false;
                }
                if (key == KeyEvent.VK_S){
//                    object.setVelY(0);
                    keyDown[1] = false;
                }
                if (key == KeyEvent.VK_D){
//                    object.setVelX(0);
                    keyDown[2] = false;
                }
                if (key == KeyEvent.VK_A){
//                    object.setVelX(0);
                    keyDown[3] = false;
                }

                //vertical movement
                if (!keyDown[0] && !keyDown[1]){
                    object.setVelY(0);
                }

                //horizontal movement
                if (!keyDown[2] && !keyDown[3]){
                    object.setVelX(0);
                }
            }


        }

    }
}
