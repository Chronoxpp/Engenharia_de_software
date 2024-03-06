import java.util.Scanner;

class Questao13
{
    public static void main(String[] args)
    {
        Scanner Leitor = new Scanner(System.in);
        int n1,n2,aux,quociente;

        System.out.print("insira um numero: ");
        n1 = Leitor.nextInt();
        System.out.print("divido por ");
        n2 = Leitor.nextInt();

        if(n1 >= n2)
        {
            aux = n2;
            quociente = 1;
            for(int i = 1; aux < n1;i = i + 1)
            {
                aux = n2 * i;
                quociente = i;
            }

            if(n2*quociente == n1)
            {
                System.out.println("Quociente = "+quociente);
            }
            else
            {
                System.out.println("Quociente aproximado = "+(quociente - 1));
            }

        }
        Leitor.close();
    }
}