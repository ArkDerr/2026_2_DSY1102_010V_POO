package org.ejemploexception;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try {
            Producto p = new Producto("Pila", 50);

            System.out.println(p.toString());

            p.descuentoStock(100);

            System.out.println(p.toString());

        } catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        } catch (ErrorDescuentoStockException e){
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        } finally{
            System.out.println("Fin del programa");
        }



    }
}