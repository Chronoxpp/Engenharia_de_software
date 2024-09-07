//Desenvolvido por Lucas Dourado Rodrigues

import java.util.List;

public class MDC {
    public int calcularMDC(int numero1, int numero2)
    {
        if(numero1 <= 0 || numero2 <= 0)
        {
            return 0;
        }

        int i = 2;
        int resultadoMDC = 1;
        while(numero1 != 1 || numero2 != 1)
        {
            while((numero1 % i == 0 || numero2 % i == 0))
            {
                if(numero1 % i == 0 && numero2 % i == 0)
                {
                    resultadoMDC *= i;
                }

                if (numero1 % i == 0)
                {
                    numero1 = numero1 / i;
                }
                if (numero2 % i == 0)
                {
                    numero2 = numero2 / i;
                }
            }
            i += 1;
        }

        return resultadoMDC;
    }


    public int calcularMDC(List<Integer> numeros)
    {
        if(numeros.isEmpty())
        {
            return -1;
        }

        if(verificarSeHaNumeroZeroNaLista(numeros))
        {
            return -1;
        }

        int[] numerosVetor = converterListaInteiraParaVetorInteiro(numeros);

        int divisor = 2;
        int resultadoMDC = 1;
        while(verificarSeHaNumeroDiferenteDe1(numerosVetor))
        {
            if(determinarSeTodosSaoDivisiveis(numerosVetor, divisor))
            {
                resultadoMDC *= divisor;
            }

            //Realiza a divisao dos numeros divisiveis pelo divisor
            for(int i = 0; i < numerosVetor.length; i += 1)
            {
                if(numerosVetor[i] % divisor == 0)
                {
                    numerosVetor[i] = numerosVetor[i] / divisor;
                }
            }

            boolean todosOsNumerosSaoIndiviseisPeloDivisor = true;
            for(int i = 0; i < numerosVetor.length; i += 1)
            {
                if(numerosVetor[i] % divisor == 0)
                {
                    todosOsNumerosSaoIndiviseisPeloDivisor = false;
                }
            }

            if(determinarSeTodosSaoIndivisiveis(numerosVetor, divisor))
            {
                divisor += 1;
            }
        }

        return resultadoMDC;
    }

    public boolean verificarSeHaNumeroZeroNaLista(List<Integer> lista)
    {
        for(Integer numero : lista)
        {
            if(numero <= 0)
            {
                return true;
            }
        }

        return false;
    }

    private int[] converterListaInteiraParaVetorInteiro(List<Integer> listaNumerosInteiros)
    {
        if(listaNumerosInteiros.isEmpty())
        {
            return null;
        }

        int[] vetor = new int[listaNumerosInteiros.size()];
        for(int i = 0; i < vetor.length; i += 1)
        {
            vetor[i] = listaNumerosInteiros.get(i);
        }

        return vetor;
    }

    private boolean verificarSeHaNumeroDiferenteDe1(int[] vetor)
    {
        if(validarVetorInteiro(vetor) == false)
        {
            return false;
        }

        for(int i = 0; i < vetor.length; i += 1)
        {
            if(vetor[i] != 1)
            {
                return true;
            }
        }

        return false;
    }

    private boolean determinarSeTodosSaoDivisiveis(int[] numeros, int divisor)
    {
        if (validarVetorInteiro(numeros) == false)
        {
            return false;
        }

        for(int i = 0; i < numeros.length; i += 1)
        {
            if(numeros[i] % divisor != 0)
            {
                return false;
            }
        }

        return true;
    }

    private boolean determinarSeTodosSaoIndivisiveis(int[] numeros, int divisor)
    {
        if (validarVetorInteiro(numeros) == false)
        {
            return false;
        }

        for(int i = 0; i < numeros.length; i += 1)
        {
            if(numeros[i] % divisor == 0)
            {
                return false;
            }
        }

        return true;
    }

    private boolean validarVetorInteiro(int[] vetor)
    {
        if(vetor == null)
        {
            return false;
        }

        return true;
    }
}
