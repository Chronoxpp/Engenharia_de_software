package classes;

public class Principal {
    public static void main(String[] args)
    {
        Atividade atividade1;
        atividade1 = new Atividade("","","");

        Atividade atividade2;
        atividade2 = new Atividade();
        atividade2.setResponsavel("oie");

        System.out.println(Atividade.getObjetosCriados());
    }
}
