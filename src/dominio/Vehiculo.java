//Ezra Kai Alvez 297416 & Juan Manuel Martinez 315351
package dominio;
import java.io.Serializable;
public class Vehiculo implements Serializable{

    private String matricula;
    private String marca;
    private String modelo;
    private String estado;

    public Vehiculo(String unaMatricula, String unaMarca, String unModelo, String unEstado) {
        this.setMatricula(unaMatricula);
        this.setMarca(unaMarca);
        this.setModelo(unModelo);
        this.setEstado(unEstado);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String unaMatricula) {
        this.matricula = unaMatricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String unaMarca) {
        this.marca = unaMarca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String unModelo) {
        this.modelo = unModelo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String unEstado) {
        this.estado = unEstado;
    }

    @Override
    public String toString() {
        return "<html>" +
               "Matrícula: " + this.getMatricula().toUpperCase() + "<br>" +
               "Marca: " + this.getMarca().toUpperCase() + "<br>" +
               "Modelo: " + this.getModelo() + "<br>" +
               "Estado: " + this.getEstado().toUpperCase() +
               "</html>";
    }
}
