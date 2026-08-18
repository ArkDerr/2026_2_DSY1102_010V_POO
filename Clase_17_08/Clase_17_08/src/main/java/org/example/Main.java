package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Vehiculo vehiculo = new Vehiculo("AABB11","Kia",1000);

        vehiculo.imprimirDatos();

        System.out.println("El valor total del arriendo es: "+vehiculo.calcularTotalArriendo(7));
        vehiculo.calcularTotalArriendov2(8);

        vehiculo.setMarca("Ferrari");
        vehiculo.imprimirDatos();

        Auto auto = new Auto("bbcc22","Jac",500,"Rojo");
        auto.imprimirDatos();

        System.out.println(auto.calcularTotalArriendo(10));
        System.out.println(auto.calcularTotalArriendo(10,500));

    }
}