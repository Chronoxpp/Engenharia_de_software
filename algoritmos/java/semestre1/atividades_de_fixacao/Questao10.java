package atividades_de_fixacao;
import java.util.Scanner;

class Questao10
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        float maior,menor,atual;
        int qtde;

        System.out.println("Quantos numeros você deseja comparar?");
        qtde = leitor.nextInt();

        System.out.print("Digite um numero: ");
        atual = leitor.nextFloat();
        maior = atual;
        menor = atual;

        if (qtde > 1)
        {
            for(int i = 2; i <= qtde;i = i +1)
            {
                System.out.print("Digite um numero: ");
                atual = leitor.nextFloat();

                if(atual > maior)
                {
                    maior = atual;
                }
                if(atual < menor)
                {
                    menor = atual;
                }
            }
        }

        System.out.println(" ");
        System.out.print("maior numero: "+maior+" e menor numero: "+menor);

        leitor.close();
    }
}
