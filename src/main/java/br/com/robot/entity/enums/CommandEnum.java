package br.com.robot.entity.enums;

import br.com.robot.entity.model.Coordinate;

public enum CommandEnum {
    L{
        @Override
        public void execute(Coordinate c){
            c.rotateLeft();
        }
    },
    R{
        @Override
        public void execute(Coordinate c){
            c.rotateRight();
        }

    },
    M{
        @Override
        public void execute(Coordinate c){
            c.goFoward();
        }

    };

    public abstract void execute(Coordinate c);

}
