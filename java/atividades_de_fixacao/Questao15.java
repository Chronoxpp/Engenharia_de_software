package atividades_de_fixacao;
class Questao15
{
    public static void main(String[] args)
    {
        int result = 0;
        int numero = 7;
        for(int d1 = 1; d1 <= 6; d1 = d1 + 1)
        {
            for(int d2 = 1; d2 <= 6; d2 = d2 + 1)
            {
                if(d1+d2 == numero)
                {
                    result = result + 1;
                }
                //System.out.println(d1+"+"+d2+"= "+(d1+d2)+" ");
            }
        }
        System.out.print(result+" ou "+result+"/36 ou aproximadamente "+((result*100)/36)+"%");
    }
}
