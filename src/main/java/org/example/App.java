package org.example;

import org.example.servise.Calculation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RootConfiguration.class);

        Calculation calculation = (Calculation) applicationContext.getBean("calculation");
        calculation.run();
    }
}
