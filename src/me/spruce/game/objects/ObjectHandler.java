package me.spruce.game.objects;

import java.awt.*;
import java.util.LinkedList;

public class ObjectHandler {

    LinkedList<GameObject> object = new LinkedList<>();

    public void tick(){
        object.forEach(GameObject::tick);
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
