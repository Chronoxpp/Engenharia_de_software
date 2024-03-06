class Operfeito1
{    
    public static void main(String[] args) 
    {
        //declaro as variaveis e atribuo valores
        int perfeitos, numeatual,i,verificador,encontrar;
        encontrar = 10;
        perfeitos = 0;
        numeatual = 2;

        //
        do
        {
            verificador = 0;
            for(i = 1;i<=(numeatual/2);i = i+1)
            {   
                if((numeatual%i) == 0)
                {
                    verificador = verificador + i;
                }
            }
            if (verificador == numeatual)
            {
                perfeitos = perfeitos + 1;
                System.out.println(numeatual);
            }
            numeatual = numeatual+2;
            //System.out.println(numeatual); não se umporte com essa linha
        }while(perfeitos < encontrar);
        
        System.out.println("Acabou");
    }
}
