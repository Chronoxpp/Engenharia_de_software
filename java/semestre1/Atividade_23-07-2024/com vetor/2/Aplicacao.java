import java.util.Scanner;

public class Aplicacao
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        Biblioteca minhaBiblioteca = new Biblioteca("sagrada", 5);

        Livro livro1 = new Livro("meu");
        Livro livro2 = new Livro("primeiro");
        Livro livro3 = new Livro("livro");
        Livro livro4 = new Livro("Adicional");

        minhaBiblioteca.adicionarLivro(livro1);
        minhaBiblioteca.adicionarLivro(livro2);
        minhaBiblioteca.adicionarLivro(livro3);
        minhaBiblioteca.adicionarLivro(livro4);

        Membro pessoa1 = new Membro("Jão", 3);
        pessoa1.emprestarLivro(livro1);
        pessoa1.emprestarLivro(livro2);

        minhaBiblioteca.deletarLivro(livro2);

        Membro pessoa2 = new Membro("Maria", 3);
        pessoa2.emprestarLivro(livro2);

        
        System.out.println("Livros do Jão: ");
        for (Livro livro : pessoa1.getLivrosEmprestados()) 
        {
            if (livro != null)
            {
                System.out.println(livro.getTitulo());
            }
            
        }

        pessoa1.devolverLivro(livro1);

        System.out.println();
        System.out.println("Livros do Jão apos devolver o livro 'meu': ");
        for (Livro livro : pessoa1.getLivrosEmprestados()) 
        {
            if (livro != null)
            {
                System.out.println(livro.getTitulo());
            }
        }

        leitor.close();
    }
}