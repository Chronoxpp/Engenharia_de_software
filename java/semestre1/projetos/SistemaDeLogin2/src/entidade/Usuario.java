package entidade;

public class Usuario {
    private int ID;
    private String nome;
    private String senha;

    public Usuario(int ID, String senha, String nome)
    {
        this.ID = ID;
        this.senha = senha;
        this.nome = nome;
    }

    public Usuario(String senha, String nome)
    {
        this.senha = senha;
        this.nome = nome;
    }

    public Usuario(int ID, String nome)
    {
        this.ID = ID;
        this.nome = nome;
    }

    public Usuario() {}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
