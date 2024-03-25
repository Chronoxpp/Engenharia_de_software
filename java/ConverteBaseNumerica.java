class ConverteBaseNumerica
{
    public static void main(String[] args)
    {
        int[] numerosNaBaseDecimal = new int[256];
        numerosNaBaseDecimal = preencherVetordecimal(numerosNaBaseDecimal);

        int[] numerosNaBaseBinario;
        numerosNaBaseBinario=converterArrayDecimalParaBinario(numerosNaBaseDecimal);

        int[] numerosNaBaseOctal;
        numerosNaBaseOctal = converterArrayDecimalParaOctal(numerosNaBaseDecimal);

        String[] numerosNaBaseHexadecimal;
        numerosNaBaseHexadecimal = converterArrayDecimalParaHexadecimal(numerosNaBaseDecimal);

        exibirDadosDosVetores(numerosNaBaseDecimal,numerosNaBaseBinario,numerosNaBaseOctal,numerosNaBaseHexadecimal);
    }

    public static int[] preencherVetordecimal(int[] vetorDecimal)
    {
        for(int i = 0; i <= (vetorDecimal.length)-1; i = i+1)
        {
            vetorDecimal[i] = i;
        }

        return vetorDecimal;
    }
    
    public static int[] converterArrayDecimalParaBinario(int[] vetorDecimal)
    {
        int[] vetorBinario = new int[vetorDecimal.length];
        for(int numeroDecimal : vetorDecimal)
        {
            vetorBinario[numeroDecimal] = Integer.parseInt(converterNumeroNaBaseDesejada(numeroDecimal,2));
        }

        return vetorBinario;
    }

    public static int[] converterArrayDecimalParaOctal(int[] vetorDecimal)
    {
        int[] vetorOctal = new int[vetorDecimal.length];
        for(int numeroDecimal : vetorDecimal)
        {
            vetorOctal[numeroDecimal] = Integer.parseInt(converterNumeroNaBaseDesejada(numeroDecimal,8));
        }

        return vetorOctal;
    }

    public static String[] converterArrayDecimalParaHexadecimal(int[] vetorDecimal)
    {
        String[] vetorHexadecimal = new String[vetorDecimal.length];
        for(int numeroDecimal : vetorDecimal)
        {
            vetorHexadecimal[numeroDecimal] = converterNumeroNaBaseDesejada(numeroDecimal,16);
        }

        return vetorHexadecimal;
    }
    
    public static String converterNumeroNaBaseDesejada(int decimal, int baseNumerica)
    {
        String numeroNaBaseDesejada = "";

        if(decimal < baseNumerica)
        {
            if(baseNumerica == 16)
            {
                return converterParaAlgarismoHexadecimal(decimal);
            }
            else
            {
                return Integer.toString(decimal);
            }
        }
        else
        {
            while(decimal >=baseNumerica)
            {
                if(baseNumerica == 16)
                {
                    numeroNaBaseDesejada = numeroNaBaseDesejada + converterParaAlgarismoHexadecimal(decimal%baseNumerica);
                    decimal = decimal/baseNumerica;
                }
                else
                {
                    numeroNaBaseDesejada = numeroNaBaseDesejada + Integer.toString(decimal%baseNumerica);
                    decimal = decimal/baseNumerica;
                }

            }
            if(baseNumerica == 16)
            {
                numeroNaBaseDesejada = numeroNaBaseDesejada + converterParaAlgarismoHexadecimal(decimal);
            }
            else
            {
                numeroNaBaseDesejada = numeroNaBaseDesejada + Integer.toString(decimal);
            }
            
        }
        return  (inverterValorQualquer(numeroNaBaseDesejada));
    }

    public static String inverterValorQualquer(String valorQualquer)
    {
        String[] valorQuebrado = valorQualquer.split("");
        valorQualquer = "";
        for(int i = (valorQuebrado.length)-1; i >= 0; i = i-1)
        {
            valorQualquer = valorQualquer + valorQuebrado[i];
        }
        return  valorQualquer;
    }

    public static String converterParaAlgarismoHexadecimal(int numeroHexadecimal)
    {
        switch (numeroHexadecimal)
        {
            case (10):
                return "A";
            case (11):
                return "B";
            case (12):
                return "C";
            case (13):
                return "D";
            case (14):
                return "E";
            case (15):
                return "F";
            default:
                return Integer.toString(numeroHexadecimal);
        }
    }

    public static void exibirDadosDosVetores(int[] vetorDecimal,int[] vetorBinario,int[] vetorOctal,String[] vetorHexadecimal)
    {
        for(int i = 0; i <= (vetorDecimal.length) - 1;i = i +1)
        {
            System.out.println("D: "+vetorDecimal[i]+"   "+"B: "+vetorBinario[i]+"   "+"O: "+vetorOctal[i]+"   "+"H: "+vetorHexadecimal[i]);
        }
    }
} 