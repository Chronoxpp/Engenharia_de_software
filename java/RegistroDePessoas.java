import java.util.Scanner;

class RegistroDePessoas
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        int opcaoEscolhida;
        System.out.println("1 - Registrar alguem");
        System.out.println("2 - Excluir alguem");
        System.out.println("3 - Listar pessoas registradas");
        System.out.println("4 - Personalizar indice");
        System.out.println("5 - Sair");
        System.out.print("Opção escolhida: ");
        opcaoEscolhida = leitor.nextInt();

        leitor.close();
    }
}
