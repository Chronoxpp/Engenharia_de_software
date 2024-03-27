class Teste
{
    public static void main(String[] args)
    {
        String[] a = new String[5];
        a[0] = "Bem";
        a[1] = "Vindo";
        a[3] = "";

        if(a[2].length() == 0)
        {
            System.out.println("Funcionou!");
            System.out.print(a[3].length());
        }
        else
        {
            System.out.println("não funcionou");
        }
    }
}