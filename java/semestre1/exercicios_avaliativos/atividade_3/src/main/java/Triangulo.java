import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Triangulo
{
    public String montarTringulo(double lado1, double lado2, double lado3)
    {
//        if(lado1 < 1 || lado2 < 1 || lado3 < 1)
//            throw new IllegalArgumentException();
//
//        if(lado1 > (lado2 + lado3))
//            throw new IllegalArgumentException();

        if(validarTriangulo(lado1, lado2, lado3) == false)
            throw new IllegalArgumentException();

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

    public boolean validarTriangulo(double lado1, double lado2, double lado3)
    {
        if(lado1 < 1 || lado2 < 1 || lado3 < 1)
            return false;

        if(lado1 > obterModuloDaDiferenca(lado2, lado3) && lado1 < (lado2 + lado3))
            return true;

        if(lado2 > obterModuloDaDiferenca(lado1, lado3) && lado2 < (lado1 + lado3))
            return true;

        if(lado3 > obterModuloDaDiferenca(lado1, lado2) && lado3 < (lado1 + lado2))
            return true;

        //Se chegou aqui entt os lados nao sao validos
        return false;
    }

    private double obterModuloDaDiferenca(double n1, double n2)
    {
        double n = n1 - n2;

        if(n < 0)
        {
            n = -1 * n;
        }

        return n;
    }
}
