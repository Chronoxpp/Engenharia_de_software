import java.util.Scanner;

class Questao10
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        float maior,menor,numeroAtual;
        int numeros;
        maior = 0;
        menor = 0;

        System.out.println("Quantos numeros você deseja comparar?");
        numeros = leitor.nextInt();

        for(int i = 1; i <= numeros;i = i +1)
        {
            System.out.print("Digite um numero: ");
            numeroAtual = leitor.nextFloat();
            if(i == 1)
            {
                maior = numeroAtual;
                menor = numeroAtual;
            }
            else
            {
                if(numeroAtual > maior)
                {
                    maior = numeroAtual;
                }
                if(numeroAtual < menor)
                {
                    menor = numeroAtual;
                }
            }
        }

        System.out.println(" ");
        System.out.print("maior numero: "+maior+" e menor numero: "+menor);

        leitor.close();
    }
}
