package algoritmosDeOrdenacao;
/*
* Passos:
* trabalhar na árvore binária;
* transformar em uma árvore heap max;
* fazer a substituição dos valores com heapify;
* */
public class HeapSort {
    public static void sort(int[] array) {
        int n = array.length;

        // Construir a árvore Heap:
        // iterar da metade - 1 do vetor, pois num vetor
        // o filho à esquerda é 2*i+1 e à direita 2*i+2
        // Assim não analisamos os nós folhas, só os pais
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i); // array com n elementos a partir da posição i
        }
        for (int i = n - 1; i >= 0; i--) {
            swap(array, 0, i);
            heapify(array, i, 0);
        }
    }
    // recebe o array, a qtd de elementos e o nó de análise
    private static void heapify(int[] array, int n, int i) {
        int maior = i; // maior elemento será a raiz da árvore
        int esquerda = 2 * i + 1; // filho à esquerda
        int direita = 2 * i + 2; // filho à direita

        // Transformar o vetor em uma Heap Max:
        // se o filho à esquerda for maior que a raiz
        if (esquerda < n && array[esquerda] > array[maior]) maior = esquerda;
        // se o filho à direita for maior que a raiz
        if (direita < n && array[direita] > array[maior]) maior = direita;
        // se o maior não for o analisado
        if (maior != i) {
            // faço a troca de valor entre os índices maior e i
            swap(array, maior, i);
            // refaço o heapify, porém agora com o índice do maior elemento
            // assim reanaliso a árvore após reposicionamento até estabilizar
            heapify(array, n, maior);
            // estabiliza quando o maior índice for o maior valor da árvore binária
        }
    }

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90, 1};

        System.out.println("Array original: " + java.util.Arrays.toString(array));
        sort(array);
        System.out.println("Array ordenado: " + java.util.Arrays.toString(array));
    }
}
