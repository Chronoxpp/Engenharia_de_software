import java.util.Scanner;

class Questao2
{
    public static void main(String[] argds)
    {
        Scanner Leitor = new Scanner(System.in);
        int codigo;

        System.out.println("Insira o codigo do produto:");
        codigo = Leitor.nextInt();

        if(codigo == 1)
        {
            System.out.println("Alimento não-perecivel");
        }

        if(codigo >= 2 & codigo <= 4) 
        {
            System.out.println("Alimento perecivel");
        }

        if(codigo == 5 | codigo == 6)
        {
            System.out.println("Vestuario");
        }

        if(codigo == 7)
        {
            System.out.println("Higiene pessoal");
        }

        if(codigo >= 8 & codigo <= 15)
        {
            System.out.println("Limpeza e utensilios domesticos");
        }

        if(codigo > 15)
        {
            System.out.println("Inválido");
        }

        Leitor.close();
    }
}