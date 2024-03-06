import java.util.Scanner;

class Questao11
{
    public static void main(String[] args)
    {
        Scanner Leitor;
        Leitor = new Scanner(System.in);
        int opcao;

        System.out.println("Escolha uma das opções abaixo:");
        System.out.println("1 = Mamifero");
        System.out.println("2 = Ave");
        System.out.println("3 = Réptil");
        opcao = Leitor.nextInt();

        switch(opcao)
        {
            case 1:
                System.out.println("1 = Quadrúpede");
                System.out.println("2 = Bipede");
                System.out.println("3 = Voador");
                System.out.println("4 = Aquatico");
                opcao = Leitor.nextInt();

                if(opcao == 1)
                {
                    System.out.println("1 = Carnivoros");
                    System.out.println("2 = Herbivoros");
                    opcao = Leitor.nextInt();

                    if(opcao == 1)
                    {
                        System.out.println("Leão");
                    }
                    else
                    {
                        System.out.println("Cavalo");
                    }
                }
                else
                {
                    if(opcao == 2)
                    {
                        System.out.println("1 = Onivoros");
                        System.out.println("2 = Frutivoros");
                        opcao = Leitor.nextInt();

                        if(opcao == 1)
                        {
                            System.out.println("Homem");
                        }
                        else
                        {
                            System.out.println("Macaco");
                        }
                    }
                    else
                    {
                        if(opcao == 3)
                        {
                            System.out.println("Morcego");
                        }
                        else
                        {
                            System.out.println("Baleia");
                        }
                    }
                }
            break;

            case 2:
                System.out.println("1 = Não-voadora");
                System.out.println("2 = Nadadora");
                System.out.println("3 = De rapina");
                opcao = Leitor.nextInt();

                if(opcao == 1)
                {
                    System.out.println("1 = Tropicais");
                    System.out.println("2 = Polares");
                    opcao = Leitor.nextInt();

                    if(opcao == 1)
                    {
                        System.out.println("Avestruz");
                    }
                    else
                    {
                        System.out.println("Pinguim");
                    }
                }
                else
                {
                    if(opcao == 2)
                    {
                        System.out.println("Pato");
                    }
                    else
                    {
                        System.out.println("Aguia");
                    }
                }
            break;

            case 3:
                System.out.println("1 = Com casco");
                System.out.println("2 = Carnivoro");
                System.out.println("3 = Sem patas");
                opcao = Leitor.nextInt();

                if(opcao == 1)
                {
                    System.out.println("Tartaruga");
                }
                else
                {
                    if(opcao == 2)
                    {
                        System.out.println("Crocodilo");
                    }
                    else
                    {
                        System.out.println("Cobra");
                    }
                }
            break;
        }

        Leitor.close();
    }
}