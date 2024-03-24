class ConverteBaseNumerica2
{
    public static void main(String[] args)
    {
        int[] numerosNaBaseDecimal = new int[256];
        numerosNaBaseDecimal = preencherVetordecimal(numerosNaBaseDecimal);

        int[] numerosNaBaseBinario;
        numerosNaBaseBinario=converterArrayDecimalParaBinario(numerosNaBaseDecimal);

        for(int i : numerosNaBaseBinario){System.out.println(i);}
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
            vetorBinario[numeroDecimal] = converterNumeroNaBaseDesejada(numeroDecimal,2);
        }

        return vetorBinario;
    }
    
    public static int converterNumeroNaBaseDesejada(int decimal, int baseNumerica)
    {
        String numeroBinario = "";

        if(decimal < baseNumerica)
        {
            return decimal;
        }
        else
        {
            while(decimal >=baseNumerica)
            {
                numeroBinario = numeroBinario + Integer.toString(decimal%baseNumerica);
                decimal = decimal/baseNumerica;
            }
            numeroBinario = numeroBinario + Integer.toString(decimal);
        }
        return  Integer.parseInt(inverterValorQualquer(numeroBinario));
    }
/* 
    public static int converterParaOctal(int numero)
    {

    }

    public static int converterParaHexadecimal(int numero)
    {

    }
*/

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
} 