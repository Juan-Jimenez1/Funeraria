package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Persona {
    private String nombre;
    private String apellido;
    private String identificacion;
    private String email;
    private LocalDate fechaNacimiento;

     //Protected para poder acceder al constructor desde las clases hijas.
    protected Persona(String nombre, String apellido, String identificacion, String email, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                ", Apellido: " + apellido +
                ", Identificación: " + identificacion +
                ", Email: " + email +
                ", Fecha de nacimiento: " + fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
