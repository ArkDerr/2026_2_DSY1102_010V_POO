package org.arriendo;

import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Auto auto = new Auto(
                "AAAA-10",
                "Toyota",
                2024,
                30000,
                LocalDate.of(2026,3,15),
                4);

        Moto moto = new Moto(
                "BBBB-20",
                "Honda",
                2023,
                20000,
                LocalDate.of(2026,5,10),
                250);

        //Menu

        int opcion = -1;

        while (opcion != 0){
            System.out.println("##### Menu #####");
            System.out.println("1. Mostrar datos del auto");
            System.out.println("2. Mostrar datos de la moto");
            System.out.println("3. Calcular el total del arriendo del auto");
            System.out.println("4. Calcular el total del arriendo de la moto");
            System.out.println("5. Arrendar el auto");
            System.out.println("6. Arrendar la moto");
            System.out.println("7. Devolver el auto");
            System.out.println("8. Devolver la moto");
            System.out.println("9. Realizar el mantenimiento del auto");
            System.out.println("10. Realizar el mantenimiento de la moto");
            System.out.println("0. Salir");
            System.out.print("Ingrese la Opcion: ");

            try {
                opcion = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
               //System.out.println("Ingrese una opcion numerica");
                sc.nextLine();
            }

            switch (opcion){
                case 1:
                    auto.mostrarDatos();
                    break;
                case 2:
                    moto.mostrarDatos();
                    break;
                case 3:
                    try {
                    System.out.println("ingrese la cantidad de dias a arrendar: ");

                    int diasAuto = sc.nextInt();
                    sc.nextLine();
                    double totalArriendoAuto = auto.calcularArriendo(diasAuto);
                    System.out.println("El total del arriendo es: " + totalArriendoAuto);
                    } catch (Exception e) {
                        System.out.println("Ingrese una opcion numerica");
                        sc.nextLine();
                    }
                    break;
                case 4:
                    try {
                    System.out.println("ingrese la cantidad de dias a arrendar: ");
                    int diasMoto = sc.nextInt();
                    sc.nextLine();
                    double totalArriendoMoto = moto.calcularArriendo(diasMoto);
                    System.out.println("El total del arriendo es: " + totalArriendoMoto);
            } catch (Exception e) {
                System.out.println("Ingrese una opcion numerica");
                sc.nextLine();
            }
                    break;
                case 5:
                    auto.arrendar();
                    break;
                case 6:
                    moto.arrendar();
                    break;
                case 7:
                    auto.devolver();
                    break;
                case 8:
                    moto.devolver();
                    break;
                case 9:
                    auto.realizarMantenimiento();
                    break;
                case 10:
                    moto.realizarMantenimiento();
                    break;
                case 0:
                    System.out.println("Gracias por utilizar mi APP");
                    break;
                default:
                    System.out.println("Opcion ingresada no valida");
                    break;
            }
        }
        sc.close();
    }
}