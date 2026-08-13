package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Persona persona1 = new Persona("Alan", "brito", 20);
        //Persona persona2 =  new Persona("Maria", "Dolores", 19);
        Estudiante estudiante1 = new Estudiante("Juan", "Rozas", 19, "Informatica", false );


        //System.out.println(persona1.toString());
        //System.out.println(persona2.toString());
        System.out.println(estudiante1.toString());

    }
}