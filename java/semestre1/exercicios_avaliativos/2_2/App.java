import javax.swing.*;

public class App {
    public static void main(String[] args)
    {
        Sistema sistema = new Sistema();

        String nome = null;
        nome = sistema.obterNomeProduto();

        if(nome != null)
            JOptionPane.showMessageDialog(null, "Nome: " + nome);
    }
}
