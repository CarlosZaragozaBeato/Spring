package org.example;

import example.CalculatorService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        CalculatorService calculadora = (CalculatorService) context.getBean("calculatorService");
        System.out.println(calculadora.HolaMundo());
    }
}