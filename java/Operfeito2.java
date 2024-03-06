class Operfeito2
{    
    public static void main(String[] args) 
    {
        //declaro as variaveis e atribuo valores
        long perfeitos, pot_atual,encontrar,i,pprimo,cprimo,somapot;
        boolean primo;
        pot_atual = 0;
        somapot = 0;
        perfeitos = 0;
        encontrar = 10;

        //este loop mantem o codigo funcinando até achar 10 numeros perfeitos
        do
        {
            //este loop busca numeros perfeitos através de potencias e numeros primos, exibe por fim o numero perfeito encontrado
            do
            {
                //cprimo: confirma primo
                //pprimop: possivel primo ou o primo propriamente
                //primo: numero primo encontrado
                primo = false;
                cprimo = 0;

                if(pot_atual == 0)
                {
                    pot_atual = 2;
                    somapot = pot_atual;
                }
                else
                {
                    pot_atual = pot_atual * 2;
                    somapot = somapot + pot_atual;
                }
                pprimo = somapot + 1;
                
                for(i=2;i<=(pprimo/2);i=i+1)
                {
                    if(pprimo%i == 0)
                    {cprimo = cprimo + 1;}
                }
                cprimo = cprimo + 2;
                if(cprimo > 2)
                {
                    primo = false;
                }
                else
                {
                    primo = true;
                }

            }while(primo == false);

            perfeitos = perfeitos + 1;
            System.out.println((pprimo * pot_atual));
        }while(perfeitos < encontrar);
        System.out.println("Acabou");
    }
}