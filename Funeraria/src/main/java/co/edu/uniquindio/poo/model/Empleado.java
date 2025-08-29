package co.edu.uniquindio.poo.model;



public class Empleado extends Persona {
    private String sueldo;
    TipoCargo tipoCargo;


    //-------Builder----------------------



    //-----------------------------------

    @Override
    public String toString() {
        return "Empleado{" +
                "sueldo='" + sueldo + '\'' +
                ", tipoCargo=" + tipoCargo +
                '}';
    }
}
