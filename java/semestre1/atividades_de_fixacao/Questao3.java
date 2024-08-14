package atividades_de_fixacao;
import java.util.Scanner;

class Questao3
{
    public static void main(String[] argds)
    {
        Scanner leitor = new Scanner(System.in);
        int idade;

        System.out.print("Insira a idade do nadador: ");
        idade = leitor.nextInt();

        if(idade < 5) 
        {
            System.out.println("Invalido");
        }

        if(idade >= 5 & idade <= 7) 
        {
            System.out.println("Infantil A");
        }

        if(idade >= 8 & idade <= 10) 
        {
            System.out.println("Infantil B");
        }

        if(idade >= 11 & idade <= 13) 
        {
            System.out.println("Juvenil A");
        }

        if(idade >= 14 & idade <= 17) 
        {
            System.out.println("Juvenil B");
        }

        if(idade > 18)
        {
            System.out.println("Adulto");
        }

        leitor.close();
    }
}
