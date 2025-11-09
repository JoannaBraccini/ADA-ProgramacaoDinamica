package analiseDeAlgoritmos;

public class BuscaSequencial {

    public static int buscaSequencial(int[] array, int chave) {
        // validação básica
        if (array == null || array.length == 0) return -1;

        // busca sequencial linear
        for (int i = 0; i < array.length; i++) {
            if (array[i] == chave) {
                return i; // retorna o índice onde a chave foi encontrada
            }
        }
        return -1; // retorna -1 se a chave não for encontrada
    }

    /**
     * Utilitário conveniente que responde se a chave existe no array.
     *
     * @param array array onde procurar
     * @param chave valor a procurar
     * @return true se a chave estiver presente, false caso contrário
     */
    public static boolean contem(int[] array, int chave) {
        return buscaSequencial(array, chave) != -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 8, 12, 17, 23, 38, 45, 56, 67};
        int chave = 23;

        int indice = buscaSequencial(array, chave);
        System.out.println("Procurando " + chave + " no array -> índice: " + indice); // espera 5
        System.out.println("Teste: " + (indice == 5 ? "OK" : "FAIL"));

        // teste: chave não presente
        int chave2 = 2;
        int r2 = buscaSequencial(array, chave2);
        System.out.println("Procurando " + chave2 + " no array -> índice: " + r2); // espera -1
        System.out.println("Teste: " + (r2 == -1 ? "OK" : "FAIL"));

        // teste: array vazio
        int[] vazio = {};
        System.out.println("Array vazio busca 1 -> " + buscaSequencial(vazio, 1)); // espera -1

        // teste: array null
        System.out.println("Array null busca 1 -> " + buscaSequencial(null, 1)); // espera -1

        // teste: um elemento
        int[] um = {42};
        System.out.println("Array [42] busca 42 -> " + buscaSequencial(um, 42)); // espera 0
        System.out.println("Array [42] busca 0 -> " + buscaSequencial(um, 0)); // espera -1

        // exemplos usando o utilitário contem
        System.out.println("contem 23? " + contem(array, 23));
        System.out.println("contem 99? " + contem(array, 99));
    }
}
