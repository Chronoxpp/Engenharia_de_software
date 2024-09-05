public abstract class ItemBiblioteca
{
    private String titulo;
    private boolean emprestado;

    public abstract void emprestar();
    public abstract String mostrarDetalhes();

    public String getTitulo()
    {
        return titulo;
    }

    public void setTitulo (String titulo)
    {
        this.titulo = titulo;
    }

    public boolean getEmprestado()
    {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado)
    {
        this.emprestado = emprestado;
    }
}