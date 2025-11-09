package algoritmosDeOrdenacao;

public class ShellSort {

    public static void sort(int[] array) {
        int n = array.length; //tamanho do vetor

        for (int gap = n/2; gap > 0; gap /= 2){ // para cada iteração, o gap será metade do valor anterior
            for (int i = gap; i < n; i++) { // percorre o vetor a partir do índice gap
                int chave = array[i]; //elemento escolhido
                //Dado o elemento chave, onde posicioná-lo baseado
                //nos elementos da esquerda, respeitando o intervalo
                int j = i; //índice dos elementos à esquerda

                // shift, analisando os elementos da esquerda:

                // enquanto j for maior ou igual ao gap e o elemento da esquerda for maior que a chave
                while (j >= gap && array[j - gap] > chave) {
                    // vai empurrando os elementos, fazendo shift no vetor respeitando o gap
                    array[j] = array[j - gap];
                    j -= gap; // navega para o lado esquerdo (gap)
                }

                array[j] = chave; // após finalizar o shift, coloca a chave no lugar correto
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90, 1};

        System.out.println("Array original: " + java.util.Arrays.toString(array));

        sort(array);

        System.out.println("Array ordenado: " + java.util.Arrays.toString(array));
    }
}
