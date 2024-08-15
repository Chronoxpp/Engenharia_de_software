public class Parcela 
{
    int ID;
    double valor;

    Parcela(int ID, double valor)
    {
        this.ID = ID;
        this.valor = valor;
    }

    public int getID() 
    {
        return ID;
    }
    public void setID(int iD) 
    {
        ID = iD;
    }
    public double getValor() 
    {
        return valor;
    }
    public void setValor(double valor) 
    {
        this.valor = valor;
    }
}
