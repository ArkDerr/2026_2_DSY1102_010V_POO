//Clase
public abstract class Persona {

    /*
    Buenas practicas:
    Clase: PascalCase
    Atributos: camelCase
    Métodos: camelCase
    Variable local: camelCase
    Constante: MAYÚSCULA
    Paquete: minúsculas
     */

    //Atributos
    private String nombrePersona;
    private String apellidoPersona;
    private int edadPersona;

    //Constructor sin parametros
    public Persona() {
    }

    //Constructor con parametros
    public Persona(String nombrePersona, String apellidoPersona, int edadPersona) {
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
        this.edadPersona = edadPersona;
    }

    //Metodos (Con y sin parametros / Con y sin retorno)

    //Getter y Setter
    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    public int getEdadPersona() {
        return edadPersona;
    }

    public void setEdadPersona(int edadPersona) {
        this.edadPersona = edadPersona;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombrePersona='" + nombrePersona + '\'' +
                ", apellidoPersona='" + apellidoPersona + '\'' +
                ", edadPersona=" + edadPersona +
                '}';
    }
}
