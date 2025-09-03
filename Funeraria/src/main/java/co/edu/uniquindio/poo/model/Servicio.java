package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Servicio {
    private TipoServicio tipoServicio;
    private double precio;

    private Servicio(TipoServicio tipoServicio, double precio) {
        this.tipoServicio = tipoServicio;
        this.precio = precio;
    }

    // ---------- FACTORY ----------
    public static class ServicioFactory {
        public static Servicio crearServicio(int opcion) {
            switch (opcion) {
                case 1:
                    return new Servicio(TipoServicio.ENTIERRO, 12000000);
                case 2:
                    return new Servicio(TipoServicio.CREMACION, 7000000);
                case 3:
                    return new Servicio(TipoServicio.EXHUMACION, 4000000);
                default:
                    throw new IllegalArgumentException("Opción inválida");
            }
        }
    }

    public double getPrecio() {
        return precio;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "tipoServicio=" + tipoServicio +
                ", precio=" + precio +
                '}';
    }
}

