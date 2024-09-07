//Desenvolvido por Lucas Dourado Rodrigues

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args)
    {
        int n1 = 40;
        int n2 = 60;

        MDC mdc = new MDC();

        int n3 = mdc.calcularMDC(n1, n2);
        JOptionPane.showMessageDialog(null, "Numero 1: " + n1 + "\n numero 2: " + n2 + "\n\n MDC: " + n3);

        //Abaixo é criado e populado uma lista de numeros de forma randomica, depois o valor do MDC é exibido
        Random randomizador = new Random();
        int totalDeNumerosNaLista = randomizador.nextInt(2, 6);

        List<Integer> numeros = new ArrayList<Integer>();
        for(int i = 0; i < totalDeNumerosNaLista; i += 1)
        {
            numeros.add(randomizador.nextInt(20, 100));
        }

        String msg = "";
        for(Integer numero : numeros)
        {
            msg += numero + "  ";
        }

        msg += "\n\n MDC: " + mdc.calcularMDC(numeros);

        JOptionPane.showMessageDialog(null, msg);
    }
}
