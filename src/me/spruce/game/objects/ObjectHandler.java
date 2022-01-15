package me.spruce.game.objects;

import java.awt.*;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

public class ObjectHandler {

    public LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick(){
        for(int i = 0; i < object.size(); i++){
            object.get(i).tick();
        }
    }

    public void render(Graphics g){
        object.forEach(object ->{
            object.render(g);
        });
    }

    public void addObject(GameObject o){
        object.add(o);
    }

    public void removeObject(GameObject o){
        object.remove(o);
    }
}
