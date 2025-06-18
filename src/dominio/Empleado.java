//Ezra Kai Alvez 297416 & Juan Manuel Martinez 315351
package dominio;

public class Empleado {

    //Atributos de clase
    private String nombre;
    private int cedula;
    private String direccion;
    private int numEmpleado;

    //Constructor
    public Empleado(String unNombre, int unaCedula, String unaDireccion, int numEmpleado) {
        this.setNombre(unNombre);
        this.setCedula(unaCedula);
        this.setDireccion(unaDireccion);
        //this.setNumEmpleado(unNumEmpleado);
    }

    //Metodos de acceso y modificacion
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String unNombre) {
        nombre = unNombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int unaCedula) {
        cedula = unaCedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String unaDireccion) {
        direccion = unaDireccion;
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int unNumEmpleado) {
        numEmpleado = unNumEmpleado;
    }

    @Override
    public String toString() {
        return "Nombre" + this.getNombre() + " - Cedula" + this.getCedula() + " - Direccion" + this.getDireccion() + " - Numero de empleado " + this.getNumEmpleado();
    }
}
