package me.spruce.game.objects;

import me.spruce.game.player.Player;

import java.awt.*;
import java.util.LinkedList;

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

    public void removeAllEnemies(){
        for(int i = 0; i < object.size(); i++){
            if(!(object.get(i).getType().equals(ObjectType.Player))) {
                object.remove(i);
                i--;
            }
        }
    }

    public void addObject(GameObject o){
        object.add(o);
    }

    public void removeObject(GameObject o){
        object.remove(o);
    }

    public Player getPlayer(){
        for (GameObject o : object){
            if (o instanceof Player){
                return (Player) o;
            }
        }
        return null;
    }
}
