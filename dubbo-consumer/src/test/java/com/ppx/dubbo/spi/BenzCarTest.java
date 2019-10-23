package com.ppx.dubbo.spi;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class BenzCarTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getColor() throws MalformedURLException {
        ExtensionLoader<CarUrlInterface> extensionLoader = ExtensionLoader.getExtensionLoader(CarUrlInterface.class);
        Map<String,String> map=new HashMap<>();
        URL url=new URL("","",1,map);
        CarUrlInterface carUrlInterface = extensionLoader.getExtension("benz");
        carUrlInterface.getColor(url);

    }
}