//Ezra Kai Alvez 297416 & Juan Manuel Martinez 315351

package dominio;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.io.Serializable;
import java.time.LocalDateTime;


public class Salida implements Serializable{
    private Entrada entrada;
    private String fecha;
    private String hora;
    private Empleado empleado;
    private String comentario;

    public Salida(Entrada unaEntrada, String unaFecha, String unaHora, Empleado unEmpleado, String unComentario) {
        this.setEntrada(unaEntrada);
        this.setFecha(unaFecha);
        this.setHora(unaHora);
        this.setEmpleado(unEmpleado);
        this.setComentario(unComentario);
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
        return entrada != null ? entrada.getVehiculo() : null;
    }

    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntrada(Entrada unaEntrada) {
        this.entrada = unaEntrada;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String unaFecha) {
        this.fecha = unaFecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String unaHora) {
        this.hora = unaHora;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado unEmpleado) {
        this.empleado = unEmpleado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String unComentario) {
        this.comentario = unComentario;
    }

    @Override
    public String toString() {
        return String.format("Salida de vehículo: %s - Fecha: %s - Hora: %s - Empleado: %s - Comentario: %s",
                entrada.getVehiculo().getMatricula(), fecha, hora, empleado.getNombre(), comentario);
    }
    
    // Verificar la duración de la estadía (Ayuda de Chatgpt)
    
    public String obtenerDuracionEstadia() {
        try {
            DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime horaEntrada = LocalTime.parse(entrada.getHora(), formatoHora);
            LocalTime horaSalida = LocalTime.parse(this.getHora(), formatoHora);

            Duration duracion = Duration.between(horaEntrada, horaSalida);
            long horas = duracion.toHours();
            long minutos = duracion.toMinutes() % 60;

            return horas + " horas y " + minutos + " minutos";
        } catch (Exception e) {
            return "Hora inválida";
        }
    }
    
    //    Probar esto en la interfaz para llamarlo:
    //    
    //    String tiempo = salida.getDuracionEstadia();
    //    System.out.println("Estuvo: " + tiempo);
}