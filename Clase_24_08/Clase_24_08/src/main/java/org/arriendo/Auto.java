package org.arriendo;

import java.time.LocalDate;

public class Auto extends Vehiculo implements Arrendable, Mantenible{

    private int cantidadPuertas;

    public Auto(String patente, String marca, int anio, double tarifaDiaria, LocalDate fechaRegistro, int cantidadPuertas) {
        super(patente, marca, anio, tarifaDiaria, fechaRegistro);
        this.cantidadPuertas = cantidadPuertas;
    }

    public int getCantidadPuertas() {
        return cantidadPuertas;
    }

    public void setCantidadPuertas(int cantidadPuertas) {
        this.cantidadPuertas = cantidadPuertas;
    }

    @Override
    public double calcularArriendo(int dias){
        return getTarifaDiaria() * dias;
    }

    @Override
    public void arrendar(){
         if (isDisponible()){
             setDisponible(false);
             System.out.println("El auto patente " + getPatente() + " se ha arrendo correctamente");
         } else {
             System.out.println("El auto patente " + getPatente() + " no se puede arrendar ya que no esta disponible");
         }
    }

    @Override
    public void devolver(){
        if (!isDisponible()){
            setDisponible(true);
            System.out.println("El auto patente " + getPatente() + " se ha devuelto correctamente");
        } else {
            System.out.println("El auto patente " + getPatente() + " ya se devolvio");
        }
    }

    @Override
    public void realizarMantenimiento(){
        System.out.println("Se realizo el mantenimiento del Auto patente " + getPatente());
    }


}
