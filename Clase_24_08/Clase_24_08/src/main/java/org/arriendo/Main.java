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
        );

        //Menu

        int opcion = -1;
        while (opcion != 0){

        }

    }
}