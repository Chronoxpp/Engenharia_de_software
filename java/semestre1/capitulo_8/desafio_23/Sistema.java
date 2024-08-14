import javax.swing.JOptionPane;

public class Sistema 
{
    public String montarTringulo(double lado1, double lado2, double lado3)
    {
        if(lado1 == -1 || lado2 == -1 || lado3 == -1)
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

    public double obterLado()
    {
        String ladoString = JOptionPane.showInputDialog("Informe um numero");

        if(ladoString == null)
        {
            return -1;
        }
        else 
        {
            ladoString = ladoString.replace(" ", "");
            ladoString = ladoString.replace(",",".");

            if(ladoString.equals(""))
            {
                return -1;
            }
            else
            {
                return Double.parseDouble(ladoString);
            }
        } 
    }
}
