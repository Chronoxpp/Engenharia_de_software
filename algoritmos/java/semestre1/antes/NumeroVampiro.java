import java.util.Scanner;

class NumeroVampiro
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        int possivelVampiro,numeroDeAlgarismos,aux,combinacao1,combinacao2;
        String strCombinacao1,strCombinacao2;

        possivelVampiro = leitor.nextInt();

        aux = possivelVampiro;
        numeroDeAlgarismos = 0;
        for(numeroDeAlgarismos = 1;aux/10 != 0; numeroDeAlgarismos = numeroDeAlgarismos+1)
        {
            aux = aux/10;
        }

        if(numeroDeAlgarismos%2 != 0)
        {
            System.out.print("Insira um numero com uma quantidade par de digitos!");
        }
        else
        {
            aux = possivelVampiro;
            strCombinacao1 = "";
            strCombinacao2 = "";
            for(int i = 1; i <= numeroDeAlgarismos ; i = i + 1)
            {
                if(i <= (numeroDeAlgarismos/2))
                {
                    strCombinacao1 = strCombinacao1 + Integer.toString(aux%10);
                }
                else
                {
                    strCombinacao2 = strCombinacao2 + Integer.toString(aux%10);
                }
                aux = aux/10;
            }

            combinacao1 = Integer.parseInt(strCombinacao1);
            combinacao2 = Integer.parseInt(strCombinacao2);
            if(combinacao1 * combinacao2 == possivelVampiro)
            {
                System.out.print("É um numero vampiro");
            }
            else
            {
            }
        }

        leitor.close();
    }
} 