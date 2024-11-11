import java.util.Scanner;
class BubbleSort {
    public static void main(String[] args){
        Scanner leia = new Scanner(System.in);
        int[] vetor;
        vetor = new int[10];
        // leitura do vetor -> populando o vetor
        for (int i = 0; i <= 9; i = i + 1){
            System.out.println("Vetor["+i+"]: ");
            vetor[i] = leia.nextInt();
        }
        System.out.println(" Vetor Original: ");
        // mostrando o vetor
        for (int i = 0; i <= 9; i = i + 1){
            System.out.print("["+vetor[i]+"] ");
        }
        System.out.println("");
        System.out.println(" Vetor Ordenado: ");
        // ordenando o vetor
        // Rodadas
        for (int i = 0; i <= 8; i = i + 1){
            for (int j = 0; j < 9 - i; j = j + 1) {
                // comparar os pares
                if (vetor[j] > vetor[j+1]){
                    int aux = vetor[j];
                    vetor[j] = vetor[j+1];
                    vetor[j+1] = aux;
                }
            }
        }
        // Vetor ordenado
        for (int i = 0; i <= 9; i = i + 1){
            System.out.print("["+vetor[i]+"] ");
        }
        leia.close();
    }
}