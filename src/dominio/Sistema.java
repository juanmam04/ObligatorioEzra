//Ezra Kai Alvez 297416 & Juan Manuel Martinez 315351

package dominio;

import java.io.Serializable; // Importar la interfaz Serializable
import java.util.ArrayList;

// La clase Sistema debe implementar Serializable
public class Sistema implements Serializable {
    private static final long serialVersionUID = 1L; // Recomendado para el control de versiones

    private ArrayList<Cliente> listaClientes;
    private ArrayList<Contrato> listaContratos;
    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Entrada> listaEntradas;
    private ArrayList<Salida> listaSalidas;
    private ArrayList<ServicioAdicional> listaServiciosAdicionales;
    private ArrayList<Vehiculo> listaVehiculos;
    
    //Constructor
    
    public Sistema(){
        this.listaClientes = new ArrayList<>();
        this.listaContratos = new ArrayList<>();
        this.listaEmpleados = new ArrayList<>();
        this.listaEntradas = new ArrayList<>();
        this.listaSalidas = new ArrayList<>();
        this.listaServiciosAdicionales = new ArrayList<>();
        this.listaVehiculos = new ArrayList<>();        
        
    }
    
    // getters de listas
    
    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }
    
    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }
    
    public ArrayList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }
    
    public ArrayList<Contrato> getListaContratos() {
        return listaContratos;
    }

    public ArrayList<Entrada> getListaEntradas() {
        return listaEntradas;
    }

    public ArrayList<Salida> getListaSalidas() {
        return listaSalidas;
    }

    public ArrayList<ServicioAdicional> getListaServiciosAdicionales() {
        return listaServiciosAdicionales;
    }
    
    // Metdos necesarios para cada sector (Ayuda de Chatgpt para logica)
    
    // Modo oscuro
    
    private boolean modoOscuro = false;

    public boolean isModoOscuro() {
        return modoOscuro;
    }

    public void cambiarModo() {
        modoOscuro = !modoOscuro;
    }
    
    // Clientes
    public boolean agregarCliente(Cliente unCliente) {
        if (buscarClientePorCedula(unCliente.getCedula()) == null) {
            listaClientes.add(unCliente);
            return true;
        }
        return false;
    }

    public boolean eliminarClientePorCedula(int unaCedula) {
        Cliente cliente = buscarClientePorCedula(unaCedula);
        if (cliente != null) {
            eliminarContratosDeCliente(cliente); // borra sus contratos también
            listaClientes.remove(cliente);
            return true;
        }
        return false;
    }

    public Cliente buscarClientePorCedula(int unaCedula) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula() == unaCedula) {
                return cliente;
            }
        }
        return null;
    }

//    // Vehículos
    public boolean agregarVehiculo(Vehiculo unVehiculo) {
        if (buscarVehiculoPorMatricula(unVehiculo.getMatricula()) == null) {
            listaVehiculos.add(unVehiculo);
            return true;
        }
        return false;
    }

    public Vehiculo buscarVehiculoPorMatricula(String unaMatricula) {
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getMatricula().equalsIgnoreCase(unaMatricula)) {
                return vehiculo;
            }
        }
        return null;
    }

    // Empleados
    public boolean agregarEmpleado(Empleado unEmpleado) {
        if (buscarEmpleadoPorCedula(unEmpleado.getCedula()) == null) {
            listaEmpleados.add(unEmpleado);
            return true;
        }
        return false;
    }
    
    public boolean eliminarEmpleadoPorCedula(int unaCedula) {
        Empleado empleado = buscarEmpleadoPorCedula(unaCedula);
        if (empleado != null) {
            listaEmpleados.remove(empleado);
            return true;
        }
        return false;
    }

    public Empleado buscarEmpleadoPorCedula(int unaCedula) {
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getCedula() == unaCedula) {
                return empleado;
            }
        }
        return null;
    }
    
    public void vaciarListaEmpleados() {
        listaEmpleados.clear();
    }
    
    // Contratos
    public boolean agregarContrato(Contrato unContrato) {
        for (Contrato contrato : listaContratos) {
            if (contrato.getVehiculo().getMatricula().equalsIgnoreCase(unContrato.getVehiculo().getMatricula())) {
                return false;
            }
        }
        listaContratos.add(unContrato);
        return true;
    }
    
    public boolean eliminarContrato(Contrato unContrato) {
        return listaContratos.remove(unContrato);
    }
    
    public void eliminarContratosDeCliente(Cliente unCliente) {
        ArrayList<Contrato> aEliminar = new ArrayList<>();
        for (Contrato contrato : listaContratos) {
            Vehiculo veh = contrato.getVehiculo();
            // Nota: Aquí parece haber un error en la lógica. Si la intención es eliminar
            // contratos asociados a un cliente, deberías buscar si el contrato está
            // asociado a ese cliente, no si el vehículo está en listaVehiculos.
            // Asumo que Contrato tiene una referencia a Cliente.
            // Por ahora, mantengo tu lógica, pero es un punto a revisar.
            if (listaVehiculos.contains(veh)) { // Esta condición no parece correcta para "contratos de cliente"
                aEliminar.add(contrato);
            }
        }
        listaContratos.removeAll(aEliminar);
    }

    // Entradas y salidas
    public boolean agregarEntrada(Entrada unaEntrada) {
        // Solo se permite si el vehículo no tiene una entrada activa (sin salida)
        for (Entrada entrada : listaEntradas) {
            if (entrada.getVehiculo().getMatricula().equalsIgnoreCase(unaEntrada.getVehiculo().getMatricula()) &&
                !entrada.isSalidaRegistrada()) {
                return false;
            }
        }
        listaEntradas.add(unaEntrada);
        return true;
    }
    
    public ArrayList<Entrada> obtenerEntradasActivas() {
        ArrayList<Entrada> activas = new ArrayList<>();
        for (Entrada entrada : listaEntradas) {
            if (!entrada.isSalidaRegistrada()) {
                activas.add(entrada);
            }
        }
        return activas;
    }
    
    public boolean agregarSalida(Salida unaSalida) {
        // Validar que la entrada asociada no tenga salida registrada
        Entrada entradaAsociada = unaSalida.getEntrada();
        if (entradaAsociada == null || entradaAsociada.isSalidaRegistrada()) {
            return false;
        }
        String fechaEntrada = entradaAsociada.getFecha();
        String horaEntrada = entradaAsociada.getHora();
        String fechaSalida = unaSalida.getFecha();
        String horaSalida = unaSalida.getHora();

        if (!esFechaYHoraPosterior(fechaEntrada, horaEntrada, fechaSalida, horaSalida)) {
            return false;
        }
        entradaAsociada.setSalidaRegistrada(true);
        listaSalidas.add(unaSalida);
        return true;
    }
    
    private boolean esFechaYHoraPosterior(String fechaEnt, String horaEnt, String fechaSal, String horaSal) {
        try {
            java.time.LocalDateTime entrada = java.time.LocalDateTime.parse(formatearFechaYHora(fechaEnt, horaEnt));
            java.time.LocalDateTime salida = java.time.LocalDateTime.parse(formatearFechaYHora(fechaSal, horaSal));
            return salida.isAfter(entrada);
        } catch (Exception e) {
            return false;
        }
    }
    
    private String formatearFechaYHora(String fecha, String hora) {
        // Convierte "dd/MM/yyyy" + "HH:mm" → "yyyy-MM-ddTHH:mm"
        // Lo hace para que internamente sea mas facil comparar las fechas para java
        String[] partesFecha = fecha.split("/");
        return String.format("%s-%s-%sT%s", partesFecha[2], partesFecha[1], partesFecha[0], hora);
    }
    
    // Servicios
    public boolean agregarServicioAdicional(ServicioAdicional unServicio) {
        if (unServicio != null && unServicio.getVehiculo() != null) {
            listaServiciosAdicionales.add(unServicio);
            return true;
        }
        return false;
    }
    
    public ArrayList<ServicioAdicional> obtenerServiciosDeVehiculo(Vehiculo unVehiculo) {
        ArrayList<ServicioAdicional> servicios = new ArrayList<>();
        for (ServicioAdicional servicio : listaServiciosAdicionales) {
            if (servicio.getVehiculo().getMatricula().equalsIgnoreCase(unVehiculo.getMatricula())) {
                servicios.add(servicio);
            }
        }
        return servicios;
    }
    
}