package entity;

public class Usuario
{
    private String idUsuario;
    private String nome;
    private String login;
    private String senha;
    private String email;
    private String perfil;

    public Usuario(String idUsuario, String senha, String login, String nome, String perfil, String email) {
        this.idUsuario = idUsuario;
        this.senha = senha;
        this.login = login;
        this.nome = nome;
        this.perfil = perfil;
        this.email = email;
    }

    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
