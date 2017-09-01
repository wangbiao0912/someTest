package com.after00.main;

import com.after00.service.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/***
 *  接口启动类
 */
public class ServerMain {
    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( new String[] { "applicationProvider.xml" });
        context.start();
        System.out.println("输入任意按键退出 ~ ");
        System.in.read();
        context.close();
    }

    public static void main1(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationConsumer.xml" });
        context.start();
        DemoService service = (DemoService) context.getBean("demoService");
        System.out.println(service.sayHello("world"));
        context.close();

    }

}
