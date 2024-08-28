public class NumeroNarcisista
{
    private int numero;

    NumeroNarcisista(int numero)
    {
        this.numero = numero;
    }

    public int calcularPotenciaDigitos()
    {
        String numeroString = String.valueOf(numero);

        int qtdeDigitos = 0;
        for(int i = 0; i < numeroString.length(); i += 1)
        {
            qtdeDigitos += 1;
        }
    }
}