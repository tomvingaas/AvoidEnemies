package main;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Handler {
    LinkedList<GameObject> objects = new LinkedList<>();

    public void tick(){
        for(int i =0; i < objects.size(); i++){
            GameObject tempObject = objects.get(i);
            tempObject.tick();
        }
    }

    public void render(Graphics g){
        for(int i =0; i < objects.size(); i++){
            GameObject tempObject = objects.get(i);
            tempObject.render(g);
        }
    }

    public void clearEnemies(){
        for(int i =0; i < objects.size(); i++){
            GameObject tempObject = objects.get(i);
            if (tempObject.getId() != ID.Player){
                removeObject(tempObject);
                i--;
            }
        }
    }

    public void addObject(GameObject object){
        this.objects.add(object);
    }

    public void removeObject(GameObject object){
        this.objects.remove(object);
    }
}
