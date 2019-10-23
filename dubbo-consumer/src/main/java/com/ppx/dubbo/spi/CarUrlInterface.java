package com.ppx.dubbo.spi;


import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.SPI;

@SPI
public interface CarUrlInterface {
    void getColor(URL url);
}
