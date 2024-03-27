class Teste
{
    public static void main(String[] args)
    {
        String[] a = new String[5];
        String[] b = new String[5];
        a[0] = "Bem";
        a[1] = "Vindo";
        a[3] = "";

        if(a[2] != null | a[3].equals(""))
        {
            System.out.println("Funcionou!");
            System.out.print(a[3].length());
        }
        else
        {
            System.out.println("não funcionou");
        }

        b[4] = "x";
        a = b;
        System.out.println("");
        System.out.println(a[0]);
        System.out.println(a[1]);
        System.out.println(a[4]);
    }
}