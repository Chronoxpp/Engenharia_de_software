package classes;

public class Atividade {
    private String responsavel;
    private String atividade;
    private String status;
    private static int objetosCriados = 0;

    public Atividade(String responsavel,String atividade,String status)
    {
        this.responsavel = responsavel;
        this.atividade = atividade;
        this.status = status;

        objetosCriados = objetosCriados + 1;
    }

    public Atividade()
    {
        objetosCriados = objetosCriados +1;
    }

    public void setResponsavel(String responsavel)
    {
        this.responsavel = responsavel;
    }
    
    public void setAtividade(String atividade)
    {
        this.atividade = atividade;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getResponsavel()
    {
        return this.responsavel;
    }

    public static int getObjetosCriados()
    {
        return objetosCriados;
    }
}
