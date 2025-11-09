package analiseDeAlgoritmos;

public class BuscaSequencialLoopsAninhados {

    public static int buscaSequencial(int[][] matriz, int chave) {
        // busca sequencial em matriz com loops aninhados
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == chave) {
                    return i * matriz[i].length + j; // retorna o índice calculado a partir da posição da matriz
                }
            }
        }
        return -1; // retorna -1 se a chave não for encontrada
    }

    /**
     * Wrapper seguro que não lança NullPointerException em matrizes com linhas
     * nulas e que trata matriz nula/vazia retornando -1.
     * Observação: para compatibilidade com o método original, o índice retornado
     * ainda usa a fórmula i * linha.length + j (mesmo se as linhas tiverem
     * comprimentos diferentes). Se precisar de enumeração row-major lógica para
     * arrays ragged, use uma implementação com offset.
     */
    public static int buscaSequencialSegura(int[][] matriz, int chave) {
        if (matriz == null || matriz.length == 0) return -1;
        for (int i = 0; i < matriz.length; i++) {
            int[] linha = matriz[i];
            if (linha == null || linha.length == 0) continue;
            for (int j = 0; j < linha.length; j++) {
                if (linha[j] == chave) {
                    return i * linha.length + j;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // testes rápidos para demonstração (não alteram o método original)
        int[][] matriz1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Original (matriz1) busca 5 -> " + buscaSequencial(matriz1, 5));
        System.out.println("Seguro  (matriz1) busca 5 -> " + buscaSequencialSegura(matriz1, 5));

        int[][] matriz2 = {
            {10, 11},
            {12},
            {13, 14, 15}
        };
        System.out.println("Original (matriz2) busca 12 -> " + buscaSequencial(matriz2, 12));
        System.out.println("Seguro  (matriz2) busca 12 -> " + buscaSequencialSegura(matriz2, 12));

        int[][] matriz3 = {
            null,
            {},
            {1}
        };
        // chamar o método original em matriz3 produziria NullPointerException;
        // aqui mostramos que a versão segura lida com isso.
        try {
            System.out.println("Original (matriz3) busca 1 -> (pode lançar exceção) " + buscaSequencial(matriz3, 1));
        } catch (Exception e) {
            System.out.println("Original (matriz3) lançou: " + e.getClass().getSimpleName());
        }
        System.out.println("Seguro  (matriz3) busca 1 -> " + buscaSequencialSegura(matriz3, 1));
    }
}