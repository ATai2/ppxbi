package com.ppx.dubbo.spi;


import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

import java.util.HashMap;
import java.util.Map;

public class BenzCar implements CarUrlInterface {
    private CarUrlInterface carUrlInterface;

    public BenzCar(CarUrlInterface carUrlInterface) {
        this.carUrlInterface = carUrlInterface;
    }

    @Override
    public void getSize(URL url) {
        System.out.println("benz");
        carUrlInterface.getSize(url);
    }

    public static void main(String[] args) {
        ExtensionLoader<CarUrlInterface> extensionLoader = ExtensionLoader.getExtensionLoader(CarUrlInterface.class);
        Map<String,String> map=new HashMap<>();
        map.put("car", "red");
        URL url=new URL("","",1,map);
        CarUrlInterface carUrlInterface = extensionLoader.getExtension("benz");
        carUrlInterface.getSize(url);
    }
}
