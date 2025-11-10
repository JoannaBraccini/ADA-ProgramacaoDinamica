package algoritmosGulosos;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Criar uma árvore
class NoHuffman implements Comparable<NoHuffman> {

    char character;
    int frequency;
    NoHuffman left;
    NoHuffman right;

    public NoHuffman(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(final NoHuffman other) {
        return this.frequency - other.frequency;
    }
}

public class CodigoDeHuffman {
    //    retornar o mapeamento do character em bits
    public static Map<Character, String> encode(String text) {
//        calcular a frequência dos caracteres
        Map<Character, Integer> frequencyMap = new HashMap<>();
        // pego cada character da string e, à medida que vou lendo, vou atualizando o mapa
        for (char c : text.toCharArray()) {
//            sobrescrevo caso já exista o character
//            get or default retorna 0 caso o character não exista ainda no mapa ou 1 caso exista, depois incremento (+ 1)
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
//        construção da árvore usando fila de prioridades
//        à medida que for adicionando elementos na fila,
//        os itens de menor frequência, ou maior, ficarão ordenados
        PriorityQueue<NoHuffman> priorityQueue = new PriorityQueue<>();
//        baseado na regra do comparable implementada,
//        os menores ficarão no começo da fila e os maiores no final
        for (char c : frequencyMap.keySet()) {
//            organizando os elementos da fila
            priorityQueue.add(new NoHuffman(c, frequencyMap.get(c)));
        }
//       ler a fila e montar a árvore binária
        while (priorityQueue.size() > 1) { // enquanto a fila tiver mais de um elemento
            // leio e removo os primeiro elemento da fila
            NoHuffman left = priorityQueue.poll();
            NoHuffman right = priorityQueue.poll();
//            crio um nó pai que não possui character, serve
//            apenas para juntar os dois nós filhos
            NoHuffman parent = new NoHuffman('\0', left.frequency + right.frequency);
            // aponta para os filhos
            parent.left = left;
            parent.right = right;
            priorityQueue.add(parent); // adiciono na fila
//            Paro quando sobrar apenas um elemento na fila,
//            que será a raiz da árvore
        }
        NoHuffman root = priorityQueue.poll(); //pego a raiz da árvore
//        quem estiver à esquerda terá o bit 0, à direita 1
        Map<Character, String> huffmanTable = new HashMap<>();
        generateCodes(root, "", huffmanTable);

        return huffmanTable; // retorno o mapeamento (tabela preenchida)
    }
//    Navegar na árvore e montar as strings que representam os bits do character (mapa -> chars, string -> bits)
    private static void generateCodes(NoHuffman node, String code, Map<Character, String> table) {
//        Processamento pré order (R-E-D)
//        condições triviais:
        if (node == null) return; // nó nulo = não processo nada
//        se for um nó folha:
        if (node.left == null && node.right == null) {
            table.put(node.character, code); // adiciono o character e o código (string de bits) na tabela
        }

//        Se não for um nó folha, continuo navegando na árvore
        generateCodes(node.left, code + "0", table); // vou para esquerda, adiciono 0 ao código
        generateCodes(node.right, code + "1", table); // vou para direita, adiciono 1 ao código
    }

    public static void main(String[] args) {
        String text = "BCCABBDDAECCBBAEDDCC";
        Map<Character, String> huffmanTable = encode(text);
//      imprimir a tabela de códigos de Huffman
        for (char c : huffmanTable.keySet()) {
            System.out.println(c + ": " + huffmanTable.get(c));
        }
        /*
        Esperado:
        A: 011
        B: 10
        C: 11
        D: 00
        E: 010
        * */
    }
}
