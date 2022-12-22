package com.example;

import org.springframework.stereotype.Component;

@Component
public class GestorFacturas {

    Calculadora service;
    //@Value("Gaucho")
    //    String nombre;
    public GestorFacturas(Calculadora service){
        System.out.println("Ejecutando constructor Gestor de Facturas: "+this.getClass());
        this.service = service;
    }

    public String calculadora(){
        return "Calculando Facturas de: ";
    }


}
