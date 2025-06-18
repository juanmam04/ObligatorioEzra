
package dominio;

public class Cliente {
    
    //Atributos de clase
    private String nombre;
    private String direccion;
    private int cedula;
    private int anoIngreso;
    
    //Constructor
    
    public Cliente(String unNombre, String unaDireccion, int unaCedula, int unAnoIngreso){
        this.setNombre(unNombre);
        this.setDireccion(unaDireccion);
        this.setCedula(unaCedula);
        this.setAnoIngreso(unAnoIngreso);
    }
    
    //Metodos de acceso y modificacion
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String unNombre){
        nombre = unNombre;
    }
    
    public String getDireccion(){
        return direccion;
    }
    
    public void setDireccion(String unaDireccion){
        direccion = unaDireccion;
    }
    
    public int getCedula(){
        return cedula;
    }
    
    public void setCedula(int unaCedula){
        cedula = unaCedula;
    }
    
    public int getAnoIngreso(){
        return anoIngreso;
    }
    
    public void setAnoIngreso(int unAnoIngreso){
        anoIngreso = unAnoIngreso;
    }
    
    @Override
    public String toString(){
        return "Nombre"+this.getNombre()+" - Direccion"+this.getDireccion()+" - Cedula"+this.getCedula()+" - Año de ingreso"+this.getAnoIngreso();
    }
}
