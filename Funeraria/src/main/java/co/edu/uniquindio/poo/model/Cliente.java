package co.edu.uniquindio.poo.model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
    private List<AdquirirServicio> serviciosAdquiridos;
    private boolean estaVivo;
    private double valorPendiente;
    private boolean debeDinero;





    private Cliente(Builder builder) {
        super(builder.nombre, builder.apellido, builder.identificacion, builder.email, builder.fechaNacimiento);
        this.estaVivo = true;
        this.valorPendiente = builder.deuda;
        this.serviciosAdquiridos= new ArrayList<>();
        this.debeDinero = false;

    }




    /// Builder method
    public static class Builder{
        private String nombre;
        private String apellido;
        private String identificacion;
        private String email;
        private LocalDate fechaNacimiento;
        private double deuda;


        public Builder nombre(String nombre) {
            this.nombre = nombre; return this;
        }
        public Builder apellido(String apellido) {
            this.apellido = apellido; return this;
        }
        public Builder identificacion(String identificacion) {
            this.identificacion = identificacion;
            return this;
        }
        public Builder email(String email) {
            this.email = email;
            return this;
        }
        public Builder fechaNacimiento(LocalDate fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
            return this;
        }

        public Builder deuda(double deuda) {
            this.deuda=deuda;
            return this;
        }

        public Cliente build() {
            return new Cliente(this);
        }
    }

    public void agregarServiciosAdquiridosPorElUsuario(AdquirirServicio servicio){
        if(!serviciosAdquiridos.contains(servicio)){
            serviciosAdquiridos.add(servicio);
            System.out.println("Servicio Agregado");
        }else{
            System.out.println("Servicio existente");
        }
    }

      //Cuando el usuario adquiere un servicio se le asigna un valor a pagar
      //Este metodo sirve para pagar esa deuda
    public void pagarDeuda(double pago){

        if(valorPendiente==0){
            debeDinero = false;
            System.out.println("El usuario no debe dinero");
            return;
        }

        if(valorPendiente >=pago){
            valorPendiente = valorPendiente - pago;
            System.out.println("El usuario tiene un valor restante a pagar de: "+valorPendiente);
        }else{
            System.out.println("El pago es mayor a la deuda");
        }


    }

    public void mostrarValorPendiente(){
        System.out.println("El usuario tiene un valor pendiente a pagar de:"+valorPendiente);
    }

    public void mostrarServiciosAdquiridos(){
        for(AdquirirServicio servicio:serviciosAdquiridos){
            System.out.println(servicio);
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Vivo: " + estaVivo +
                ", Valor pendiente: " + valorPendiente +
                ", Debe dinero:"+ debeDinero;
    }

    public boolean getEstaVivo() {
        return estaVivo;
    }

    public void setEstaVivo(boolean estaVivo) {
        this.estaVivo = estaVivo;
    }
    public double getValorPendiente() {
        return valorPendiente;
    }
    public void setValorPendiente(double valorPendiente) {
        this.valorPendiente = valorPendiente;
    }

    public List<AdquirirServicio> getServiciosAdquiridos() {
        return serviciosAdquiridos;
    }

    public void setServiciosAdquiridos(List<AdquirirServicio> serviciosAdquiridos) {
        this.serviciosAdquiridos = serviciosAdquiridos;
    }

    public boolean isEstaVivo() {
        return estaVivo;
    }

    public boolean isDebeDinero() {
        return debeDinero;
    }

    public void setDebeDinero(boolean debeDinero) {
        this.debeDinero = debeDinero;
    }


}
