package entity;

public class Perfil
{
    private int idPerfil;
    private String descricao;
    private String nome;

    public Perfil(int idPerfil, String nome, String descricao) {
        this.idPerfil = idPerfil;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Perfil() {
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
