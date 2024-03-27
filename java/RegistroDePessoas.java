import java.util.Scanner;

class RegistroDePessoas
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        String[] nomesDasPessoas = new String[10];
        int[] idadeDasPessoas = new int[10];
        double[] alturaDasPessoas = new double[10];

        boolean continuar = true;
        while(continuar == true)
        {
            System.out.println("1 - Registrar alguem");
            System.out.println("2 - Excluir alguem");
            System.out.println("3 - Listar pessoas registradas");
            System.out.println("4 - Personalizar indice");
            System.out.println("5 - Sair");
            System.out.print("Opção escolhida: ");
            int opcaoEscolhida = leitor.nextInt();

            switch(opcaoEscolhida)
            {
                case 1:
                    int posicaoSemValor = checarEspacoDisponivelString(nomesDasPessoas);
                    if(posicaoSemValor != -1)
                    {
                        nomesDasPessoas[posicaoSemValor] = registrarNome(nomesDasPessoas, posicaoSemValor);
                        idadeDasPessoas[posicaoSemValor] = registrarIdade(idadeDasPessoas, posicaoSemValor);
                        alturaDasPessoas[posicaoSemValor] = registrarAltura(alturaDasPessoas, posicaoSemValor);
                    }
                    else
                    {
                        System.out.println("Não há espaço disponivel!");
                    }
                    break;
                case 2:
                    break;
                case 3:
                    listarDadosRegistrados(nomesDasPessoas, idadeDasPessoas, alturaDasPessoas);
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Programa encerrado...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção invalida!");
            }
            System.out.println(" ");
        }

        leitor.close(); 
    }

    public static int checarEspacoDisponivelString(String[] vetor)
    {
        for(int i = 0; i <= 9; i = i+1)
        {
            if(vetor[i] == null)
            {
                return i;
            }
        }
        return -1;
    }

    public static String registrarNome(String[] vetorNomes,int espacoDisponivel)
    {
        Scanner leitor = new Scanner(System.in);
        String nomeInserido;

        System.out.print("Informe o nome: ");
        nomeInserido = leitor.nextLine();
        return nomeInserido;
    }

    public static int registrarIdade(int[] vetorIdades,int espacoDisponivel)
    {
        Scanner leitor = new Scanner(System.in);
        int idadeInserida;

        System.out.print("Informe a idade: ");
        idadeInserida = leitor.nextInt();
        return idadeInserida;
    }

    public static double registrarAltura(double[] vetorAlturas,int espacoDisponivel)
    {
        Scanner leitor = new Scanner(System.in);
        double alturaInserida;

        System.out.print("Informe a altura: ");
        alturaInserida = leitor.nextDouble();
        return alturaInserida;
    }

    public static void listarDadosRegistrados(String[] vetorNomes,int[] vetorIdades,double[] vetorAlturas)
    {
        for (int i = 0; i <= 9; i = i + 1)
        {
            if (vetorNomes[i] != null)
            {
                if(!vetorNomes[i].equals(""))
                {
                    System.out.println("Registro["+i+"]");
                    System.out.print("nome:"+vetorNomes[i]+"  ");
                    System.out.print("idade:"+vetorIdades[i]+"  ");
                    System.out.print("altura:"+vetorAlturas[i]);
                    System.out.println(" ");
                    System.out.println(" ");
                }
            }
        }
    }

}
