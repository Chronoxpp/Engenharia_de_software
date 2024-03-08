import java.util.Scanner;

class Questao5
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        int n1,n2;
        boolean encerrar = false;
        String operador;
        n1 = 0;
        n2 = 0;

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
            n1 = leitor.nextInt();

            System.out.print("Insira a operação: ");
            operador = leitor.next();

            if(operador.equalsIgnoreCase("sair"))
            {
                encerrar = true;
            }
            else
            {
                System.out.print("Insira o segundo numero: ");
                n2 = leitor.nextInt();

                System.out.println("Resultado: "+(operacao(operador, n1, n2)));
                n1 = 0;
                n2 = 0;
                operador = "";
                System.out.println(" ");
            }
        }
        leitor.close();
    }


    public static int operacao(String operador,int n1,int n2)
    {
        if(operador.equals("+"))
        {
            return soma(n1,n2);
        }
        else
        {
            if(operador.equals("-"))
            {
                return subtracao(n1,n2);
            }
            else
            {
                if(operador.equals("*"))
                {
                    return multiplica(n1,n2);
                }
                else
                {
                    if(operador.equals("/"))
                    {
                        return divide(n1,n2);
                    }
                    else
                    {
                        if(operador.equalsIgnoreCase("r"))
                        {
                            System.out.println("Atualmente são realizados apenas calculos de raizes quadradas!!");
                            return raiz(n1,n2);
                        }
                        else
                        {
                            if(operador.equals("**"))
                            {
                                return potencia(n1,n2);
                            }
                            else
                            {
                                return 0;
                            }
                        }
                    }
                }
            }    
        }
    }


    public static int soma(int n1, int n2)
    {
        return (n1 + n2);
    }


    public static int subtracao(int n1, int n2)
    {
        return (n1-n2);
    }


    public static int multiplica(int n1, int n2)
    {
        return (n1*n2);
    }


    public static int divide(int n1, int n2)
    {
        if(n2 != 0)
        {
            return (n1/n2);
        }
        else
        {
            System.out.println("Não é possivel dividir por 0");
            return 0;
        }
    }


    public static int raiz(int n1, int i)
    {
        int resultado = 0;

        if(n1>=0)
        {
            for(i = 1;(i*i) <= n1;i = i +1)
            {
            }
            resultado = (i-1);
        }
        else
        {
            System.out.print("Não é possivel encontrar a raiz de numero negativos");
        }
        return resultado;
    }


    public static int potencia(int n1, int n2)
    {
        int resultado = 0;

        if(n2 == 0)
        {
            resultado = 1;
        }
        else
        {
            resultado = n1;
            for(int i = 2;i<=n2;i = i + 1)
            {
                resultado = resultado * n1;
            }    
        }
        return resultado;
    }


}