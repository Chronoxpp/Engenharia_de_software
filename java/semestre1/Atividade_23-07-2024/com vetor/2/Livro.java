class Livro
{
    private String titulo;
    private boolean estaEmprestado;

    Livro(String titulo)
    {
        this.titulo = titulo;
        estaEmprestado = false;
    }

    public String getTitulo() 
    {
        return titulo;
    }

    public void setTitulo(String titulo) 
    {
        this.titulo = titulo;
    }

    public boolean getEstaEmprestado() 
    {
        return estaEmprestado;
    }

    public void setEstaEmprestado(boolean estaEmprestado) 
    {
        this.estaEmprestado = estaEmprestado;
    }
}