import javax.swing.JOptionPane;

public class Candidato extends Pessoa
{
    private int votos;

    Candidato(String nome)
    {
        super(nome);
    }

    public void receberVoto(int voto)
    {
        votos = votos + voto;
    }

    @Override
    public void mostrarDetalhes()
    {
        JOptionPane.showMessageDialog(null, "Candidato: " + getNome() + " possui " + getVotos() + " votos");
    }

    public int getVotos() 
    {
        return votos;
    }

    public void setVotos(int votos) 
    {
        this.votos = votos;
    }
}
