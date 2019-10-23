package com.ppx.dubbo.spi;

import org.apache.dubbo.common.URL;

public class CarWrapper implements CarUrlInterface {

    private CarUrlInterface carUrlInterface;

    public CarWrapper(CarUrlInterface carUrlInterface) {
        this.carUrlInterface = carUrlInterface;
    }

    @Override
    public void getColor(URL url) {
        System.out.println("before");
        carUrlInterface.getColor(url);
        System.out.println("after");
    }
}
