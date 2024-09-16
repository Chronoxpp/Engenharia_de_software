import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Triangulo
{
    public String montarTringulo(double lado1, double lado2, double lado3)
    {
        if(lado1 < 1 || lado2 < 1 || lado3 < 1)
        {
            return null;
        }

        if(lado1 > (lado2 + lado3))
        {
            return null;
        }

        if(lado1 == lado2 && lado1 == lado3)
        {
            return "Equilatero";
        }
        else if(lado1 == lado2 || lado1 == lado3 || lado2 == lado3)
        {
            return "Isoceles";
        }
        else
        {
            return "Escaleno";
        }
    }
}
