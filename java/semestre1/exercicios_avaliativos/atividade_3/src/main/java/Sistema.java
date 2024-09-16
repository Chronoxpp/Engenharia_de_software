import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Sistema {
    @FXML
    private Button botao; // Botão de calcular

    // Método que será chamado ao clicar no botão
    @FXML
    private void handleBotaoAction()
    {
        // Faça o cálculo aqui
        System.out.println("Entrada do usuário: " + 2);
    }
}
