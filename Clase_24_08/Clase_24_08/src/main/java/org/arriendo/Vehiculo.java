package org.arriendo;

import java.time.LocalDate;

public abstract class Vehiculo {

    //Atributos
    private String patente;
    private String marca;
    private int anio;
    private double tarifaDiaria;
    private LocalDate fechaRegistro;
    private boolean disponible;

    //Constructor
    public Vehiculo(String patente, String marca, int anio, double tarifaDiaria, LocalDate fechaRegistro) {
        this.patente = patente;
        this.marca = marca;
        this.anio = anio;
        this.tarifaDiaria = tarifaDiaria;
        this.fechaRegistro = fechaRegistro;
        this.disponible = true;
    }

    //Getter y Setter
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getTarifaDiaria() {
        return tarifaDiaria;
    }

    public void setTarifaDiaria(double tarifaDiaria) {
        this.tarifaDiaria = tarifaDiaria;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    //Metodos
    public void mostrarDatos(){
        System.out.println("###################################################");
        System.out.println("Patente: " + patente);
        System.out.println("Marca: " + marca);
        System.out.println("Anio: " + anio);
        System.out.println("Tarifa diaria: " + tarifaDiaria);
        System.out.println("Fecha de registro: " + fechaRegistro);
        System.out.println("Disponible: " + disponible);
        System.out.println("###################################################");
    }

    //Metodo Abstracto
    public abstract double calcularArriendo(int dias);

}
