//Desenvolvido por Lucas Dourado Rodrigues

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args)
    {
        List<Habitante> habitantes = new ArrayList<Habitante>();

        Sistema sistema = new Sistema();

        sistema.preencherListaHabitantesAleatoriamente(habitantes);
        sistema.exibirDetalhesHabitantes(habitantes);
    }
}
