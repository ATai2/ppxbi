package com.ppx.dubbo.spi;

public class BlackCar implements CarInterface {

    @Override
    public void getColor() {
        System.out.println("black");
    }
}
