import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;

public class Sistema {
    @FXML
    private Button botao;

    @FXML
    public TextField txt1;

    @FXML
    public TextField txt2;

    @FXML
    public TextField txt3;

    @FXML
    public Label lbl;

    // Método que será chamado ao clicar no botão
    @FXML
    private void handleBotaoAction()
    {
        try
        {
            double lado1 = Double.parseDouble(txt1.getText());
            double lado2 = Double.parseDouble(txt2.getText());
            double lado3 = Double.parseDouble(txt3.getText());

            Triangulo triangulo = new Triangulo();
            String trianguloTipo = triangulo.montarTringulo(lado1, lado2, lado3);

            lbl.setText(trianguloTipo);
        }
        catch(NumberFormatException erro) //Erro quando nao é possivel converter as caixas de texto para numeros
        {
            lbl.setText("");
        }
        catch(IllegalArgumentException erro) //Erro quando o usuario fornece dados identificados como invalidos
        {
            lbl.setText("Não é um triangulo");
        }
        catch(Exception erro) //Erro qualquer é tratado aqui caso os outro catch nao o capturem
        {
            lbl.setText("Um erro ocorreu");
        }
    }
}
