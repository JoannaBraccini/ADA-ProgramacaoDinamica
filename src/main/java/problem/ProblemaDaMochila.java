package problem;

public class ProblemaDaMochila {
    private final int qtdElementos;
    private final int capacidadeMochila;
    private int beneficioTotal;
    private final int[] pesos;
    private final int[] valores;
    private final int[][] tabelaMochila;

    public ProblemaDaMochila(final int qtdElementos, final int capacidadeMochila, final int[] pesos, final int[] valores) {
        this.qtdElementos = qtdElementos;
        this.capacidadeMochila = capacidadeMochila;
        this.pesos = pesos;
        this.valores = valores;
//      + 1 porque linha 0 e coluna 0 são usadas para casos base
        tabelaMochila = new int[qtdElementos + 1][capacidadeMochila + 1];
    }

    public void solve(){
// navegar sobre a matriz:
//      navego nas linhas
        for (int i = 1; i < qtdElementos + 1; i++) {
//          navego nas colunas
            for (int j = 1; j < capacidadeMochila + 1; j++) {
// complexidade da resolução: qtdElementos * capacidadeMochila
                int naoPegarItem = tabelaMochila[i - 1][j]; //pegar a linha superior da tabela
                int pegarItem = 0; //o valor que quero calcular
// só posso pegar o item se o peso do item for menor ou igual a capacidade da mochila
                if (pesos[i - 1] <= j) {
                    pegarItem = valores[i - 1] + tabelaMochila[i - 1][j - pesos[i - 1]];
                }
                tabelaMochila[i][j] = Math.max(pegarItem, naoPegarItem);
            }
        }
        beneficioTotal = tabelaMochila[qtdElementos][capacidadeMochila]; // última posição da tabela
    }

    void imprimirMochila() {
        int resultado = beneficioTotal;
        int p = capacidadeMochila;
        //navego nos itens de baixo para cima
        for (int i = qtdElementos; i > 0 && resultado > 0; i--) {
            if (resultado != tabelaMochila[i - 1][p]) {
                System.out.print(pesos[i - 1] + " ");
                resultado -= valores[i - 1]; // retiro o valor do item que foi pego
                p -= pesos[i - 1]; // retiro o peso do item que foi pego
            }
        }
    }

    public static void main(String[] args) {
        int[] pesos = {2, 3, 4, 5};
        int[] valores = {1, 2, 5, 6};
        int capacidadeMochila = 8;
        ProblemaDaMochila mochila = new ProblemaDaMochila(pesos.length, capacidadeMochila, pesos, valores);

        mochila.solve();
        System.out.println("Total: " + mochila.beneficioTotal);
        mochila.imprimirMochila();
    }
}