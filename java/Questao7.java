import java.util.Scanner;

class Questao7{
    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);
        int v1;
        float h; 
        System.out.print("Digite um numero: ");
        v1 = leitor.nextInt();
        h = 0;

        for(float i = 1; i <= v1; i = i +1){
            h = h + (1/i);
        }

        System.out.print("O resultado é: "+h);

        leitor.close();
    }
}
