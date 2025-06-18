
package dominio;

public class Entrada {

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
        return String.format("Vehículo: %s - Fecha: %s - Hora: %s - Empleado: %s - Nota: %s",
                vehiculo.getMatricula(), fecha, hora, empleado.getNombre(), nota);
    }
}