package ordenacaoQuadratica;

import java.util.Arrays;

public class SelectionSort {

    public static void sort(int[] array) {
        if (array == null || array.length < 2) {
            return; // nada a ordenar
        }
        int n = array.length;
        for (int i = 0; i < n - 1; i++) { // função quadrática n - 1
            int min = i; // o menor índice
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[min]) {
                    min = j; // atualiza o menor índice
                }
            }
            // troca o menor elemento encontrado com o primeiro elemento
            // swap(array, i, min); -> helper
            // sem usar um helper: usamos uma variável temporária para realizar a troca inline
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90, 1};

        System.out.println("Array original: " + Arrays.toString(array));

        sort(array);

        System.out.println("\nArray ordenado: " + Arrays.toString(array));
    }
}
