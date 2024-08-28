import javax.swing.JOptionPane;

public class TesteVeiculo 
{
    public void testarVeiculo()
    {
        double custoFabrica = obterCustoFabrica();
        double porcentagemLucroDistribuidor = obterPorcentagemDistribuidor();
        double porcentagemmpostos = obterPorcentagemImpostos();

        Veiculo veiculo = new Veiculo(custoFabrica, porcentagemLucroDistribuidor, porcentagemmpostos);

        JOptionPane.showMessageDialog(null, "Custo de fabrica: " + custoFabrica + "\n %lucro do distribuidor%: " + porcentagemLucroDistribuidor + "\n %impostos%: " + porcentagemmpostos + "\n\n valor total: " + veiculo.calcularPrecoConsumidor());
    }

    public double obterCustoFabrica()
    {
        String custoFabricaString = null;
        double custoFabrica = 0;

        while (custoFabricaString == null) 
        {
            custoFabricaString = JOptionPane.showInputDialog("Insira o custo do veiculo");

            if(custoFabricaString == null)
            {
                custoFabricaString = null;
            }
            else
            {
                custoFabricaString = custoFabricaString.trim();

                if(custoFabricaString.equals(""))
                {
                    custoFabricaString = null;
                }
                else
                {
                    try
                    {
                        custoFabrica = Double.parseDouble(custoFabricaString);
                    }
                    catch(Exception erro)
                    {
                        JOptionPane.showMessageDialog(null, "Você deve inserir apenas numeros !!");
                    }                    
                }
            }
        }

        return custoFabrica;
    }

    public double obterPorcentagemDistribuidor()
    {
        String porcentagemDistribuidorString = null;
        double porcentagemDistribuidor = 0;

        while (porcentagemDistribuidorString == null) 
        {
            porcentagemDistribuidorString = JOptionPane.showInputDialog("Insira a porcentagem de lucro do distribuidor");

            if(porcentagemDistribuidorString == null)
            {
                porcentagemDistribuidorString = null;
            }
            else
            {
                porcentagemDistribuidorString = porcentagemDistribuidorString.trim();

                if(porcentagemDistribuidorString.equals(""))
                {
                    porcentagemDistribuidorString = null;
                }
                else
                {
                    try
                    {
                        porcentagemDistribuidor = Double.parseDouble(porcentagemDistribuidorString);
                    }
                    catch(Exception erro)
                    {
                        JOptionPane.showMessageDialog(null, "Você deve inserir apenas numeros !!");
                    }                    
                }
            }
        }

        return porcentagemDistribuidor;
    }

    public double obterPorcentagemImpostos()
    {
        String porcentagemImpostosString = null;
        double porcentagemImpostos = 0;

        while (porcentagemImpostosString == null) 
        {
            porcentagemImpostosString = JOptionPane.showInputDialog("Insira a porcentagem de impostos");

            if(porcentagemImpostosString == null)
            {
                porcentagemImpostosString = null;
            }
            else
            {
                porcentagemImpostosString = porcentagemImpostosString.trim();

                if(porcentagemImpostosString.equals(""))
                {
                    porcentagemImpostosString = null;
                }
                else
                {
                    try
                    {
                        porcentagemImpostos = Double.parseDouble(porcentagemImpostosString);
                    }
                    catch(Exception erro)
                    {
                        JOptionPane.showMessageDialog(null, "Você deve inserir apenas numeros !!");
                    }                    
                }
            }
        }

        return porcentagemImpostos;
    }
}
