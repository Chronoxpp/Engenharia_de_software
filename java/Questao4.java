import java.util.Scanner;

class Questao4
{
    public static void main(String[] argds)
    {
        Scanner leitor = new Scanner(System.in);
        int codigo;
        float vliquido,vbruto;

        System.out.print("Valor do produto: ");
        vbruto = leitor.nextFloat();

        System.out.print("Codigo da forma de pagamento: ");
        codigo = leitor.nextInt();

        if(codigo < 1 | codigo >= 5)
        {
            System.out.println("Invalido");
        }
        else
        {
            if(codigo == 1) 
            {
                vliquido = vbruto - ((vbruto/100)*10);
                System.out.println("Valor final: "+vliquido);
            }
            else
            {
                if(codigo == 2) 
                {
                    vliquido = vbruto - ((vbruto/100)*5);
                    System.out.println("Valor final: "+vliquido);
                }
                else
                {
                    if(codigo == 3) 
                    {
                        vliquido = vbruto;
                        System.out.println("Valor final: "+vliquido);
                        System.out.println("Em 2x de "+(vliquido/2));
                    }
                    else 
                    {
                        if(codigo == 4)
                        {
                        vliquido = vbruto + ((vbruto/100)*10);
                        System.out.println("Valor final: "+vliquido);
                        System.out.println("Em 3x de "+(vliquido/3));
                        }
                    }                     
                }
            }
        }
        leitor.close();
    }
}


