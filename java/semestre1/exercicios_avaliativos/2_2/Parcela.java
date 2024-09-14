public class Parcela {
    private double valor;
    private int ID;

    public Parcela(int ID, double valor)
    {
        this.ID = ID;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
