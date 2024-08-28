import javax.swing.JOptionPane;

public class Main 
{
    public static void main(String[] args)
    {
        JOptionPane.showMessageDialog(null, "Uma matriz 10 por 10 será gerada, os valores acima da diagonal principal serão somados e a somatoria sera exibida");
        Matriz matriz = new Matriz(10, 10);

        matriz.popularMatriz();
        JOptionPane.showMessageDialog(null, matriz.converterMatrizParaMsg());

        JOptionPane.showMessageDialog(null, "A somataria da matriz [" + matriz.getMatriz().length + "] por [" 
        + matriz.getMatriz()[0].length + "]" + " é \n\n " + matriz.somarElementosAcimaDiagonalPrincipal());
    }
}