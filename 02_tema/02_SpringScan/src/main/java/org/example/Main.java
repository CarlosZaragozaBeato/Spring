package org.example;

import com.example.Calculadora;
import com.example.GestorFacturas;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //Crear un objecto de forma normal
        Calculadora service = new Calculadora();
        System.out.println(service.HolaMundo());
        //Obtener Beans 1
        Calculadora service2 = (Calculadora) context.getBean("calculadora");
        System.out.println(service2.HolaMundo());
        //////////////////////////////////////////////////////////////////////
        //2 Recibir un objecto de Spring
        //Objecto Gestor Factura
        //Cargar un Bean dentro de otro bean
        GestorFacturas gestor= (GestorFacturas) context.getBean("gestorFacturas");
        System.out.println(gestor.calculadora());
        //////////////////////////////////////////////////////////////////////
        //Concepto 3 scope o alcance
        //los beans por defecto son singleton, se crea el objeto y se reutiliza para toda la aplicacion
        //podemos cambiarlo a scope="prototype" si queremos que se cree un objeto cada vez
        /*
        Si estos datos fueran a una bd convendria poner el scope a prototype ya que cada objeto debera ser unico
        Coche coche = new Coche(id, modelo, caballos, cilindrada);
        */
    }
    }
