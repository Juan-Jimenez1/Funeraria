package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class AdquirirServicio {
    private Cliente cliente;
    private  Servicio servicio;
    private LocalDate fecchaAdquisicion;


    public AdquirirServicio(Cliente cliente, Servicio servicio) {
        assert cliente != null : "Cliente no puede ser null";
        assert servicio != null:  "Servicio no puede ser null";

        this.cliente = cliente;
        this.servicio = servicio;
        this.fecchaAdquisicion = LocalDate.now();

        cliente.setValorPendiente(cliente.getValorPendiente() + servicio.getPrecio());
        cliente.agregarServiciosAdquiridosPorElUsuario(this);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFecchaAdquisicion() {
        return fecchaAdquisicion;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public void setFecchaAdquisicion(LocalDate fecchaAdquisicion) {
        this.fecchaAdquisicion = fecchaAdquisicion;
    }

    public Servicio getServicio() {
        return servicio;
    }


    @Override
    public String toString() {
        return "Servicio{" +
                "cliente=" + cliente +
                ", servicio=" + servicio +
                ", fecchaAdquisicion=" + fecchaAdquisicion +
                '}';
    }
}
