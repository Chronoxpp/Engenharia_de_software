class Operfeito1
{    
    public static void main(String[] args) 
    {
        //declaro as variaveis e atribuo valores
        int perfeitosDescobertos, numeroAtual,somaDosDivisores,quantidadeDePerfeitosProcurados;
        quantidadeDePerfeitosProcurados = 10;
        perfeitosDescobertos = 0;
        numeroAtual = 2;

        //
        do
        {
            somaDosDivisores = 0;
            for(int i = 1;i<=(numeroAtual/2);i = i+1)
            {   
                if((numeroAtual%i) == 0)
                {
                    somaDosDivisores = somaDosDivisores + i;
                }
            }

            if (somaDosDivisores == numeroAtual)
            {
                perfeitosDescobertos = perfeitosDescobertos + 1;
                System.out.println(numeroAtual);
            }

            numeroAtual = numeroAtual+2;
        }while(perfeitosDescobertos < quantidadeDePerfeitosProcurados);
        
        System.out.println("Acabou");
    }
}
