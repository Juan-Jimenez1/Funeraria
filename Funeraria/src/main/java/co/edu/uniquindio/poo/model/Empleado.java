package co.edu.uniquindio.poo.model;


import java.time.LocalDate;

public class Empleado extends Persona {
    private TipoCargo cargo;
    private double salario;

    private Empleado(Builder builder) {
        super(builder.nombre,builder.apellido, builder.identificacion, builder.email, builder.fechaNacimiento);
        this.cargo = builder.cargo;
        this.salario = builder.salario;
    }

    public TipoCargo getCargo() { return cargo; }

    public void setCargo(TipoCargo cargo) {
        this.cargo = cargo;
    }

    public double getSalario() { return salario; }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    //Builder method
    public static class Builder {
        private String nombre;
        private String apellido;
        private String identificacion;
        private String email;
        private LocalDate fechaNacimiento;;
        private TipoCargo cargo;
        private double salario;

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }
        public Builder apellido(String apellido) {
            this.apellido = apellido;
            return this;
        }
        public Builder identificacion(String identificacion) {
            this.identificacion = identificacion;
            return this;
        }
        public Builder email(String email) {
            this.email = email;
            return this;
        }
        public Builder cargo(TipoCargo cargo) {
            this.cargo = cargo;
            return this;
        }
        public Builder salario(double salario) {
            this.salario = salario;
            return this;
        }

        public Builder fechaNacimiento(LocalDate fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
            return this;
        }

        public Empleado build() {
            return new Empleado(this);
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Cargo: " + cargo +
                ", Salario: " + salario;
    }
}