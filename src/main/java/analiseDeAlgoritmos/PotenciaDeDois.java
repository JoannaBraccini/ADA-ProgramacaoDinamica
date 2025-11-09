package analiseDeAlgoritmos;

public class PotenciaDeDois {

    public static void potenciaDeDois(int n) {
        System.out.println("Potência de 2 até " + n + ":"); // peso constante
        // Log de N na base 2 por causa do fator de crescimento
        for (int i = 1; i <= n; i = i * 2) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int n = 1025;
        potenciaDeDois(n);
    }

    /**
     * Versão segura que valida o parâmetro antes de chamar
     * {@link #potenciaDeDois(int)}. Para n < 1 imprime uma mensagem e não chama
     * o método original (que espera n >= 1 para evitar loop imediato ou saída vazia).
     */
    public static void potenciaDeDoisSeguro(int n) {
        if (n < 1) {
            System.out.println("Valor inválido para n (deve ser >= 1): " + n);
            return;
        }
        potenciaDeDois(n);
    }

    /**
     * Retorna as potências de dois (como array de int) menores ou iguais a n.
     * Não modifica o método original; é utilitário para uso em testes ou lógica
     * que precise dos valores em memória.
     */
    public static int[] listarPotenciasDeDois(int n) {
        if (n < 1) return new int[0];
        // primeiro contar quantas potências cabem
        int count = 0;
        for (long val = 1; val <= n; val <<= 1) count++;
        int[] res = new int[count];
        int idx = 0;
        for (int val = 1; val <= n; val <<= 1) {
            res[idx++] = val;
            // evitar overflow: se val > n/2, o próximo deslocamento pode estourar
            if (val > Integer.MAX_VALUE / 2) break;
        }
        return res;
    }

    /**
     * Conta quantas potências de dois (1,2,4,...) são menores ou iguais a n.
     */
    public static int contadorPotenciasDeDois(int n) {
        if (n < 1) return 0;
        int count = 0;
        for (long val = 1; val <= n; val <<= 1) count++;
        return count;
    }
}
