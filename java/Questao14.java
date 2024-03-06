import java.util.Scanner;

class Questao14
{
    public static void main(String[] args)
    {
        Scanner Leitor = new Scanner(System.in);
        int n1, n2, result;

        System.out.print("Numero: ");
        n1 = Leitor.nextInt();
        System.out.print("Elevado a ");
        n2 = Leitor.nextInt();

        if(n2 == 0)
        {
            result = 1;
        }
        else
        {
            result = n1;
            for(int i = 2;i<=n2;i = i + 1)
            {
            result = result * n1;
            }    
        }
        System.out.println("Resultado: "+result);

        Leitor.close();
    }
}