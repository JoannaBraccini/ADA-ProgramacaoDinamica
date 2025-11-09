package ordenacaoQuadratica;

import java.util.Arrays;

public class BubbleSort {


    /**
     * Ordena o array fornecido usando o algoritmo Bubble Sort.
     * O método altera o array original (in-place). Ele percorre o array com
     * dois loops aninhados e troca elementos adjacentes sempre que o atual
     * é maior que o próximo, "borrifando" o maior elemento para o fim em
     * cada iteração externa.
     * Entrada: array (int[]) - array de inteiros a ser ordenado.
     * Efeito: o array passado como parâmetro será modificado e ficará ordenado
     * em ordem crescente.
     * Complexidade: tempo O(n^2) no pior caso e O(1) espaço adicional.
     */
    public static void sort(int[] array) {

        int last = array.length - 1; // índice do último elemento do array
        for (int i = 0; i < last; i++) {
            // loop externo: garantimos que repetimos o processo o suficiente
            // para colocar todos os maiores elementos no final do array
            for (int j = 0; j < last; j++) { // vai até o penúltimo índice
                // se o elemento atual é maior que o próximo, trocamos
                if (array[j] > array[j + 1]) {
                    // chama o método auxiliar que faz a troca dos valores
                    swap(array, j, j + 1);
                }
            }
        }
    }

    /**
     * Troca dois elementos no array (helper).
     *
     * Parâmetros:
     * - array: o array onde a troca ocorrerá.
     * - firstIndex: índice do primeiro elemento a ser trocado.
     * - secondIndex: índice do segundo elemento a ser trocado.
     *
     * Este método usa uma variável temporária para efetuar a troca in-place.
     */
    protected static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex]; // guarda o valor do primeiro elemento
        array[firstIndex] = array[secondIndex]; // coloca o valor do segundo no primeiro
        array[secondIndex] = temp; // restaura o valor guardado no segundo
    }

    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90, 1};

        System.out.println("Array original: " + Arrays.toString(array));

        sort(array);

        System.out.println("\nArray ordenado: " + Arrays.toString(array));
    }
}
