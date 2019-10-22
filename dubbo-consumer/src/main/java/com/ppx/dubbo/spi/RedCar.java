package com.ppx.dubbo.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class RedCar implements CarInterface {

    @Override
    public void getColor() {
        System.out.println("red");
    }

    public static void main(String[] args) {
        ServiceLoader<CarInterface> serviceLoader = ServiceLoader.load(CarInterface.class);
        Iterator<CarInterface> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            System.out.println("===========");
            CarInterface carInterface = iterator.next();
            carInterface.getColor();
        }
    }
}
