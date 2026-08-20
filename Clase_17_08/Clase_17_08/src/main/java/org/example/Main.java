package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        /*
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
        */

        //Objeto para capturar por teclado
         Scanner imput = new Scanner(System.in);

         //variable para las opciones
        int opcion = 0;

        //Objeto Auto
        Auto auto = null;

        //Menu
        while(opcion!=5){

            System.out.println("===== ARRIENDO DE AUTOS =====");
            System.out.println("1. Ingrese los datos de un AUTO");
            System.out.println("2. Mostrar datos del AUTO");
            System.out.println("3. Calcular el valor total del Arriendo del auto");
            System.out.println("4. Calcular el valor total del Arriendo del auto pero con Descuento");
            System.out.println("5. Salir del programa");
            System.out.println("Ingrese una opcion:");
            opcion = imput.nextInt();
            imput.nextLine();
            switch(opcion){
                case 1:
                    System.out.println("Ingrese datos del auto:");
                    System.out.println("Ingrese la patente del AUTO:");
                    String patente = imput.nextLine();
                    System.out.println("Ingrese la marca del AUTO:");
                    String marca = imput.nextLine();
                    System.out.println("Ingrese el valor de arriendo diario del AUTO:");
                    int valorArriendo = imput.nextInt();
                    imput.nextLine();
                    System.out.println("Ingrese el color del AUTO:");
                    String color = imput.nextLine();

                    auto = new Auto(patente, marca, valorArriendo, color);

                    System.out.println("Auto Registrado exitosamente!!!!");
                    break;
                case 2:
                    if (auto != null){
                        auto.imprimirDatos();
                    }else{
                        System.out.println("No existe el auto registrado!!!!");
                    }
                    break;
                case 3:
                    if (auto != null){
                        System.out.println("Ingrese los dias de arriendo del auto:");
                        int diasArriendo = imput.nextInt();
                        imput.nextLine();
                        System.out.println("El valor total del arriendo es: "+auto.calcularTotalArriendo(diasArriendo));
                    }else{
                        System.out.println("No existe el auto registrado!!!!");
                    }
                    break;
                case 4:
                    if (auto != null){
                        System.out.println("Ingrese los dias de arriendo del auto:");
                        int diasArriendo = imput.nextInt();
                        imput.nextLine();
                        System.out.println("Cual es el descuento para aplicar:");
                        int descuento = imput.nextInt();
                        imput.nextLine();
                        System.out.println("El valor total del arriendo es: "+auto.calcularTotalArriendo(diasArriendo,descuento));
                    }else{
                        System.out.println("No existe el auto registrado!!!!");
                    }
                    break;
                case 5:
                    System.out.println("Gracias por utilizar mi primer programa de JAVA");
                    break;
                default:
                    System.out.println("Opcion ingresada no es valida");
                    break;
            }
        }
    }
}