import java.util.Scanner;

class Questao10
{
    public static void main(String[] args)
    {
        Scanner Leitor = new Scanner(System.in);
        float maior,menor,atual;
        int numeros,i;
        maior = 0;
        menor = 0;

        System.out.println("Quantos numeros você deseja comparar?");
        numeros = Leitor.nextInt();

        for(i = 1; i <= numeros;i = i +1)
        {
            System.out.print("Digite um numero: ");
            atual = Leitor.nextFloat();
            if(i == 1)
            {
                maior = atual;
                menor = atual;
            }
            else
            {
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

        Leitor.close();
    }
}
