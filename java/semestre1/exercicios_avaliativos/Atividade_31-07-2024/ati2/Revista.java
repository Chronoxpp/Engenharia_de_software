public class Revista extends ItemBiblioteca 
{
    String edicao;

    Revista(String titulo, String edicao)
    {
        setTitulo(titulo);
        setEdicao(edicao);
    }

    public void emprestar()
    {
        setEmprestado(true);
    }

    public String mostrarDetalhes()
    {
        String msg = "Revista: "+ getTitulo() + "\n";
        msg = msg + "Edicao: " + getEdicao() + "\n";
        msg = msg + "Esta emprestado: " + getEmprestado() + "\n";

        return msg;
    }

    public String getEdicao()
    {
        return edicao;
    }

    public void setEdicao(String edicao)
    {
        this.edicao = edicao;
    }
}
