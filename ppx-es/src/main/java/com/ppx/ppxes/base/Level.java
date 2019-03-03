package com.ppx.ppxes.base;

/**
 * 行政级别
 * Created by gegf
 */
public enum Level {

    CITY("city"),
    REGION("region");

    private String value;

    Level(String value){
      this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Level of(String value){
        for (Level level : Level.values()) {
            if(level.value.equals(value)){
                return level;
            }
        }
        throw new IllegalArgumentException();
    }
}
