package com.ppx.dubbo;

import com.ppx.dubbo.api.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {"dubbo-consumer.xml"});
        context.start();
        HelloService helloService = context.getBean("helloService", HelloService.class);

        for (int i = 0; i < 10000; i++) {
            String at = helloService.sayHello("atai");
            System.out.println(at);
        }

        System.in.read(); // 按任意键退出
    }
}
