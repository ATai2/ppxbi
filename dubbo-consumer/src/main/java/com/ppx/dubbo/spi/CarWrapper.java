package com.ppx.dubbo.spi;

public class CarWrapper implements CarInterface {

    private CarInterface carInterface;

    public CarWrapper(CarInterface carInterface) {
        this.carInterface = carInterface;
    }

    @Override
    public void getColor() {
        System.out.println("before");
        carInterface.getColor();
        System.out.println("after");
    }
}
