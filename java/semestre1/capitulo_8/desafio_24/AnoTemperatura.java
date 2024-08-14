//Desenvolvido por: Lucas Dourado Rodrigues

public class AnoTemperatura 
{
    private double mesesTemperaturas[];
    private int contador = 0;

    //
    public AnoTemperatura(int quantidadeMeses)
    {
        mesesTemperaturas = new double[quantidadeMeses];
    }

    //
    public void adicionarTemperaturaMedia(double temperaturaMedia)
    {
        if(contador >= 12)
        {
            return;
        }

        if (temperaturaMedia == -999) 
        {
            return;
        }

        mesesTemperaturas[contador] = temperaturaMedia;
        contador += + 1;
    }

    //
    public String[] buscarMesComMaiorTemperatura()
    {
        int mes = 0;
        double temperatura = mesesTemperaturas[0];
        for(int i = 0; i < contador; i += 1)
        {
            if(mesesTemperaturas[i] > temperatura)
            {
                mes = i;
                temperatura = mesesTemperaturas[i];
            }
        }

        String[] mesETemperatura = new String[2];
        mesETemperatura[0] = converterIntParaMesString(++mes);
        mesETemperatura[1] = String.valueOf(temperatura);

        return mesETemperatura;
    }

    //
    public String[] buscarMesComMenorTemperatura()
    {
        int mes = 0;
        double temperatura = mesesTemperaturas[0];
        for(int i = 0; i < contador; i += 1)
        {
            if(mesesTemperaturas[i] < temperatura)
            {
                mes = i;
                temperatura = mesesTemperaturas[i];
            }
        }

        String[] mesETemperatura = new String[2];
        mesETemperatura[0] = converterIntParaMesString(++mes);
        mesETemperatura[1] = String.valueOf(temperatura);

        return mesETemperatura;
    }

    //
    private String converterIntParaMesString(int mes)
    {
        if(mes == 1)
        {
            return "Janeiro";
        }
        else if(mes == 2)
        {
            return "Fevereiro";
        }
        else if(mes == 3)
        {
            return "Março";
        }
        else if(mes == 4)
        {
            return "Abril";
        }
        else if(mes == 5)
        {
            return "Maio";
        }
        else if(mes == 6)
        {
            return "Junho";
        }
        else if(mes == 7)
        {
            return "Julho";
        }
        else if(mes == 8)
        {
            return "Agosto";
        }
        else if(mes == 9)
        {
            return "Setembro";
        }
        else if(mes == 10)
        {
            return "Outubro";
        }
        else if(mes == 11)
        {
            return "Novembro";
        }
        else if(mes == 12
        )
        {
            return "Dezembro";
        }
        else
        {
            return null;
        }
    }


    public double[] getMesesTemperaturas() 
    {
        return mesesTemperaturas;
    }

    public int getContador()
    {
        return contador;
    }
}
