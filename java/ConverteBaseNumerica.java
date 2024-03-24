class ConverteBaseNumerica
{
    public static void main(String[] args)
    {
        int numerosNaBaseDecimal[] = new int[256];
        String numerosNaBaseBinario[] = new String[256];

        //preencher o vetor decimal;
        //converter decimal para binario
        //converter decimal para octal
        //converter decimal para hexadecimal


        for(int i = 0; i < numerosNaBaseDecimal.length; i = i+1)
        {
            numerosNaBaseDecimal[i] = i;
        }

        for(int numeroDecimal : numerosNaBaseDecimal)
        {
            String resto = "";
            boolean fim = false;
            int aux = numeroDecimal;

            while (fim == false) 
            {
                if(aux < 2)
                {
                    if(resto.equals(""))
                    {
                        resto = Integer.toString(aux);
                        numerosNaBaseBinario[numeroDecimal] = resto;
                        fim = true;
                    }
                    else
                    {
                        resto = resto + Integer.toString(aux);
                        numerosNaBaseBinario[numeroDecimal] = resto;
                        fim = true;
                    }
                }
                else
                {
                    if(resto.equals(""))
                    {
                        resto = Integer.toString(aux%2);
                        aux = (aux/2);
                    }
                    else
                    {
                        resto = resto + Integer.toString(aux%2);
                        aux = (aux/2);
                    }
                }
                //se menor entt usa
                //se maior ou igual entt divide e usa resto
                //repete até ser menor
            }
        }

        for(String i : numerosNaBaseBinario){System.out.println(i);}
    }
}

