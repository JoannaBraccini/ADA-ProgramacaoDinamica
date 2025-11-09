package ordenacaoQuadratica;

import java.util.Arrays;

public class InsertionSort {

    public static void sort(int[] array) {

        int n = array.length;
        for (int i = 1; i < n; i++) { // começo no segundo elemento
            int chave = array[i]; // guarda o valor do elemento de referência
            int j = i - 1; // guarda a posição anterior ao elemento de referência
            while (j >= 0 && array[j] > chave) { // enquanto o valor anterior for maior que a chave (valor de referência)
                array[j + 1] = array[j]; // vou empurrando os elementos (fazendo shift)
                j--; // navego para o lado esquerdo
            }
            array[j + 1] = chave; // encaixo a chave na posição
        }
    }

    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90, 1};

        System.out.println("Array original: " + Arrays.toString(array));

        sort(array);

        System.out.println("\nArray ordenado: " + Arrays.toString(array));
    }
}
