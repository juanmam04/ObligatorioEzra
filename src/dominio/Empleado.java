//Ezra Kai Alvez 297416 & Juan Manuel Martinez 315351
package dominio;
import java.io.Serializable;
public class Empleado implements Serializable{

    //Atributos de clase
    private String nombre;
    private int cedula;
    private String direccion;
    private int numeroEmp;

    //Constructor
    public Empleado(String unNombre, int unaCedula, String unaDireccion, int unNumeroEmp) {
        this.setNombre(unNombre);
        this.setCedula(unaCedula);
        this.setDireccion(unaDireccion);
        this.setNumeroEmp(unNumeroEmp);
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

    public int getNumeroEmp() {
        return numeroEmp;
    }

    public void setNumeroEmp(int unNumeroEmp) {
        numeroEmp = unNumeroEmp;
    }

    @Override
    public String toString() {
        return "<html>" +
               "Nombre: " + nombre.toUpperCase() + "<br>" +
               "Cédula: " + cedula + "<br>" +
               "Dirección: " + direccion.toUpperCase() + "<br>" +
               "Número de empleado: " + numeroEmp +
               "</html>";
    }
}
