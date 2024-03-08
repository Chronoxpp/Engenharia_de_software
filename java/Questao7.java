import java.util.Scanner;

class Questao7
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        int n1;
        double h = 0;

        System.out.print("Tamanho da sequencia: ");
        n1 = leitor.nextInt();

        for(double i = 1.0; i <= n1; i = i +1.0)
        {
            h = h + (1/i);
        }

        System.out.print("O resultado é aproximadamente: "+h);

        leitor.close();
    }
}
