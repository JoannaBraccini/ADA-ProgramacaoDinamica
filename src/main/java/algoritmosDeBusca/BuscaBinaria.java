package algoritmosDeBusca;
// Complexidade: T(n) = T(n/2) + O(1) -> O(log n)
// Pré-condição: o array deve estar ordenado para que a busca binária funcione corretamente.
public class BuscaBinaria {
    public static int busca(int[] array, int chave) {
        return buscaBinaria(array, chave, 0, array.length -1);
    }

    private static int buscaBinaria(int[] array, int chave, int esquerda, int direita) {
//      condição de parada do método recursivo:
        if (esquerda > direita) return -1;
//      Os índices em que me baseio são fornecidos para o método:
        int meio = esquerda + (direita - esquerda) / 2;
//      se o valor do meio for igual a chave, encontrei o elemento
        if (array[meio] == chave) return meio;
//      se o valor do meio for menor que a chave, busco na metade direita
        else if (array[meio] < chave) {
            return buscaBinaria(array, chave, meio + 1, direita);
//      se o valor do meio for maior que a chave, busco na metade esquerda
        } else {
            return buscaBinaria(array, chave, esquerda, meio - 1);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 8, 12, 17, 23, 38, 45, 56, 67}; //array ordenado
        int chave = 12;
        int indice = busca(array, chave);

        if (indice != -1) {
            System.out.println("Chave encontrada no índice " + indice);
        } else {
            System.out.println("Chave não encontrada.");
        }
    }
}
// Observação: quando o vetor não está ordenado, aplicar um método de ordenação
// (p.ex. O(n log n)) antes da busca binária geralmente custa mais do que
// simplesmente fazer uma busca sequencial O(n) para uma única busca. Para
// múltiplas buscas, pode fazer sentido ordenar e depois usar busca binária.
