import java.util.Scanner;

class Nadador
{
    public static void main(String[] argds)
    {
        Scanner Leitor = new Scanner(System.in);
        int codigo;

        System.out.println("Insira a idade do nadador");
        codigo = Leitor.nextInt();

        if(codigo < 5) 
        {
            System.out.println("Invalido");
        }

        if(codigo >= 5 & codigo <= 7) 
        {
            System.out.println("Infantil A");
        }

        if(codigo >= 8 & codigo <= 10) 
        {
            System.out.println("Infantil B");
        }

        if(codigo >= 11 & codigo <= 13) 
        {
            System.out.println("Juvenil A");
        }

        if(codigo >= 14 & codigo <= 17) 
        {
            System.out.println("Juvenil B");
        }

        if(codigo > 18)
        {
            System.out.println("Adulto");
        }

        Leitor.close();
    }
}