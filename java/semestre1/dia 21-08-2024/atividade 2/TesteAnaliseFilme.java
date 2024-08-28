import javax.swing.JOptionPane;

public class TesteAnaliseFilme 
{
    public void testarFilme()
    {
        AnaliseFilme analise = new AnaliseFilme();

        String[] botoes = {"Cadastrar espectador", "Relatorio de analises", "Sair"};

        boolean sair = false;
        while(sair == false)
        {
            int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Selecione  uma ação", "Home", 0, 0, null, botoes, 0);

            if (opcaoSelecionada == 0) 
            {
                analise.adicionarEspectador(cadastrarEspectador());
            }
            else if(opcaoSelecionada == 1)
            {
                if(analise.getContador() == 0)
                {
                    JOptionPane.showMessageDialog(null, "cadastre algum espectador !!");
                    return;
                }

                JOptionPane.showMessageDialog(null, "Média das idades dos espectadores que deram nota \"excelente\": " + analise.calcularMediaIdades(3));
                JOptionPane.showMessageDialog(null, "Número de espectadores que deram nota \"regular\": " + analise.contarEspectadores(1));
                JOptionPane.showMessageDialog(null, "Porcentagem de espectadores que deram nota \"bom\" em relação ao total: " + analise.calcularPorcentagem(2));
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Encerrando...");
                sair = true;
            }
        }
    }

    //
    public Espectador cadastrarEspectador()
    {
        String idadeString = null;
        int idade = 0;
        while (idadeString == null) 
        {
            idadeString = JOptionPane.showInputDialog("Insira a idade do espectador");
            
            if(idadeString == null)
            {
                idadeString = null;
            }
            else
            {
                idadeString = idadeString.trim();

                if(idadeString.equals(""))
                {
                    idadeString = null;
                }
                else
                {
                    try
                    {
                        idade = Integer.parseInt(idadeString);
                    }
                    catch(Exception erro) //Eu sei que isso é horrivel, mas melhorarei, isso é uma certeza
                    {
                        JOptionPane.showMessageDialog(null, "Você deve inserir apenas numeros !!");
                        idadeString = null;
                    }
                }
            }
        }

        String avaliacaoString = null;
        int avalicao = 0;
        while (avaliacaoString == null) 
        {

            avaliacaoString = JOptionPane.showInputDialog("Insira a avaliação: 'Regular', 'Bom' ou 'Excelente'");

            if(avaliacaoString == null)
            {
                avaliacaoString = null;
            }
            else
            {
                avaliacaoString = avaliacaoString.trim();

                if(avaliacaoString.equals(""))
                {
                    idadeString = null;
                }
                else if(avaliacaoString.equalsIgnoreCase("Regular"))
                {
                    avalicao = 1;
                }
                else if(avaliacaoString.equalsIgnoreCase("Bom"))
                {
                    avalicao = 2;
                }
                else if(avaliacaoString.equalsIgnoreCase("Excelente"))
                {
                    avalicao = 3;
                }
                else
                {
                    avaliacaoString = null;
                }
            }
        }

        Espectador espectador = new Espectador(idade, avalicao);
        return espectador;
    }
}
