package co.edu.uniquindio.poo.model;



public class Empleado extends Persona {
    private String sueldo;
    TipoCargo tipoCargo;


    //-------Builder----------------------



    //-----------------------------------


    public String getSueldo() {
        return sueldo;
    }

    public TipoCargo getTipoCargo() {
        return tipoCargo;
    }
    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }
    public void setTipoCargo(TipoCargo tipoCargo) {
        this.tipoCargo = tipoCargo;
    }

    @Override
    public String toString() {
        return super.toString() +
                "sueldo='" + sueldo + '\'' +
                ", tipoCargo=" + tipoCargo +
                '}';
    }
}
