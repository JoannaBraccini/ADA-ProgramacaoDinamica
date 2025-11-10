package algoritmosDeBusca;

// O(n)
public class BuscaSequencial {

    public static int busca(int[] array, int chave) {
        for (int i = 0; i < array.length; i++) {
//          Se o índice for igual à chave, encontrei o elemento
            if (array[i] == chave) return i;
        }
        return -1; // senão, não encontrei
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 8, 12, 17, 23, 38, 45, 56, 67};
        int chave = 23;

        int indice = busca(array, chave);

        if (indice != -1) {
            System.out.println("Chave encontrada no índice " + indice);
        } else {
            System.out.println("Chave não encontrada");
        }
    }
}
