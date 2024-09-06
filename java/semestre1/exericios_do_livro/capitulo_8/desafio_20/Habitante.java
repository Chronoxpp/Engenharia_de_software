//Desenvolvido por Lucas Dourado Rodrigues

public class Habitante {
    private String nome;
    private int qtdeFilhos;
    private double salario;

    public Habitante(double salario, String nome, int qtdeFilhos) {
        this.salario = salario;
        this.nome = nome;
        this.qtdeFilhos = qtdeFilhos;
    }

    public Habitante(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public Habitante(double salario, int qtdeFilhos) {
        this.salario = salario;
        this.qtdeFilhos = qtdeFilhos;
    }

    public Habitante(String nome) {
        this.nome = nome;
    }

    public Habitante() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getQtdeFilhos() {
        return qtdeFilhos;
    }

    public void setQtdeFilhos(int qtdeFilhos) {
        this.qtdeFilhos = qtdeFilhos;
    }
}
