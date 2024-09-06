//Desenvolvido por Lucas Dourado Rodrigues

public class Sistema {

    public int[] determinarInterseccaoEntreConjuntos(int[] vetor1, int[] vetor2)
    {
        if(vetor1 == null || vetor2 == null)
        {
            return null;
        }


        int[] vetorInterseccao = new int[DeterminarQtdeNumerosNaIntersecacao(vetor1,vetor2)];
        int contador = 0;

        if(vetorInterseccao.length <= 0)
        {
            return null;
        }


        for(int i = 0; i < vetor1.length; i += 1)
        {
            int OcorrenciasDoNumero = 0;
            for(int j = 0; j < vetor2.length; j += 1)
            {
                if(vetor1[i] == vetor2[j])
                {
                    if(verificarSeNumeroExisteNoConjunto(vetorInterseccao, vetor1[i]) == false)
                    {
                        vetorInterseccao[contador] = vetor1[i];
                        contador += 1;
                    }
                }
            }
        }

        return vetorInterseccao;
    }

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


    public int DeterminarQtdeNumerosNaIntersecacao(int[] vetor1, int[] vetor2)
    {
        int qtdeDeNumerosNaInterseccao = 0;
        int[] vetorNumerosEncontrados = new int[vetor1.length];
        int contador = 0;

        for(int i = 0; i < vetor1.length; i += 1)
        {
            int OcorrenciasDoNumero = 0;
            for(int j = 0; j < vetor2.length; j += 1)
            {
                if(vetor1[i] == vetor2[j])
                {
                    OcorrenciasDoNumero += 1;
                    System.out.println("Comparou: " + vetor1[i] + " com " + vetor2[j]);
                }
            }

            if(OcorrenciasDoNumero > 0)
            {
                if(verificarSeNumeroExisteNoConjunto(vetorNumerosEncontrados, vetor1[i]) == false)
                {
                    vetorNumerosEncontrados[contador] = vetor1[i];
                    contador += 1;
                    qtdeDeNumerosNaInterseccao += 1;
                }

            }
        }

        return qtdeDeNumerosNaInterseccao;
    }

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
