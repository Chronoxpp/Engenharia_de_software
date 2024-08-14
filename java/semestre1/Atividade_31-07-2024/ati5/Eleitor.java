import javax.swing.JOptionPane;

public class Eleitor extends Pessoa
{
    Eleitor(String nome)
    {
        super(nome);
    }

    @Override
    public void mostrarDetalhes() 
    {
        JOptionPane.showMessageDialog(null, "Eleitor " + getNome());
    }

    public void votar(Candidato candidato)
    {
        if (candidato == null) 
        {
            return;    
        }
        
        candidato.receberVoto(1);
    }
}
