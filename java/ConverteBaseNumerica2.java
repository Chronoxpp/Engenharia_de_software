class ConverteBaseNumerica2
{
    public static void main(String[] args)
    {
        int numerosNaBaseDecimal[] = new int[256];
        String numerosNaBaseBinario[] = new String[256];
        int abc2 = 0;
        String abc = "0101";

        //preencher o vetor decimal;
        //converter decimal para binario
        //converter decimal para octal
        //converter decimal para hexadecimal

        preencherVetordecimal(numerosNaBaseDecimal);
        
        for(int numeroDecimal : numerosNaBaseDecimal)
        {
            numerosNaBaseBinario[numeroDecimal] = converterParaBinario(numeroDecimal);
        }

        for(int numeroDecimal : numerosNaBaseDecimal)
        {
            //numerosNaBaseBinario[numeroDecimal] = inverterNumeroInteiro(numerosNaBaseBinario[numeroDecimal]);  
        }

        for(String i : numerosNaBaseBinario){System.out.println(i);}
    }

    public static int[] preencherVetordecimal(int[] vetorDecimal)
    {
        for(int i = 0; i <= (vetorDecimal.length)-1; i = i+1)
        {
            vetorDecimal[i] = i;
        }

        return vetorDecimal;
    }

    
    public static String converterParaBinario(int decimal)
    {
        String resto = "";
        int numeroBinario = 0;
        if(decimal < 2)
        {
            resto = Integer.toString(decimal);
            return resto;
        }
        else
        {
            while(decimal >=2)
            {
                resto = resto + Integer.toString(decimal%2);
                //numeroBinario = (numeroBinario*10)+decimal%2;
                decimal = decimal/2;
            }
            resto = resto + Integer.toString(decimal);
            //numeroBinario = (numeroBinario*10)+decimal;
        }

        String[] restoA = resto.split("");
        String[] retorno = new String[resto.length()];
        int x = 0;
        resto = "";
        for(int i = (restoA.length)-1; i >= 0; i = i-1)
        {
            resto = resto + restoA[i];
        }

        return resto;
    }
/* 
    public static int converterParaOctal(int numero)
    {

    }

    public static int converterParaHexadecimal(int numero)
    {

    }
*/

    public static int inverterNumeroInteiro(int numeroQualquer)
    {
        int numeroInvertido = 0;
        while(numeroQualquer != 0)
        {
            numeroInvertido = (numeroInvertido*10) + numeroQualquer%10;
            numeroQualquer = numeroQualquer/10;
        }

        return numeroInvertido;
    }

}