public class Veiculo
{
    private double custoDeFabrica;
    private double porcentagemDistribuidor;
    private double porcentagemImpostos;

    Veiculo(double custoDeFabrica, double porcentagemDistribuidor, double porcentagemImpostos)
    {
        this.custoDeFabrica = custoDeFabrica;
        this.porcentagemDistribuidor = porcentagemDistribuidor;
        this.porcentagemImpostos = porcentagemImpostos;
    }

    public double calcularPrecoConsumidor()
    {
        double valorTotal;

        valorTotal = custoDeFabrica;
        valorTotal = valorTotal + ((custoDeFabrica / 100) * porcentagemDistribuidor);
        valorTotal = valorTotal + ((custoDeFabrica / 100) * porcentagemImpostos);

        return valorTotal;
    }

    public double getCustoDeFabrica() 
    {
        return custoDeFabrica;
    }

    public void setCustoDeFabrica(double custoDeFabrica) 
    {
        this.custoDeFabrica = custoDeFabrica;
    }

    public double getPorcentagemDistribuidor() 
    {
        return porcentagemDistribuidor;
    }

    public void setPorcentagemDistribuidor(double porcentagemDistribuidor) 
    {
        this.porcentagemDistribuidor = porcentagemDistribuidor;
    }

    public double getPorcentagemImpostos() 
    {
        return porcentagemImpostos;
    }

    public void setPorcentagemImpostos(double porcentagemImpostos) 
    {
        this.porcentagemImpostos = porcentagemImpostos;
    }
}