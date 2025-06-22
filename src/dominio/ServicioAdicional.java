//Ezra Kai Alvez 297416 & Juan Manuel Martinez 315351

package dominio;

public class ServicioAdicional {

    private String tipo;
    private String fecha;
    private String hora;
    private Vehiculo vehiculo;
    private Empleado empleado;
    private double costo;

    public ServicioAdicional(String unTipo, String unaFecha, String unaHora, Vehiculo unVehiculo, Empleado unEmpleado, double unCosto) {
        this.setTipo(unTipo);
        this.setFecha(unaFecha);
        this.setHora(unaHora);
        this.setVehiculo(unVehiculo);
        this.setEmpleado(unEmpleado);
        this.setCosto(unCosto);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String unTipo) {
        tipo = unTipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String unaFecha) {
        fecha = unaFecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String unaHora) {
        hora = unaHora;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo unVehiculo) {
        vehiculo = unVehiculo;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado unEmpleado) {
        empleado = unEmpleado;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double unCosto) {
        costo = unCosto;
    }

    @Override
    public String toString() {
        return String.format("<html>Tipo: %s<br>Fecha: %s - Hora: %s<br>Vehículo: %s<br>Empleado: %s<br>Costo: $%.2f</html>",
                tipo.toUpperCase(), fecha, hora, vehiculo.getMatricula().toUpperCase(), empleado.getNombre().toUpperCase(), costo);
    }
}