package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Alumno> coleccionAlumnos = new ArrayList<>();
        Operadores operadores = new Operadores();
        Scanner sc = new Scanner(System.in);

        int opcion = 0;


        while(opcion != 6){
            System.out.println("-----MENU-----");
            System.out.println("1. Registar alumno");
            System.out.println("2. Listar alumnos");
            System.out.println("3. Buscar un alumno");
            System.out.println("4- Editar alumno");
            System.out.println("5- Eliminar alumno");
            System.out.println("6- Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion){
                case 1:
                    System.out.println("Ingrese el rut del alumno");
                    int rutAlumno = sc.nextInt();
                    sc.nextLine();
                    System.out.println("ingrese el nombre del alumno");
                    String nombreAlumno = sc.nextLine();
                    Alumno alumno = new Alumno(rutAlumno, nombreAlumno);
                    if(operadores.buscar(alumno.getRut(),coleccionAlumnos)==null){
                        coleccionAlumnos.add(alumno);
                        System.out.println("el alumno se ha registrado correctamente");
                    } else {
                        System.out.println("Ya existe el registro del alumno");
                    }


                    break;
                case 2:
                    for(Alumno objetoAlumno : coleccionAlumnos){
                        System.out.println(objetoAlumno.toString());
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el rut del alumno a buscar");
                    int rutAlumnoBuscar = sc.nextInt();
                    sc.nextLine();
                    boolean existeAlumno = false;
                    for(Alumno objetoAlumno : coleccionAlumnos){
                        if (objetoAlumno.getRut() == rutAlumnoBuscar){
                            System.out.println(objetoAlumno.toString());
                            existeAlumno = true;
                            break;
                        }
                    }
                    if(!existeAlumno){
                        System.out.println("el alumno no esta registrado");
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el rut del alumno a buscar");
                    int rutAlumnoEditar = sc.nextInt();
                    sc.nextLine();
                    boolean existeAlumnoEditar = false;
                    for(Alumno objetoAlumno : coleccionAlumnos){
                        if (objetoAlumno.getRut() == rutAlumnoEditar){
                            System.out.println("Ingrese el nombre del alumno para modificar");
                            String nombreAlumnoModificar = sc.nextLine();
                            objetoAlumno.setNombre(nombreAlumnoModificar);
                            existeAlumnoEditar = true;
                            break;
                        }
                    }
                    if(!existeAlumnoEditar){
                        System.out.println("el alumno no esta registrado");
                    }
                    break;
                case 5:
                    System.out.println("Ingrese el rut del alumno a buscar");
                    int rutAlumnoEliminar = sc.nextInt();
                    sc.nextLine();
                    boolean existeAlumnoEliminar = false;
                    for(Alumno objetoAlumno : coleccionAlumnos){
                        if (objetoAlumno.getRut() == rutAlumnoEliminar){
                            coleccionAlumnos.remove(objetoAlumno);
                            existeAlumnoEliminar = true;
                            break;
                        }
                    }
                    if(!existeAlumnoEliminar){
                        System.out.println("el alumno no esta registrado");
                    }
                    break;
                case 6:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
            }


        }

    }
}