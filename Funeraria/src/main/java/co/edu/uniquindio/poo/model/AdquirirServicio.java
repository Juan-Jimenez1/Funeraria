package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class AdquirirServicio {
    private Cliente cliente;
    private  Servicio servicio;
    private LocalDate fechaAdquisicion;


    public AdquirirServicio(Cliente cliente, Servicio servicio) {
        assert cliente != null : "Cliente no puede ser null";
        assert servicio != null:  "Servicio no puede ser null";

        this.cliente = cliente;
        this.servicio = servicio;
        this.fechaAdquisicion = LocalDate.now();

        cliente.setValorPendiente(cliente.getValorPendiente() + servicio.getPrecio());
        cliente.setDebeDinero(true);
        cliente.agregarServiciosAdquiridosPorElUsuario(this);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public void setFechaAdquisicion(LocalDate fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public Servicio getServicio() {
        return servicio;
    }


    @Override
    public String toString() {
        return "Servicio adquirido{" +
                "Nombre cliente=" + cliente.getNombre() +
                ", Identificacion=" + cliente.getIdentificacion() +
                ", servicio=" + servicio.getTipoServicio() +
                ", Valor servicio"+ servicio.getPrecio()+
                ", fechaAdquisicion=" + fechaAdquisicion +
                '}';
    }
}
