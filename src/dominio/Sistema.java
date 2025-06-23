//Ezra Kai Alvez 297416 & Juan Manuel Martinez 315351

package dominio;

import java.io.Serializable; // Importar la interfaz Serializable
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


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
        System.out.println("Set salidaRegistrada: " + entradaAsociada + " / " + entradaAsociada.getVehiculo().getMatricula());
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
    
    public boolean vehiculoTieneEntradaRegistrada(Vehiculo vehiculo) {
        for (Entrada e : listaEntradas) {
            if (e.getVehiculo().equals(vehiculo)) {
                return true;
            }
        }
        return false;
    }
    
    // Reportes
    
    public ArrayList<String[]> generarHistorialDeVehiculo(String matricula, boolean entradas, boolean salidas, boolean servicios, boolean todos, boolean ascendente) {
        ArrayList<String[]> resultado = new ArrayList<>();

        if (todos || entradas) {
            for (Entrada e : this.getListaEntradas()) {
                if (e.getVehiculo().getMatricula().equalsIgnoreCase(matricula)) {
                    resultado.add(new String[]{e.getFecha() + " " + e.getHora(), "Entrada", e.getEmpleado().getNombre(), e.getNota()});
                }
            }
        }

        if (todos || salidas) {
            for (Salida s : this.getListaSalidas()) {
                if (s.getEntrada().getVehiculo().getMatricula().equalsIgnoreCase(matricula)) {
                    resultado.add(new String[]{s.getFecha() + " " + s.getHora(), "Salida", s.getEmpleado().getNombre(), s.getComentario()});
                }
            }
        }

        if (todos || servicios) {
            for (ServicioAdicional sa : this.getListaServiciosAdicionales()) {
                if (sa.getVehiculo().getMatricula().equalsIgnoreCase(matricula)) {
                    resultado.add(new String[]{sa.getFecha() + " " + sa.getHora(), "Servicio", sa.getEmpleado().getNombre(), sa.getTipo() + " - $" + sa.getCosto()});
                }
            }
        }

        if (ascendente) {
            resultado.sort(Comparator.comparing(arr -> arr[0]));
        } else {
            resultado.sort(Comparator.comparing((String[] arr) -> arr[0]).reversed());
        }

        return resultado;
    }
    
    public ArrayList<String> getMovimientosEnFranja(LocalDate fecha, int horaInicio, int horaFin) {
        ArrayList<String> resultado = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        for (Entrada entrada : listaEntradas) {
            LocalDateTime dt = entrada.getFechaYHora();
            if (mismaFranja(dt, fecha, horaInicio, horaFin)) {
                resultado.add("Entrada - " + entrada.getVehiculo().getMatricula() + " - " + dt.format(formatter));
            }
        }

        for (Salida salida : listaSalidas) {
            LocalDateTime dt = salida.getFechaYHora();
            if (mismaFranja(dt, fecha, horaInicio, horaFin)) {
                resultado.add("Salida - " + salida.getVehiculo().getMatricula() + " - " + dt.format(formatter));
            }
        }

        for (Contrato contrato : listaContratos) {
            LocalDateTime dt = contrato.getFechaYHora();
            if (mismaFranja(dt, fecha, horaInicio, horaFin)) {
                resultado.add("Servicio - " + contrato.getVehiculo().getMatricula() + " - " + dt.format(formatter));
            }
        }
        
        for (ServicioAdicional servicio : listaServiciosAdicionales) {
            LocalDateTime dt = servicio.getFechaYHora();
            if (dt != null && mismaFranja(dt, fecha, horaInicio, horaFin)) {
                resultado.add("Servicio - " + servicio.getVehiculo().getMatricula() + " - " + dt.format(formatter));
            }
        }

        return resultado;
    }

    private boolean mismaFranja(LocalDateTime dt, LocalDate date, int hInicio, int hFin) {
        if (dt == null) return false;
        return dt.toLocalDate().equals(date) &&
               dt.getHour() >= hInicio &&
               dt.getHour() < hFin;
    }
    
    public ArrayList<String> obtenerServiciosMasUtilizados() {
        HashMap<String, Integer> contador = new HashMap<>();

        for (ServicioAdicional s : listaServiciosAdicionales) {
            String tipo = s.getTipo().toUpperCase();
            contador.put(tipo, contador.getOrDefault(tipo, 0) + 1);
        }

        ArrayList<Map.Entry<String, Integer>> listaOrdenada = new ArrayList<>(contador.entrySet());
        listaOrdenada.sort((a, b) -> b.getValue() - a.getValue());

        ArrayList<String> resultado = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : listaOrdenada) {
            resultado.add(entry.getKey() + " - " + entry.getValue() + " usos");
        }

        return resultado;
    }


    public String getEstadiaMasLarga() {
        Duration duracionMax = Duration.ZERO;
        Entrada entradaMax = null;
        Salida salidaMax = null;

        for (Entrada entrada : listaEntradas) {
            if (entrada.isSalidaRegistrada()) {
                for (Salida salida : listaSalidas) {
                    Entrada eSal = salida.getEntrada();
                    if (eSal.getVehiculo().getMatricula().equalsIgnoreCase(entrada.getVehiculo().getMatricula())
                        && eSal.getFecha().equals(entrada.getFecha())
                        && eSal.getHora().equals(entrada.getHora())) {

                        LocalDateTime entradaDT = entrada.getFechaYHora();
                        LocalDateTime salidaDT = salida.getFechaYHora();

                        if (entradaDT != null && salidaDT != null) {
                            Duration duracion = Duration.between(entradaDT, salidaDT);
                            if (duracion.compareTo(duracionMax) > 0) {
                                duracionMax = duracion;
                                entradaMax = entrada;
                                salidaMax = salida;
                            }
                        }
                    }
                }
            }
        }

        if (entradaMax == null || salidaMax == null) {
            return "No se encontraron estadías registradas.";
        }

        long horas = duracionMax.toHours();
        long minutos = duracionMax.toMinutes() % 60;

        return "Vehículo: " + entradaMax.getVehiculo().getMatricula().toUpperCase() +
               "\nEmpleado entrada: " + entradaMax.getEmpleado().getNombre() +
               "\nEmpleado salida: " + salidaMax.getEmpleado().getNombre() +
               "\nDuración: " + horas + " horas y " + minutos + " minutos";
    }

    
    public ArrayList<String> obtenerEmpleadosConMenosMovimientos() {
        HashMap<String, Integer> mapaMovimientos = new HashMap<>();

        // Inicializar con 0
        for (Empleado emp : listaEmpleados) {
            mapaMovimientos.put(emp.getNombre(), 0);
        }

        // Contar entradas
        for (Entrada e : listaEntradas) {
            String nombre = e.getEmpleado().getNombre();
            mapaMovimientos.put(nombre, mapaMovimientos.get(nombre) + 1);
        }

        // Contar salidas
        for (Salida s : listaSalidas) {
            String nombre = s.getEmpleado().getNombre();
            mapaMovimientos.put(nombre, mapaMovimientos.get(nombre) + 1);
        }

        // Ordenar por cantidad de movimientos (ascendente)
        List<Map.Entry<String, Integer>> listaOrdenada = new ArrayList<>(mapaMovimientos.entrySet());
        listaOrdenada.sort(Map.Entry.comparingByValue());

        ArrayList<String> resultado = new ArrayList<>();
        for (int i = 0; i < Math.min(3, listaOrdenada.size()); i++) {
            Map.Entry<String, Integer> entry = listaOrdenada.get(i);
            resultado.add(entry.getKey() + " - Movimientos: " + entry.getValue());
        }

        return resultado;
    }
    
    public ArrayList<String> obtenerClientesConMasContratos() {
        HashMap<String, Integer> mapaContratos = new HashMap<>();

        for (Contrato c : listaContratos) {
            String nombreCliente = c.getCliente().getNombre();
            mapaContratos.put(nombreCliente, mapaContratos.getOrDefault(nombreCliente, 0) + 1);
        }

        // Ordenamos por cantidad descendente
        ArrayList<Map.Entry<String, Integer>> listaOrdenada = new ArrayList<>(mapaContratos.entrySet());
        listaOrdenada.sort((a, b) -> b.getValue() - a.getValue());

        ArrayList<String> resultado = new ArrayList<>();
        for (int i = 0; i < Math.min(3, listaOrdenada.size()); i++) {
            Map.Entry<String, Integer> entry = listaOrdenada.get(i);
            resultado.add(entry.getKey().toUpperCase() + " - Contratos: " + entry.getValue());
        }

        return resultado;
    }

    
}