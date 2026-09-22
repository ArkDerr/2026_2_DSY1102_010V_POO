package org.ejemploexception;

public class Producto {
    private String nombre;
    private int stock;


    public Producto(String nombre, int stock) {
        //this.nombre = nombre;
        //this.stock = stock;
        setNombre(nombre);
        setStock(stock);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.equals(" ") || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock <= 0) {
            throw new IllegalArgumentException("El stock debe ser mayor a 0");
        }
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", stock=" + stock +
                '}';
    }

    public void descuentoStock(int cantidad) throws ErrorDescuentoStockException {
        if (cantidad <= 0) {
            throw  new IllegalArgumentException("El cantidad debe ser mayor a 0");
        }

        if (cantidad > stock) {
            throw new ErrorDescuentoStockException("El cantidad es mayor a el stock");
        }

        stock = stock - cantidad;
        System.out.println("El nuevo stock es: " + stock);
    }
}
