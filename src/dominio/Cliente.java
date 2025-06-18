//Ezra Kai Alvez 297416 & Juan Manuel Martinez 315351

package dominio;

public class Cliente {
    
    //Atributos de clase
    private String nombre;
    private String direccion;
    private int celular;
    private int cedula;
    private int anoIngreso;
    
    //Constructor
    
    public Cliente(String unNombre, String unaDireccion, int unCelular, int unaCedula, int unAnoIngreso){
        this.setNombre(unNombre);
        this.setDireccion(unaDireccion);
        this.setCelular(unCelular);
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
    
    public int getCelular(){
        return celular;
    }
    
    public void setCelular(int unCelular){
        celular = unCelular;
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
        return this.getNombre()+" "+this.getDireccion()+" "+this.getCelular()+" "+this.getCedula()+" "+this.getAnoIngreso();
    }
}
