package org.arriendo;

import java.util.Scanner;

public class Validadores {

    public int validarInt(Scanner sc) {
        try {
            System.out.println("ingrese la cantidad de dias a arrendar: ");
            int diasAuto = sc.nextInt();
            sc.nextLine();
            return diasAuto;
        } catch (Exception e) {
            System.out.println("Ingrese una opcion numerica");
            sc.nextLine();
        }

    }
}
