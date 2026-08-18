package org.example;

public class Vehiculo {

    //Atributos
    protected String patente;
    protected String marca;
    protected int precioPorDia;

    //Contructor
    public Vehiculo(String patente, String marca, int precioPorDia) {
        this.patente = patente;
        this.marca = marca;
        this.precioPorDia = precioPorDia;
    }

    //Get y Set
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

    public int getPrecioPorDia() {
        return precioPorDia;
    }

    public void setPrecioPorDia(int precioPorDia) {
        this.precioPorDia = precioPorDia;
    }

    //Metodos
    //Imprimir datos
    public void imprimirDatos(){
        System.out.println("Patente: "+patente);
        System.out.println("Marca: "+marca);
        System.out.println("Precio por dia: "+precioPorDia);
    }

    //Calcular total del arriendo
    public int calcularTotalArriendo(int dias){
        int total = precioPorDia*dias;
        return total;
    }

    public void calcularTotalArriendov2(int dias){
        int total = precioPorDia*dias;
        System.out.println("El valor total del arriendov2 es: "+total);
    }
}
