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
        //verifica se ha numero == 0
        for(Integer numero : numeros)
        {
            if(numero <= 0)
            {
                System.out.println("Retornou 0");
                return 0;
            }
        }

        //popula o vetor com os valores da lista
        int[] vetorNumeros = new int[numeros.size()];
        for(int i = 0; i < vetorNumeros.length; i += 1)
        {
            vetorNumeros[i] = numeros.get(i);
        }

        //Verifica se ha numero diferente de 1
        boolean haNumeroDiferenteDe1 = false;
        for(int i = 0; i < vetorNumeros.length; i += 1)
        {
            if(vetorNumeros[i] != 1)
            {
                haNumeroDiferenteDe1 = true;
                break;
            }
        }


        int divisor = 2;
        int resultadoMDC = 1;
        while(haNumeroDiferenteDe1)
        {
            boolean todosOsNumerosSaoDivisiveisPeloDivisor = true;
            for(int i = 0; i < vetorNumeros.length; i += 1)
            {
                if(vetorNumeros[i] % divisor == 0)
                {
                    vetorNumeros[i] = vetorNumeros[i] / divisor;
                }
                else
                {
                    todosOsNumerosSaoDivisiveisPeloDivisor = false;
                }
            }

            if(todosOsNumerosSaoDivisiveisPeloDivisor)
            {
                resultadoMDC *= divisor;
            }

            boolean todosOsNumerosSaoIndiviseisPeloDivisor = true;
            for(int i = 0; i < vetorNumeros.length; i += 1)
            {
                if(vetorNumeros[i] % divisor == 0)
                {
                    todosOsNumerosSaoIndiviseisPeloDivisor = false;
                }
            }

            if(todosOsNumerosSaoIndiviseisPeloDivisor)
            {
                divisor += 1;
            }

            haNumeroDiferenteDe1 = false;
            for(int i = 0; i < vetorNumeros.length; i += 1)
            {
                if(vetorNumeros[i] != 1)
                {
                    haNumeroDiferenteDe1 = true;
                    break;
                }
            }
        }

        return resultadoMDC;
    }
}
