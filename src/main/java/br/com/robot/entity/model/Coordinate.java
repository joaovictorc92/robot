package br.com.robot.entity.model;

import br.com.robot.entity.constants.GroundConstants;
import br.com.robot.entity.enums.DirectionEnum;

import java.util.HashMap;

public class Coordinate {
    private int x;
    private int y;
    private int direction;
    private HashMap<Integer ,Runnable> commands;

    public Coordinate() {
        x = 0;
        y = 0;
        direction = 0;
        commands = new HashMap<Integer ,Runnable>(){{
            put(0, ()->{
                y++;
                validateY();
            });
            put(1, ()->{
                x++;
                validateX();
            });
            put(2, ()->{
                y--;
                validateY();
            });
            put(3, ()->{
                x--;
                validateX();
            });
        }};
    }

    public String getPosition(){
        return "(" + x +", "+y + ", " + DirectionEnum.fromId(direction).getValue() + ")";
    }

    public void rotateLeft() {
        direction = Math.floorMod(direction - 1, 4);
    }

    public void rotateRight() {
        direction = Math.floorMod(direction + 1,4);
    }

    public void goFoward() {
        commands.get(direction).run();
    }

    public void validateX(){
        if(x < 0 || x >= GroundConstants.LENGHT){
            throw new RuntimeException();
        }
    }

    public void validateY(){
        if(y < 0 || y >= GroundConstants.WIDTH){
            throw new RuntimeException();
        }
    }
}
