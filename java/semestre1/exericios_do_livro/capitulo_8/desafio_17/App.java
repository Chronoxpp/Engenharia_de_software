//Desenvolvido por Lucas Dourado Rodrigues

import javax.swing.*;

public class App {
    public static void main(String[] args)
    {
        int n1 = 40;
        int n2 = 60;

        MDC mdc = new MDC();

        int n3 = mdc.calcularMDC(n1, n2);
        JOptionPane.showMessageDialog(null, "Numero 1: " + n1 + "\n numero 2: " + n2 + "\n\n MDC: " + n3);
    }
}
