package org.ejemplo;

public class Auto extends Vehiculo{

    private String patente;

    public Auto(String marca, String modelo, String color, String patente) {
        super(marca, modelo, color);
        this.patente = patente;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "patente='" + patente + '\'' +
                '}';
    }

    @Override
    public int calularPrecio(){
        return 5;
    }

    @Override
    public String Mensaje(){
        return "Auto.";
    }

}
