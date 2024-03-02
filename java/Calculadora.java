import java.util.Scanner;

class Calculadora
{
    public static void main(String[] argds)
    {
        Scanner Leitor = new Scanner(System.in);
        int v1,v2,resultado;
        //float resultado;
        String operador;

        System.out.println("Insira o primeiro numero");
        v1 = Leitor.nextInt();
        System.out.println("Insira a operação");
        operador = Leitor.next();
        System.out.println("Insira o segundo numero");
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
            resultado = v1 / v2;
            System.out.println("Resultado: "+resultado);
        }

        if(operador.equalsIgnoreCase("r"))
        {
            //resultado = v1 + v2;
            System.out.println("Resultado: em desenvolvimento!");
        }

        if(operador.equals("**"))
        {
            //resultado = v1 * v2;
            System.out.println("Resultado: em desenvolvimento!");
        }

        Leitor.close();
    }
}
