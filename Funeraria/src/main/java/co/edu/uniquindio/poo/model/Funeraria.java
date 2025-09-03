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

    public static Funeraria getInstance() {
        if (funeraria == null) {
            funeraria = new Funeraria();
        }
        return funeraria;
    }

    public boolean empleadoExiste(String identificacion) {
        for (Empleado empleado : listEmpleados) {
            if (empleado.getIdentificacion().equalsIgnoreCase(identificacion)) {
                return true;
            }
        }
        return false;
    }



    public void agregarEmpleado(Empleado empleado){
        if(empleadoExiste(empleado.getIdentificacion())){
            System.out.println("El empleado existe en el sistema");
        }else{
            listEmpleados.add(empleado);
            System.out.println("Empleado agregado con exito");
        }
    }


    public void eliminarEmpleado(String identificacion){
        for(Empleado empleado : listEmpleados) {
            if(empleado.getIdentificacion().equalsIgnoreCase(identificacion)){
                listEmpleados.remove(empleado);
                System.out.println("Empleado eliminado exitosamente");
                break;
            }
        }
    }

    public boolean actualizarEmpleado(String identificacion, Empleado empleado){
        for(int i=0;i<listEmpleados.size();i++){
            if(listEmpleados.get(i).getIdentificacion().equalsIgnoreCase(identificacion)){
                listEmpleados.set(i, empleado);
                System.out.println("Empleado actualizado con exito");
                return true;
            }
        }
        return false;
    }


    public boolean clienteExiste(String identificacion){
        for (Cliente cliente : listClientes) {
            if (cliente.getIdentificacion().equalsIgnoreCase(identificacion)) {
                return true;
            }
        }
        return false;
    }

    public void registrarCliente(Cliente cliente) {
        if(clienteExiste(cliente.getIdentificacion())){
            System.out.println("El cliente existe en el sistema");
        }else{
            listClientes.add(cliente);
            System.out.println("Cliente registrado con exito");
        }

    }

    public void eliminarCliente(String identificacion){
        for(Cliente cliente : listClientes) {
            if(cliente.getIdentificacion().equalsIgnoreCase(identificacion)){
                listClientes.remove(cliente);
                System.out.println("Cliente eliminado exitosamente");
                break;
            }
        }
    }

    public boolean actualizarCliente(String identificacion, Cliente cliente){
        for(int i=0;i<listClientes.size();i++){
            if(listClientes.get(i).getIdentificacion().equalsIgnoreCase(identificacion)){
                listClientes.set(i, cliente);
                System.out.println("Cliente actualizado con exito");
                return true;
            }
        }
        return false;
    }

    public Cliente buscarCliente(String identificacion){
        for(Cliente cliente : listClientes){
            if(cliente.getIdentificacion().equalsIgnoreCase(identificacion)){
                return cliente;
            }
        }
        return null;
    }


    public void registrarServicio(AdquirirServicio servicio) {
       listServiciosAdquiridos.add(servicio);
    }

    public void pagarServicio(String identificacion, double saldo) {
        for (Cliente cliente : listClientes) {
            if (cliente.getIdentificacion().equalsIgnoreCase(identificacion)) {
                cliente.pagarDeuda(saldo);
            }
        }
    }




    public void mostrarClientes() {
        if(listClientes.isEmpty()){
            System.out.println("No existen clientes en el sistema");
        }else{
            for (Cliente cliente : listClientes) {
                System.out.println(cliente);
            }
        }

    }

    public void mostrarEmpleados() {
        if(listEmpleados.isEmpty()){
            System.out.println("No existen empleados en el sistema");
        }else{
            for (Empleado empleado : listEmpleados) {
                System.out.println(empleado);
            }
        }
    }

    public void mostrarServiciosAdquiridos() {
        if(listServiciosAdquiridos.isEmpty()){
            System.out.println("No existen servicios registrados en el sistema");
        }else{
            for(AdquirirServicio servicio: listServiciosAdquiridos){
                System.out.println(servicio);
            }
        }
    }

    public void mostrarServiciosAdquiridosPorElCliente(String identificacion) {
        Cliente cliente=buscarCliente(identificacion);
        if(cliente!=null){
            cliente.mostrarServiciosAdquiridos();
        }else{
            System.out.println("Cliente no encontrado");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public List<Empleado> getListEmpleados() {
        return listEmpleados;
    }

    public void setListEmpleados(List<Empleado> listEmpleados) {
        this.listEmpleados = listEmpleados;
    }

    public List<Cliente> getListClientes() {
        return listClientes;
    }

    public void setListClientes(List<Cliente> listClientes) {
        this.listClientes = listClientes;
    }

    public List<AdquirirServicio> getListServiciosAdquiridos() {
        return listServiciosAdquiridos;
    }

    public void setListServiciosAdquiridos(List<AdquirirServicio> listServiciosAdquiridos) {
        this.listServiciosAdquiridos = listServiciosAdquiridos;
    }

    public static Funeraria getFuneraria() {
        return funeraria;
    }

    public static void setFuneraria(Funeraria funeraria) {
        Funeraria.funeraria = funeraria;
    }

    @Override
    public String toString() {
        return "Funeraria: " + nombre + " | NIT: " + nit +
                " | Clientes: " + listClientes.size() +
                " | Empleados: " + listEmpleados.size() +
                " | Servicios adquiridos: " + listServiciosAdquiridos.size();
    }


}
