package co.edu.uniquindio.poo.model;



public class Cliente extends Persona {

    private boolean estaVivo;
    private double deuda;





    /// Builder method


    /// --------------------

    public boolean getEstaVivo() {
        return estaVivo;
    }

    public void setEstaVivo(boolean estaVivo) {
        this.estaVivo = estaVivo;
    }
    public double getDeuda() {
        return deuda;
    }
    public void setDeuda(double deuda) {
        this.deuda = deuda;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
