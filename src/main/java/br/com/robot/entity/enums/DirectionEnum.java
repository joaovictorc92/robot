package br.com.robot.entity.enums;

import java.util.Arrays;

public enum DirectionEnum {
    N(0, "N"),
    E(1, "E"),
    S(2, "S"),
    W(3, "W");

    private int id;
    private String value;

    DirectionEnum(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public static DirectionEnum fromId(int id){
        return Arrays.stream(values())
                .filter(directionEnum -> directionEnum.id == id)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public String getValue() {
        return value;
    }

}
