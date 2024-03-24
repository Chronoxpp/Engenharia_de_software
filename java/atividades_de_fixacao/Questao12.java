package atividades_de_fixacao;
import java.util.Scanner;

class Questao12
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        int n1,n2,result,divisor,divisOcorridas;
        boolean parar = false;

        System.out.print("Digite o primeiro numero: ");
        n1 = leitor.nextInt();
        System.out.print("Digite o segundo numero: ");
        n2 = leitor.nextInt();

        divisOcorridas = 0;
        divisor = 2;
        result = 1;
        while(parar == false)
        {
            if(n1%divisor == 0)
            {
                divisOcorridas = divisOcorridas + 1;
                n1 = n1/divisor;
            }

            if(n2%divisor == 0)
            {
                divisOcorridas = divisOcorridas + 1;
                n2 = n2/divisor;
            }

            if(divisOcorridas > 0)
            {
                result = result * divisor;
            }
            else
            {
                divisor = divisor + 1;
                if(n1 == 1 && n2 == 1)
                {
                    parar = true;
                }
            }
            divisOcorridas = 0;
        }
        System.out.println("MMC = "+result);

        divisOcorridas = 0;
        divisor = 2;
        result = 1;
        parar = false;
        while(parar == false)
        {
            if(n1%divisor == 0)
            {
                divisOcorridas = divisOcorridas + 1;
                n1 = n1/divisor;
            }

            if(n2%divisor == 0)
            {
                divisOcorridas = divisOcorridas + 1;
                n2 = n2/divisor;
            }

            if(divisOcorridas == 2)
            {
                result = result * divisor;
            }
            else
            {
                if((n1%divisor) != 0 && (n2%divisor) != 0)
                {
                  divisor = divisor + 1;  
                }
                if(n1 == 1 && n2 == 1)
                {
                    parar = true;
                }
            }
            divisOcorridas = 0;
        }
        System.out.println("MDC = "+result);

        leitor.close();
    }
}