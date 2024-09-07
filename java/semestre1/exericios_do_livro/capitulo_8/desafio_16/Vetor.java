//Desenvolvido por Lucas Dourado Rodrigues

public class Vetor {
    public double somarValoresDoVetor(double[] vetor)
    {
        if(vetor == null)
        {
            return 0;
        }

        double somatoria = 0;
        for(double valor : vetor)
        {
            somatoria += valor;
        }

        return somatoria;
    }
}
