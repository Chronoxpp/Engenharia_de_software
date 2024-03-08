import java.util.Scanner;

class Questao5
{
    public static void main(String[] argds)
    {
        Scanner leitor = new Scanner(System.in);
        int v1,v2,resultado;
        boolean encerrar = false;
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
        System.out.println("sair = encerrar o programa");
        System.out.println(" ");

        while(encerrar == false)
        {
            System.out.print("Insira o primeiro numero: ");
            v1 = leitor.nextInt();

            System.out.print("Insira a operação: ");
            operador = leitor.next();
            if(operador.equalsIgnoreCase("sair"))
            {
                encerrar = true;
            }
            else
            {
                System.out.print("Insira o segundo numero: ");
                v2 = leitor.nextInt();


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

                v1 = 0;
                v2 = 0;
                resultado = 0;
                operador = "";
                System.out.println(" ");
            }
        }

        leitor.close();
    }
}
