package algoritmosDeOrdenacao;

// Método de ordenação usado pela api do Java por baixo dos panos
public class QuickSort {

// Final serve para impedir modificação do array no método
    public static void sort(final int[] array) {
// método recursivo que recebe o array e os índices de início e fim
        quicksort(array, 0, array.length - 1);
    }

    private static void quicksort(int[] array, int left, int right) {
        if (left < right) { //condição para chamar de forma recursiva
            //aplico o pivoteamento informando o array e os índices da esquerda e direita
            int pivotIndex = pivot(array, left, right); //descobrir índice do pivô
            quicksort(array, left, pivotIndex - 1); //chamar recursivamente para o lado esquerdo até o pivô
            quicksort(array, pivotIndex + 1, right); //chamar recursivamente para o lado direito até o pivô
            //pivô + 1 e - 1 pois ele já está na posição correta

        }
    }

    private static int pivot(int[] array, int pivotIndex, int endIndex) {
        int temp = pivotIndex; // apontando para o pivô
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
//            se o elemento for menor que o pivô
            if (array[i] < array[pivotIndex]) {
                swap(array, ++temp, i); // incremento temp e troco os valores
            }
        }
//      troco o pivô com o temp no final
        swap(array, pivotIndex, temp);
        return temp; // retorno o índice do pivô
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
