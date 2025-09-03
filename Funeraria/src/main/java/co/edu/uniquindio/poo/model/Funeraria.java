package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.List;

public class Funeraria {
    private String nombre;
    private String nit;
    private List<Empleado> listEmpleados;
    private List<Cliente> listClientes;
    private List<AdquirirServicio> listServiciosAdquiridos;
    private static Funeraria funeraria;

    private Funeraria() {
        this.nombre = "Funeraria premium";
        this.nit = "18838911-1";
        this.listEmpleados = new ArrayList<>();
        this.listClientes= new ArrayList<>();
        this.listServiciosAdquiridos= new ArrayList<>();
    }
    //Singleton method
    public static Funeraria getInstance() {
        if (funeraria == null) {
            funeraria = new Funeraria();
        }
        return funeraria;
    }


    public void agregarEmpleado(Empleado empleado) {
        if (!this.listEmpleados.contains(empleado)) {
            listEmpleados.add(empleado);
            System.out.println("Empleado agregado con exito.");
        }else{
            System.out.println("El empleado ya existe");
        }
    }

    public void eliminarEmpleado(Empleado empleado) {
        if (this.listEmpleados.contains(empleado)) {
            this.listEmpleados.remove(empleado);
            System.out.println("Empleado eliminado con exito.");
        }else {
            System.out.println("El empleado a eliminar no existe");
        }
    }

    public void registrarCliente(Cliente cliente) {
        if (!this.listClientes.contains(cliente)) {
            listClientes.add(cliente);
            System.out.println("Cliente registrado con exito.");
        }else{
            System.out.println("El cliente ya existe");
        }

    }

    // eliminar cliente por documento
    public void eliminarCliente(String documento) {
        Cliente clienteAEliminar = null;
        for (Cliente cliente : listClientes) {
            if (cliente.getIdentificacion().equals(documento)) {
                clienteAEliminar = cliente;
                break;
            }
        }
        if (clienteAEliminar != null) {
            listClientes.remove(clienteAEliminar);
            System.out.println("Cliente eliminado con exito.");
        } else {
            System.out.println("El cliente a eliminar no existe");
        }
    }


    public void actualizarCliente(String documento, String nuevoNombre, String nuevoEmail) {
        Cliente clienteAActualizar = null;
        for (Cliente cliente : listClientes) {
            if (cliente.getIdentificacion().equals(documento)) {
                clienteAActualizar = cliente;
                break;
            }
        }
        if (clienteAActualizar != null) {
            clienteAActualizar.setNombre(nuevoNombre);
            clienteAActualizar.setEmail(nuevoEmail);
            System.out.println("Cliente actualizado con exito.");
        } else {
            System.out.println("El cliente a actualizar no existe");
        }
    }
    public void registrarEmpleado(Empleado empleado) {

        if (!this.listEmpleados.contains(empleado)) {
            listEmpleados.add(empleado);
            System.out.println("Empleado registrado con exito.");
        }else{
            System.out.println("El empleado ya existe");
        }
    }

    public void mostrarClientes() {
        if (listClientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            System.out.println("Lista de clientes:");
            for (Cliente cliente : listClientes) {
                System.out.println(cliente);
            }
        }
    }

    public void mostrarEmpleados() {
        if (listEmpleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            System.out.println("Lista de empleados:");
            for (Empleado empleado : listEmpleados) {
                System.out.println(empleado);
            }
        }
    }

    public void actualizarEmpleado(String documento, String nuevoNombre, String nuevoEmail, TipoCargo nuevoCargo) {
        Empleado empleadoAActualizar = null;
        for (Empleado empleado : listEmpleados) {
            if (empleado.getIdentificacion().equals(documento)) {
                empleadoAActualizar = empleado;
                break;
            }
        }
        if (empleadoAActualizar != null) {
            empleadoAActualizar.setNombre(nuevoNombre);
            empleadoAActualizar.setEmail(nuevoEmail);
            empleadoAActualizar.setCargo(nuevoCargo);
            System.out.println("Empleado actualizado con exito.");
        } else {
            System.out.println("El empleado a actualizar no existe");
        }
    }

    //public


}
