//Ezra Kai Alvez 297416 & Juan Manuel Martinez 315351
package dominio;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Contrato implements Serializable{

    private static int contador = 1;
    private int numero;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private Empleado empleado;
    private String valor;
    private String fecha; // "dd/MM/yyyy"
    private String hora;  // "HH:mm"


    public Contrato(Cliente cliente, Vehiculo vehiculo, Empleado empleado, String valor) {
        this.numero = contador++;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.empleado = empleado;
        this.valor = valor;
        this.fecha = fecha;
        this.hora = hora;
    }
    
    public LocalDateTime getFechaYHora() {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            return LocalDateTime.parse(fecha + " " + hora, formatter);
        } catch (Exception e) {
            return null;
        }
    }


    // Getters
    public int getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public String getValor() {
        return valor;
    }
    
    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    // Setters
    public void setCliente(Cliente unCliente) {
        this.cliente = unCliente;
    }

    public void setVehiculo(Vehiculo unVehiculo) {
        this.vehiculo = unVehiculo;
    }

    public void setEmpleado(Empleado unEmpleado) {
        this.empleado = unEmpleado;
    }

    public void setValor(String unValor) {
        this.valor = unValor;
    }

    @Override
    public String toString() {
        return "<html>" +
               "Contrato #" + numero + "<br>" +
               "Cliente: " + cliente.getNombre().toUpperCase() + "<br>" +
               "Vehículo: " + vehiculo.getMatricula().toUpperCase() + "<br>" +
               "Empleado: " + empleado.getNombre().toUpperCase() + "<br>" +
               "Valor mensual: " + valor +
               "</html>";
    }
}
