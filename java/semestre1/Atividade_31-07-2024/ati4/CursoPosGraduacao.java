import java.util.List;
import javax.swing.JOptionPane;

public class CursoPosGraduacao extends Curso
{
    CursoPosGraduacao(String nome)
    {
        super(nome);
    }

    @Override
    public void matricularEstudante(Estudante estudante) 
    {
        getEstudantes().add(estudante);
    }

    @Override
    public void mostrarDetalhes()
    {
        String msg;

        msg = "Curso: " + getNome() + "\n\n";

        msg = msg + "Lista de alunos: \n";
        for(Estudante estudante : getEstudantes())
        {
            msg = msg + estudante.getNome() + "\n";
        }

        JOptionPane.showMessageDialog(null, msg);
    }
}