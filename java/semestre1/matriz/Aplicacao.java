import java.util.Scanner;

public class Aplicacao
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);

        //Cria a matriz
        System.out.print("Defina a quantidade de linhas da matriz: ");
        int qtdeDeLinhas = leitor.nextInt();

        System.out.print("Difina a quantidade de colunas da matriz: ");
        int qtdeDeColunas = leitor.nextInt();
        
        Matriz minhaMatriz = new Matriz(qtdeDeLinhas,qtdeDeColunas);

        
        System.out.println("Deseja visualizar a matriz ?");
        System.out.println("escreva: sim OU nao");
        if(leitor.next().equalsIgnoreCase("sim"))
        {
            minhaMatriz.exibirMatriz();

            System.out.println("Diagonal principal: " + minhaMatriz.somarDiagonalPrincipal());
            System.out.println("Diagonal secundaria: " + minhaMatriz.somarDiagonalSecundaria());
            System.out.println("A soma das diagonais é:" + (minhaMatriz.somarDiagonalPrincipal() + minhaMatriz.somarDiagonalSecundaria()));
            System.out.println();
        }
        

        System.out.println("Deseja ordenar a matriz de forma crescente ?");
        System.out.println("escreva: sim OU nao");
        if(leitor.next().equalsIgnoreCase("sim"))
        {
            minhaMatriz.ordenarCrescente();
            minhaMatriz.exibirMatriz();
            System.out.println();
        }


        leitor.close();
    }
} 