import java.util.Scanner;

class Probabilidade_e_estatistica
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        int opcao,quantidadeDeValores,mediaAritimetica,numeroDeAgrupamentos,qtde;
        float intervaloDoAgrupamento,numeroQualquer,atual,maior,menor,aux;
        intervaloDoAgrupamento = 0;
        atual = 0;

        System.out.println("1 - Lista que simula Histograma");
        System.out.println("2 - Calcular media");
        System.out.println("3 - Calcular desvio padrão");
        System.out.println("");
        System.out.println("Quantos valores você possui?");
        quantidadeDeValores = leitor.nextInt();
        System.out.println("Quantas classes serão necessarias?");
        numeroDeAgrupamentos = leitor.nextInt();

        System.out.println("Insira o maior valor: ");
        maior = leitor.nextFloat();
        System.out.println("Insira o menor valor: ");
        menor = leitor.nextFloat();
        intervaloDoAgrupamento = (maior - menor)/numeroDeAgrupamentos;
        System.out.print("Intervalo: "+intervaloDoAgrupamento);

        while(atual > 0)
        {

        }

        for(float i = 1; i <= quantidadeDeValores; i = i +1)
        {
            System.out.print("Numero "+i+": ");
            atual = leitor.nextFloat();

            if(atual >= menor & atual < (menor + intervaloDoAgrupamento))
            {
                System.out.println("classe 1: ");
            }
        }
        intervaloDoAgrupamento = (maior - menor)/numeroDeAgrupamentos;
        
    }
}