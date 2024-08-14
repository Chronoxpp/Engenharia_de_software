//Desenvolvido por: Lucas Dourado Rodrigues

import javax.swing.JOptionPane;

public class Sistema 
{
    AnoTemperatura anoAtual = new AnoTemperatura(12);

    public void adicionarTemperatura()
    {
        anoAtual.adicionarTemperaturaMedia(obterTemperatura());
    }

    public double obterTemperatura()
    {
        double temperatura;

        String stringTemperatura = JOptionPane.showInputDialog("Insira a temperatura");
        stringTemperatura = stringTemperatura.replace(",",".");
        stringTemperatura = stringTemperatura.replace(" ","");

        if(stringTemperatura == null || stringTemperatura.equals(""))
        {
            return -999;
        }
        else
        {
            temperatura = Double.parseDouble(stringTemperatura);
            return temperatura;
        }
    }

    public void exibirTemperaturasExtremas()
    {
        if(anoAtual.getContador() <= 0)
        {
            return;
        }

        String[] mesETemperatura;

        String msg;

        mesETemperatura = anoAtual.buscarMesComMaiorTemperatura();
        msg = "O mês com maior temperatura foi " + mesETemperatura[0] + " com " + mesETemperatura[1] + " graus celsius em media";
        JOptionPane.showMessageDialog(null, msg);

        mesETemperatura = anoAtual.buscarMesComMenorTemperatura();
        msg = "O mês com menor temperatura foi " + mesETemperatura[0] + " com " + mesETemperatura[1] + " graus celsius em media";
        JOptionPane.showMessageDialog(null, msg);
    }
}
