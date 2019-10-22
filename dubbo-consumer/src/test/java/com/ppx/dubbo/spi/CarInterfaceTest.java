package com.ppx.dubbo.spi;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.ServiceLoader;

import static org.junit.Assert.*;

public class CarInterfaceTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getColor() {
        ServiceLoader<CarInterface> serviceLoader = ServiceLoader.load(CarInterface.class);
        Iterator<CarInterface> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            System.out.println("===========");
            CarInterface carInterface = iterator.next();
            carInterface.getColor();
        }
    }
}