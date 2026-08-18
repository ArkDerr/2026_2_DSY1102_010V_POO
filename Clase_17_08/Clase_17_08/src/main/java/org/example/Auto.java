package org.example;

public class Auto extends Vehiculo {
    //Atributo
    String color;

    //Constructor
    public Auto(String patente, String marca, int precioPorDia, String color) {
        super(patente, marca, precioPorDia);
        this.color = color;
    }

    //Get y Set
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //Metodos
    @Override
    public void imprimirDatos(){
        System.out.println("Patente: "+patente);
        System.out.println("Marca: "+marca);
        System.out.println("Precio por dia: "+precioPorDia);
        System.out.println("Color: "+color);
    }

    //Sobrecarga
    public int calcularTotalArriendo(int dias, int descuento){
        int total = precioPorDia*dias;
        int totalConDescuento = total-descuento;
        return totalConDescuento;
    }
}
