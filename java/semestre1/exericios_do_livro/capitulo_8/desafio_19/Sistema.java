//Desenvolvido por Lucas Dourado Rodrigues

public class Sistema {
    //
    public int[] determinarInterseccaoEntreConjuntos(int[] vetor1, int[] vetor2)
    {
        if(vetor1 == null || vetor2 == null)
        {
            return null;
        }

        int[] vetorInterseccaoTemporario = new int[vetor1.length];
        int contador = 0;

        if(vetorInterseccaoTemporario.length <= 0)
        {
            return null;
        }

        //Preenche o vetor intersecacao temporario
        for(int vetor1_i = 0; vetor1_i < vetor1.length; vetor1_i += 1)
        {
            for(int vetor2_j = 0; vetor2_j < vetor2.length; vetor2_j += 1)
            {
                if(vetor1[vetor1_i] == vetor2[vetor2_j])
                {
                    if(verificarSeNumeroExisteNoConjunto(vetorInterseccaoTemporario, vetor1[vetor1_i]) == false)
                    {
                        vetorInterseccaoTemporario[contador] = vetor1[vetor1_i];
                        contador += 1;
                    }
                }
            }
        }

        //Preenche o vetor interseccao final
        int[] vetorInterseccao = new int[contador -1];
        for(int i = 0; i < contador - 1; i += 1)
        {
            vetorInterseccao[i] = vetorInterseccaoTemporario[i];
        }

        return vetorInterseccao;
    }

    //
    public boolean verificarSeNumeroExisteNoConjunto(int[] vetor, int numero)
    {
        int ocorrenciasDoNumero = 0;
        for(int i = 0; i < vetor.length; i += 1)
        {
            if(vetor[i] == numero)
            {
                ocorrenciasDoNumero += 1;
            }
        }

        if(ocorrenciasDoNumero > 0)
        {
            return true;
        }

        return false;
    }

    //
    public String converterVetorInteiroEmMsg(int[] vetor)
    {
        if(vetor == null)
        {
            return null;
        }

        String msg = "";
        for (int i = 0; i < vetor.length; i += 1)
        {
            msg += "  " + "[" + vetor[i] + "]";
        }

        return msg;
    }
}
