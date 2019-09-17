package com.ppx.single;

public class HungrySingleton {
    private static HungrySingleton singlton=new HungrySingleton();
    private HungrySingleton(){

    }
    public static HungrySingleton getSingleton(){
        return singlton;
    }
}
