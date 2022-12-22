package org.example;

import com.example.Saludar;
import com.example.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");


        Saludar saludo  = (Saludar)context.getBean("saludar");
        System.out.println(saludo.HolaMundo());

        UserService srv = (UserService) context.getBean("userService");
        System.out.println(srv.getService().Saludo());
    }
}