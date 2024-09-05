import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Aplicacao 
{
    public static void main(String[] args)
    {
        List<Membro> membros = new ArrayList<>();

        JOptionPane.showMessageDialog(null, "Biblioteca, membros e livros");

        Biblioteca biblioteca = new Biblioteca("Escolhas");

        Membro membro1 = new Membro(JOptionPane.showInputDialog("Insira de um membro qualquer: "));
        membros.add(membro1);
        Membro membro2 = new Membro(JOptionPane.showInputDialog("Insira o nome de outro membro qualquer: "));
        membros.add(membro2);

        JOptionPane.showMessageDialog(null, "Agora vamos cadastrar 3 livros");
        Livro livro1 = new Livro(JOptionPane.showInputDialog("Insira o nome do livro 1: "));
        Livro livro2 = new Livro(JOptionPane.showInputDialog("Insira o nome do livro 2: "));
        Livro livro3 = new Livro(JOptionPane.showInputDialog("Insira o nome do livro 3: "));

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(livro3);

        
        membro1.emprestarLivro(biblioteca.getLivros().get(biblioteca.getLivros().indexOf(livro1)));
        membro1.emprestarLivro(biblioteca.getLivros().get(biblioteca.getLivros().indexOf(livro2)));

        membro2.emprestarLivro(biblioteca.getLivros().get(biblioteca.getLivros().indexOf(livro1)));
        membro2.emprestarLivro(biblioteca.getLivros().get(biblioteca.getLivros().indexOf(livro3)));

        String msg;
        msg = "Lista de livros da biblioteca: \n";
        for(Livro livro : biblioteca.getLivros())
        {
            msg = msg + livro.getNome() + "\n";
        }
        JOptionPane.showMessageDialog(null, msg);

        
        for(Membro membro : membros)
        {
            msg = "Livros pegos por " + membro.getNome() + ":\n";
            for(Livro livro : membro.getLivros())
            {
                msg = msg + livro.getNome() + "\n";
            }
            JOptionPane.showMessageDialog(null, msg);
        }


        membro1.devolverLivro(livro1);
        biblioteca.removerLivro(livro1);

        msg = "Lista de livros da biblioteca: \n";
        for(Livro livro : biblioteca.getLivros())
        {
            msg = msg + livro.getNome() + "\n";
        }
        JOptionPane.showMessageDialog(null, msg);
    }
}
