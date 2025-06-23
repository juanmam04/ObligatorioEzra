//Ezra Kai Alvez 297416 & Juan Manuel Martinez 315351
package dominio;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Entrada implements Serializable{
    private Vehiculo vehiculo;
    private String fecha; 
    private String hora; 
    private Empleado empleado;
    private String nota;
    private boolean salidaRegistrada; // para saber si ya se hizo la salida

    public Entrada(Vehiculo unVehiculo, String unaFecha, String unaHora, Empleado unEmpleado, String unaNota) {
        this.vehiculo = unVehiculo;
        this.fecha = unaFecha;
        this.hora = unaHora;
        this.empleado = unEmpleado;
        this.nota = unaNota;
        this.salidaRegistrada = false;
    }
    
    public LocalDateTime getFechaYHora() {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            return LocalDateTime.parse(fecha + " " + hora, formatter);
        } catch (Exception e) {
            return null;
        }
    }


    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo unVehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String unaFecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String unaHora) {
        this.hora = hora;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado unEmpleado) {
        this.empleado = empleado;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String unaNota) {
        this.nota = nota;
    }

    public boolean isSalidaRegistrada() {
        return salidaRegistrada;
    }

    public void setSalidaRegistrada(boolean unaSalidaRegistrada) {
        this.salidaRegistrada = salidaRegistrada;
    }

    @Override
    public String toString() {
        return empleado.getNombre().toUpperCase(); // o podés personalizarlo más si querés
    }
}