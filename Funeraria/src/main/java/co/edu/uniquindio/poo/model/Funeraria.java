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

    }

    public void registrarEmpleado(Empleado empleado) {
    }

    public void mostrarClientes() {
    }

    public void mostrarEmpleados() {
    }

    //public


}
