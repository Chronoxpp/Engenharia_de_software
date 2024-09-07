//Desenvolvido por Lucas Dourado Rodrigues

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
}
