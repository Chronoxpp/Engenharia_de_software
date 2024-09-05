import javax.swing.JOptionPane;

public class AnaliseFilme 
{
    Espectador[] espectadores = new Espectador[20];
    int contador = 0;

    //
    public void adicionarEspectador(Espectador espectador)
    {
        if(contador >= espectadores.length)
        {
            JOptionPane.showMessageDialog(null, "Limite de espectadores atingido !!");
            return;
        }

        espectadores[contador] = espectador;
        contador += 1;
    }

    //
    public double calcularMediaIdades(int nota)
    {
        double media = 0;
        double qtdeEspectadores = 0;
        double somatoriaIdades = 0;

        for(int espectador_i = 0; espectador_i < contador; espectador_i += 1)
        {
            if(espectadores[espectador_i].getAvaliacao() == nota)
            {
                qtdeEspectadores += 1;
                somatoriaIdades = somatoriaIdades + espectadores[espectador_i].getIdade();
            }
        }

        if (qtdeEspectadores > 0) 
        {
            media = somatoriaIdades / qtdeEspectadores;
        }
        else
        {
            media = 0;
        }

        return media;
    }

    //
    public int contarEspectadores(int nota)
    {
        int qtdeEspectadores = 0;

        for(int espectador_i = 0; espectador_i < contador; espectador_i += 1)
        {
            if(espectadores[espectador_i].getAvaliacao() == nota)
            {
                qtdeEspectadores += 1;
            }
        }

        return qtdeEspectadores;
    }

    //
    public double calcularPorcentagem(int nota)
    {
        double qtdeEspectadores = 0;

        for(int espectador_i = 0; espectador_i < contador; espectador_i += 1)
        {
            if(espectadores[espectador_i].getAvaliacao() == nota)
            {
                qtdeEspectadores += 1;
            }
        }

        double porcentagemEspectadores = (qtdeEspectadores/ (double) espectadores.length) * 100;

        return porcentagemEspectadores;
    }


    public Espectador[] getEspectadores() 
    {
        return espectadores;
    }

    public void setEspectadores(Espectador[] espectadores) 
    {
        this.espectadores = espectadores;
    }

    public int getContador() 
    {
        return contador;
    }

    public void setContador(int contador) 
    {
        this.contador = contador;
    }
}
