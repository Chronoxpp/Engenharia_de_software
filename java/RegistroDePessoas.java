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
            
            System.out.println(" ");
            switch(opcaoEscolhida)
            {   
                
                case 1:
                    int posicaoSemValor = checarEspacoDisponivelString(nomesDasPessoas);
                    if(posicaoSemValor != -1)
                    {
                        registrarPessoa(nomesDasPessoas, idadeDasPessoas, alturaDasPessoas, posicaoSemValor, leitor);
                        organizarVetorDeNomes(nomesDasPessoas, idadeDasPessoas, alturaDasPessoas);
                        
                    }
                    else
                    {
                        System.out.println("Não há espaço disponivel!");
                    }
                    break;

                case 2:
                    System.out.print("Registro que será excluido: ");
                    int registroEscolhido = leitor.nextInt();

                    if(nomesDasPessoas[registroEscolhido] != null)
                    {
                        excluirRegistroDoVetor(nomesDasPessoas, idadeDasPessoas, alturaDasPessoas, registroEscolhido);
                        System.out.println("Registro excluido");
                        organizarVetorDeNomes(nomesDasPessoas, idadeDasPessoas, alturaDasPessoas);
                    }
                    else
                    {
                        System.out.println(" ");
                        System.out.println("Esse registro ainda não existe!");
                    }

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

    public static void registrarPessoa(String[] nomesDasPessoas,int []idadeDasPessoas,double[] alturaDasPessoas,int espacoDisponivel,Scanner leitor)
    {
        String nomeInserido;
        int idadeInserida;
        double alturaInserida;

        do
        {
            System.out.print("Insira o nome: ");
            nomeInserido = leitor.next();
        }while(nomeInserido.equals(""));
        nomesDasPessoas[espacoDisponivel] = nomeInserido;

        do
        {
            System.out.print("Insira a idade: ");
            idadeInserida = leitor.nextInt();
        }while(idadeInserida == 0);
        idadeDasPessoas[espacoDisponivel] = idadeInserida;

        do
        {
            System.out.print("Insira a altura: ");
            alturaInserida = leitor.nextDouble();
        }while(alturaInserida == 0);
        alturaDasPessoas[espacoDisponivel] = alturaInserida;
    }

    public static void organizarVetorDeNomes(String[] nomesDasPessoas,int[] idadeDasPessoas,double[] alturaDasPessoas)
    {
        for (int i = 0; i <= 8; i = i + 1){
            for (int j = 0; j < 9 - i; j = j + 1) {
                if (nomesDasPessoas[j] == null & nomesDasPessoas[j+1] != null)
                {
                    String auxiliarNome = nomesDasPessoas[j];
                    nomesDasPessoas[j] = nomesDasPessoas[j+1];
                    nomesDasPessoas[j+1] = auxiliarNome;

                    int auxiliarIdade = idadeDasPessoas[j];
                    idadeDasPessoas[j] = idadeDasPessoas[j+1];
                    idadeDasPessoas[j+1] = auxiliarIdade;

                    double auxiliarAltura = alturaDasPessoas[j];
                    alturaDasPessoas[j] = alturaDasPessoas[j+1];
                    alturaDasPessoas[j+1] = auxiliarAltura;
                }
            }
        }
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

    public static void excluirRegistroDoVetor(String[] vetorNomes,int[] vetorIdades,double[] vetorAlturas,int registroEscolhido)
    {
        vetorNomes[registroEscolhido] = null;
        vetorIdades[registroEscolhido] = 0;
        vetorAlturas[registroEscolhido] = 0.0;
    }
}
