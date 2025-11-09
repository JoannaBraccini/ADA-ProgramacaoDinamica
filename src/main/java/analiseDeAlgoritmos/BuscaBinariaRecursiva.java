package analiseDeAlgoritmos;

public class BuscaBinariaRecursiva {

    private static int buscaBinariaRecursiva(int[] array, int chave, int esquerda, int direita) {

        if (esquerda > direita) return -1; // Chave não encontrada

        int meio = esquerda + (direita - esquerda) / 2; // CORREÇÃO: (direita - esquerda)

        if (array[meio] == chave) return meio; // Chave encontrada
        else if (array[meio] < chave) {
            return buscaBinariaRecursiva(array, chave, meio + 1, direita); // Procura na direita
        } else {
            return buscaBinariaRecursiva(array, chave, esquerda, meio - 1); // Procura na esquerda
        }
    }

    // Wrapper público que recebe apenas array e chave (assume array já ordenado)
    public static int buscaBinaria(int[] array, int chave) {
        if (array == null || array.length == 0) return -1;
        return buscaBinariaRecursiva(array, chave, 0, array.length - 1);
    }

    public static void main(String[] args) {
        // Teste simples
        int[] arr = {1, 3, 5, 7, 9, 11}; // array ordenado

        int chave1 = 7;
        int res1 = buscaBinaria(arr, chave1);
        System.out.println("Procurando " + chave1 + ": índice -> " + res1); // espera 3

        int chave2 = 2;
        int res2 = buscaBinaria(arr, chave2);
        System.out.println("Procurando " + chave2 + ": índice -> " + res2); // espera -1

        // Casos de borda
        int[] vazio = {};
        System.out.println("Array vazio busca 1: " + buscaBinaria(vazio, 1));

        int[] umElemento = {42};
        System.out.println("Array 1 elemento busca 42: " + buscaBinaria(umElemento, 42)); // 0
        System.out.println("Array 1 elemento busca 0: " + buscaBinaria(umElemento, 0)); // -1
    }
}