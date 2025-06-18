//Ezra Kai Alvez 297416 & Juan Manuel Martinez 315351
package dominio;

public class Contrato {

    private static int contador = 1; // Para numerar los contratos
    private int numero;
    private Vehiculo vehiculo; // Objeto de vehiculo
    private Empleado empleado; // Objeto de empleado
    private String valor;

    public Contrato(Vehiculo vehiculo, Empleado empleado, String valor) {
        this.numero = contador++;
        this.vehiculo = vehiculo;
        this.empleado = empleado;
        this.valor = valor;
    }

    // Getters y setters
    public int getNumero() {
        return numero;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo unVehiculo) {
        this.vehiculo = vehiculo;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado unEmpleado) {
        this.empleado = empleado;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String unValor) {
        valor = unValor;
    }

//    @Override
//    public String toString() {
//        return String.format("Contrato #%d - Vehículo: %s - Empleado: %s - Valor mensual: %.2f",
//                numero, vehiculo.getMatricula(), empleado.getNombre(), valor);
}    
//}
