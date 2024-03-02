import java.util.Scanner;

class Vendas
{
    public static void main(String[] argds)
    {
        Scanner Leitor = new Scanner(System.in);
        int codigo;
        float vliquido,vbruto;

        vbruto = 100;

        System.out.println("Insira o codigo da forma de pagamento");
        codigo = Leitor.nextInt();

        if(codigo < 1 | codigo > 5)
        {
            System.out.println("Invalido");
        }

        if(codigo == 1) 
        {
            vliquido = vbruto - ((vbruto/100)*10);
            System.out.println("Valor final: "+vliquido);
        }

        if(codigo == 2) 
        {
            vliquido = vbruto - ((vbruto/100)*5);
            System.out.println("Valor final: "+vliquido);
        }

        if(codigo == 3) 
        {
            vliquido = vbruto;
            System.out.println("Valor final: "+vliquido);
        }

        if(codigo == 4) 
        {
            vliquido = vbruto + ((vbruto/100)*10);
            System.out.println("Valor final: "+vliquido);
        }

        Leitor.close();
    }
}
