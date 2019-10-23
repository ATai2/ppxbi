package com.ppx.dubbo.spi;


import org.apache.dubbo.common.URL;

public class BenzCar implements CarUrlInterface {
    private CarUrlInterface carUrlInterface;

    public BenzCar(CarUrlInterface carUrlInterface) {
        this.carUrlInterface = carUrlInterface;
    }

    @Override
    public void getColor(URL url) {
        System.out.println("benz");
        carUrlInterface.getColor(url);
    }
}
