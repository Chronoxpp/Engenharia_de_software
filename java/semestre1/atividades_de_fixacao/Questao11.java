package atividades_de_fixacao;
import java.util.Scanner;

class Questao11
{
    public static void main(String[] args)
    {
        Scanner leitor;
        leitor = new Scanner(System.in);
        int opcao;
        System.out.println("Realizemos um pequeno jogo, pense em um dos animais a seguir: leão,cavalo,homem,acaco,morcego,baleia,avestruz,pinguim,pato,águia,tartaruga,crocodilo e cobra");
        System.out.println("Responda a algumas simples perguntas e eu vou adivinhar o animal que você escolheu.");
        System.out.println("");

        
        System.out.println("1 = Mamifero");
        System.out.println("2 = Ave");
        System.out.println("3 = Réptil");
        System.out.print("Das opções acima, o seu animal é um/uma: ");
        opcao = leitor.nextInt();
        System.out.println("");

        switch(opcao)
        {
            case 1:
                System.out.println("1 = Quadrúpede");
                System.out.println("2 = Bipede");
                System.out.println("3 = Voador");
                System.out.println("4 = Aquatico");
                System.out.print("Ok, qual das opções acima tem relação com o animal que você escolheu?: ");
                opcao = leitor.nextInt();
                System.out.println("");

                if(opcao == 1)
                {
                    System.out.println("1 = Carnivoros");
                    System.out.println("2 = Herbivoros");
                    System.out.print("Ele é um herbivoro ou um carnivoro?: ");
                    opcao = leitor.nextInt();
                    System.out.println("");

                    if(opcao == 1)
                    {
                        System.out.println("O seu animal é um/uma: Leão");
                    }
                    else
                    {
                        System.out.println("O seu animal é um/uma: Cavalo");
                    }
                }
                else
                {
                    if(opcao == 2)
                    {
                        System.out.println("1 = Onivoros");
                        System.out.println("2 = Frutivoros");
                        System.out.print("Ele é um onivoro ou um frutivoro?: ");
                        opcao = leitor.nextInt();
                        System.out.println("");

                        if(opcao == 1)
                        {
                            System.out.println("O seu animal é um/uma: Homem");
                        }
                        else
                        {
                            System.out.println("O seu animal é um/uma: Macaco");
                        }
                    }
                    else
                    {
                        if(opcao == 3)
                        {
                            System.out.println("O seu animal é um/uma: Morcego");
                        }
                        else
                        {
                            System.out.println("O seu animal é um/uma: Baleia");
                        }
                    }
                }
            break;

            case 2:
                System.out.println("1 = Não-voadora");
                System.out.println("2 = Nadadora");
                System.out.println("3 = De rapina");
                System.out.print("Ok, qual das opções acima tem relação com o animal que você escolheu?: ");
                opcao = leitor.nextInt();
                System.out.println("");

                if(opcao == 1)
                {
                    System.out.println("1 = Tropicais");
                    System.out.println("2 = Polares");
                    System.out.print("Ele vive em areas tropicais ou em areas polares?: ");
                    opcao = leitor.nextInt();
                    System.out.println("");

                    if(opcao == 1)
                    {
                        System.out.println("O seu animal é um/uma: Avestruz");
                    }
                    else
                    {
                        System.out.println("O seu animal é um/uma: Pinguim");
                    }
                }
                else
                {
                    if(opcao == 2)
                    {
                        System.out.println("O seu animal é um/uma: Pato");
                    }
                    else
                    {
                        System.out.println("O seu animal é um/uma: Aguia");
                    }
                }
            break;

            case 3:
                System.out.println("1 = Com casco");
                System.out.println("2 = Carnivoro");
                System.out.println("3 = Sem patas");
                System.out.print("Ok, qual das opções acima tem relação com o animal que você escolheu?: ");
                opcao = leitor.nextInt();
                System.out.println("");

                if(opcao == 1)
                {
                    System.out.println("O seu animal é um/uma: Tartaruga");
                }
                else
                {
                    if(opcao == 2)
                    {
                        System.out.println("O seu animal é um/uma: Crocodilo");
                    }
                    else
                    {
                        System.out.println("O seu animal é um/uma: Cobra");
                    }
                }
            break;
        }
        leitor.close();
    }
}