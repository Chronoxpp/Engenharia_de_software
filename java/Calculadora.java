import java.util.Scanner;

class Calculadora
{
    public static void main(String[] argds)
    {
        Scanner Leitor = new Scanner(System.in);
        int v1,v2,resultado;
        //float resultado;
        String operador;
        v1 = 0;
        v2 = 0;

        System.out.println("Operadores:");
        System.out.println("+ = adição");
        System.out.println("- = subtração");
        System.out.println("* = multiplicação");
        System.out.println("/ = divisão");
        System.out.println("r = radiciação");
        System.out.println("** = potenciação");
        System.out.println(" ");

        System.out.print("Insira o primeiro numero: ");
        v1 = Leitor.nextInt();
        System.out.print("Insira a operação: ");
        operador = Leitor.next();
        System.out.print("Insira o segundo numero: ");
        v2 = Leitor.nextInt();


        if(operador.equals("+"))
        {
            resultado = v1 + v2;
            System.out.println("Resultado: "+resultado);
        }

        if(operador.equals("-"))
        {
            resultado = v1 - v2;
            System.out.println("Resultado: "+resultado);
        }

        if(operador.equals("*"))
        {
            resultado = v1 * v2;
            System.out.println("Resultado: "+resultado);
        }

        if(operador.equals("/"))
        {
            if(v2 != 0)
            {
                resultado = v1 / v2;
                System.out.println("Resultado: "+resultado);
            }
            else
            {
                System.out.println("Não é possivel realizar divisões por 0");
            }

        }

        if(operador.equalsIgnoreCase("r"))
        {
            if(v1>=0)
            {
                resultado = v1 + v2;
                System.out.println("Resultado: em desenvolvimento!");
            }
            else
            {
                System.out.print("Não é possivel encontrar a raiz de numero negativos");
            }
        }

        if(operador.equals("**"))
        {
            if(v2 == 0)
            {
                resultado = 1;
            }
            else
            {
                resultado = v1;
                for(int i = 2;i<=v2;i = i + 1)
                {
                   resultado = resultado * v1;
                }    
            }
            
            System.out.println("Resultado: "+resultado);
        }

        Leitor.close();
    }
}
