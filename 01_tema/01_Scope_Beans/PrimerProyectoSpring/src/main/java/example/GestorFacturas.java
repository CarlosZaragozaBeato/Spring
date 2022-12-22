package example;

public class GestorFacturas {

    Calculadora service;
    String nombre;
    public GestorFacturas(Calculadora service, String nombre){
        System.out.println("Ejecutando constructor Gestor de Facturas: "+this.getClass());
        this.service = service;
        this.nombre = nombre;
    }

    public String calculadora(){
        return "Calculando Facturas de: "+this.nombre;
    }


}
