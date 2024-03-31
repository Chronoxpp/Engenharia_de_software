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
            System.out.println("4 - Salvar e personalizar indice");
            System.out.println("5 - Sair");
            System.out.print("Opção escolhida: ");
            int opcaoEscolhida = leitor.nextInt();
            
            System.out.println(" ");
            switch(opcaoEscolhida)
            {   
                case 1:
                    cadastrarNovaPessoa(nomesDasPessoas, idadeDasPessoas, alturaDasPessoas, leitor);
                    organizarOrdemDosRegistros(nomesDasPessoas, idadeDasPessoas, alturaDasPessoas);

                    break;

                case 2:
                    excluirUmaPessoa(nomesDasPessoas, idadeDasPessoas, alturaDasPessoas, leitor);
                    organizarOrdemDosRegistros(nomesDasPessoas, idadeDasPessoas, alturaDasPessoas);

                    break;

                case 3:
                    listarDadosRegistrados(nomesDasPessoas, idadeDasPessoas, alturaDasPessoas);

                    break;

                case 4:
                    cadastrarNovaPessoaComIndicePersonalizado(nomesDasPessoas, idadeDasPessoas, alturaDasPessoas, leitor);
                    organizarOrdemDosRegistros(nomesDasPessoas, idadeDasPessoas, alturaDasPessoas);

                    break;

                case 5:
                    System.out.println("PROGRAMA ENCERRADO...");
                    continuar = false;

                    break;
                    
                default:
                    System.out.println("Opção invalida!");
            }
            System.out.println(" ");
        }

        leitor.close(); 
    }

    public static void cadastrarNovaPessoa(String[] nomesDasPessoas,int[] idadeDasPessoas,double[] alturaDasPessoas,Scanner leitor)
    {
        int posicaoSemValor = checarUmEspacoDisponivelEmTodoVetor(nomesDasPessoas);
        if(posicaoSemValor != -1)
        {
            registrarPessoa(nomesDasPessoas, idadeDasPessoas, alturaDasPessoas, posicaoSemValor, leitor);
        }
        else
        {
            System.out.println("Não há espaço disponivel!");
        }
    }

    public static int checarUmEspacoDisponivelEmTodoVetor(String[] vetor)
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

    public static void registrarPessoa(String[] nomesDasPessoas,int []idadeDasPessoas,double[] alturaDasPessoas,int espacoDisponivel,Scanner leitor)
    {

        System.out.print("Insira o nome: ");
        nomesDasPessoas[espacoDisponivel] = leitor.next();

        System.out.print("Insira a idade: ");
        idadeDasPessoas[espacoDisponivel] = leitor.nextInt();

        System.out.print("Insira a altura: ");
        alturaDasPessoas[espacoDisponivel] = leitor.nextDouble();
    }

    public static void organizarOrdemDosRegistros(String[] nomesDasPessoas,int[] idadeDasPessoas,double[] alturaDasPessoas)
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

    public static void cadastrarNovaPessoaComIndicePersonalizado(String[] nomesDasPessoas,int[] idadeDasPessoas,double[] alturaDasPessoas,Scanner leitor)
    {
        System.out.print("Indice desejado: ");
        int indiceEscolhido = leitor.nextInt();
        if (checarEspacoDisponivelDoIndiceEscolhido(nomesDasPessoas, indiceEscolhido) == indiceEscolhido)
        {
            registrarPessoa(nomesDasPessoas, idadeDasPessoas, alturaDasPessoas, indiceEscolhido, leitor);

        }
        else
        {
            if(checarEspacoDisponivelDoIndiceEscolhido(nomesDasPessoas, indiceEscolhido) != -1)
            {
                empurrarRegistroDePessoas(nomesDasPessoas, idadeDasPessoas, alturaDasPessoas, indiceEscolhido);
                registrarPessoa(nomesDasPessoas, idadeDasPessoas, alturaDasPessoas, indiceEscolhido, leitor);

            }
            else
            {
                System.out.println("Não há espaço disponivel!");
            }
        }
    }

    public static int checarEspacoDisponivelDoIndiceEscolhido(String[] vetor, int indiceDesejado)
    {
        for(int i = indiceDesejado; i <= 9; i = i+1)
        {
            if(vetor[i] == null)
            {
                return i;
            }
        }
        return -1;
    }

    public static void empurrarRegistroDePessoas(String[] nomesDasPessoas,int[] idadeDasPessoas,double[] alturaDasPessoas,int inicioDoEmpurrao)
    {
        for (int j = 9; j >= inicioDoEmpurrao + 1; j = j - 1)
        {
            if (nomesDasPessoas[j] == null & nomesDasPessoas[j-1] != null)
            {
                String auxiliarNome = nomesDasPessoas[j];
                nomesDasPessoas[j] = nomesDasPessoas[j-1];
                nomesDasPessoas[j-1] = auxiliarNome;

                int auxiliarIdade = idadeDasPessoas[j];
                idadeDasPessoas[j] = idadeDasPessoas[j-1];
                idadeDasPessoas[j-1] = auxiliarIdade;

                double auxiliarAltura = alturaDasPessoas[j];
                alturaDasPessoas[j] = alturaDasPessoas[j-1];
                alturaDasPessoas[j-1] = auxiliarAltura;
            }
        }
    }    

    public static void excluirUmaPessoa(String[] nomesDasPessoas,int[] idadeDasPessoas,double[] alturaDasPessoas,Scanner leitor)
    {
        System.out.print("Registro que será excluido: ");
        int registroEscolhido = leitor.nextInt();

        if(nomesDasPessoas[registroEscolhido] != null)
        {
            System.out.println("Você tem certeza que deseja excluir esse registro?");
            System.out.println("S = sim. Ou Pressione qualquer outra tecla para cancelar");
            System.out.print("Opção desejada: ");
            if(leitor.next().equalsIgnoreCase("S"))
            {
                excluirPessoa(nomesDasPessoas, idadeDasPessoas, alturaDasPessoas, registroEscolhido);
                System.out.println("Registro excluido!");
            }
            else
            {
                System.out.println("Exclusão cancelada!");
            }
        }
        else
        {
            System.out.println(" ");
            System.out.println("Esse registro ainda não existe!");
        }
    }

    public static void excluirPessoa(String[] vetorNomes,int[] vetorIdades,double[] vetorAlturas,int registroEscolhido)
    {
        vetorNomes[registroEscolhido] = null;
        vetorIdades[registroEscolhido] = 0;
        vetorAlturas[registroEscolhido] = 0.0;
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