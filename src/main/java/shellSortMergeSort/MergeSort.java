package shellSortMergeSort;

// T(n) = 2T(n/2) + O(n) -> Complexidade linear -> n log n
public class MergeSort {

    public static void sort(int[] array) {

        // algoritmo recursivo para dividir o array em duas metades
        mergeSort(array, 0, array.length -1);
    }

    private static void mergeSort(int[] array, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(array, inicio, meio); //quebro do início ao meio
            mergeSort(array, meio + 1, fim); //quebro do meio + 1 ao fim

            merge(array, inicio, meio, fim); //junto as duas metades

        }
    }

    // método usando memória auxiliar para juntar os dois arrays
    private static void merge(int[] array, int inicio, int meio, int fim) {
        int indexE = meio - inicio + 1;
        int indexD = fim - meio;
        int[] esquerda = new int[indexE];
        int[] direita = new int[indexD];

        // preencher os vetores com os valores do vetor original
        for (int i = 0; i < indexE; i++) {
            esquerda[i] = array[inicio + i];
        } // para o vetor da esquerda
        for (int i = 0; i < indexD; i++) {
            direita[i] = array[meio + 1 + i];
        } // para o vetor da direita

        // juntar os dois vetores
        int k = inicio; // índice no array original
        int i = 0; // lado esquerdo
        int j = 0; // lado direito

        //escolher sempre o menor valor
        while (i < indexE && j < indexD) {
            // se o valor da esquerda for menor ou igual ao da direita
            if (esquerda[i] <= direita[j]) {
                // coloca o valor da esquerda no array original,
                // incrementando os índices do lado esquerdo e original
                array[k++] = esquerda[i++];
            } else {
                // senão, faz o mesmo com a direita
                array[k++] = direita[j++];
            }
        }

        // aproveitar os elementos que sobraram
        while (i < indexE) {
            // adicionar no vetor os elementos que sobraram na esquerda
            array[k++] = esquerda[i++];
        }
        while (j < indexD) {
            // adicionar no vetor os elementos que sobraram na direita
            array[k++] = direita[j++];
        }
    }

    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90, 1};

        System.out.println("Array original: " + java.util.Arrays.toString(array));

        sort(array);

        System.out.println("Array ordenado: " + java.util.Arrays.toString(array));
    }
}
