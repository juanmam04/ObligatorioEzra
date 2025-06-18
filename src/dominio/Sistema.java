//Ezra Kai Alvez 297416 & Juan Manuel Martinez 315351

package dominio;

import java.util.ArrayList;

public class Sistema {
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Contrato> listaContratos;
    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Entrada> listaEntradas;
    private ArrayList<Salida> listaSalidas;
    private ArrayList<ServicioAdicional> listaServiciosAdicionales;
    private ArrayList<Vehiculo> listaVehiculos;
    
    //Constructor
    
    public Sistema(){
        this.listaClientes= new ArrayList<>();
        this.listaContratos= new ArrayList<>();
        this.listaEmpleados= new ArrayList<>();
        this.listaEntradas= new ArrayList<>();
        this.listaSalidas= new ArrayList<>();
        this.listaServiciosAdicionales= new ArrayList<>();
        this.listaVehiculos= new ArrayList<>();        
        
    }
    
    // Metdos necesarios para cada sector (Ayuda de Chatgpt para logica)
    
    // Clientes
    
    boolean agregarCliente(Cliente unCliente){
        if (buscarClientePorCedula(unCliente.getCedula()) == null) {
            listaClientes.add(unCliente);
            return true;
        }
        return false;
    }

    public boolean eliminarClientePorCedula(int unaCedula){
        Cliente cliente = buscarClientePorCedula(unaCedula);
        if (cliente != null) {
//            eliminarContratosDeCliente(cliente); // borra sus contratos también
            listaClientes.remove(cliente);
            return true;
        }
        return false;
    }

    public Cliente buscarClientePorCedula(int unaCedula){
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula() == unaCedula) return cliente;
        }
        return null;
    }

//    // Vehículos
//    boolean agregarVehiculo(Vehiculo unVehiculo){
//        
//    }
//
//    Vehiculo buscarVehiculoPorMatricula(String unaMatricula){
//        
//    }
//
//    // Empleados
//    boolean agregarEmpleado(Empleado unEmpleado){
//        
//    }
//
//    Empleado buscarEmpleadoPorCedula(int unaCedula){
//        
//    }
//    
//    // Contratos
//    boolean agregarContrato(Contrato unContrato){
//        
//    }
//            
//    ArrayList<Contrato> obtenerContratosPorCliente(Cliente unCliente){
//        
//    }
//    
//    boolean eliminarContratosDeCliente(Cliente unCliente){
//        
//    }
//
//    // Entradas y salidas
//    boolean agregarEntrada(Entrada unaEntrada){
//        
//    }
//    
//    boolean agregarSalida(Salida unaSalida){
//        
//    }
//    
//    ArrayList<Entrada> obtenerEntradasActivas(){
//        
//    }
//    
//    // Servicios
//    boolean agregarServicioAdicional(ServicioAdicional unServicio){
//        
//    }
//    
//    ArrayList<ServicioAdicional> obtenerServiciosDeVehiculo(Vehiculo unVehiculo){
//        
//    }

}