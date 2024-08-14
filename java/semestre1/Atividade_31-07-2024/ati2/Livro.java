public class Livro extends ItemBiblioteca 
{
    private String autor;

    Livro(String titulo, String autor)
    {
        setTitulo(titulo);
        setAutor(autor);
    }

    public void emprestar()
    {
        setEmprestado(true);
    }

    public String mostrarDetalhes()
    {
        String msg = "Livro: "+ getTitulo() + "\n";
        msg = msg + "Autor: " + getAutor() + "\n";
        msg = msg + "Esta emprestado: " + getEmprestado() + "\n";

        return msg;
    }

    public String getAutor() 
    {
        return autor;
    }

    public void setAutor(String autor) 
    {
        this.autor = autor;
    }
}
