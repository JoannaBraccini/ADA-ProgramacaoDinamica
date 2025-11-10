package tabelaHash;

//Lista encadeada
public class HashTable {
    private final Node[] dataMap;

    static class Node {
        //      Um nó armazena chave e valor, e aponta para o próximo nó
        String key;
        int value;
        Node next;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable() {
        // instanciar meu mapa de dados com tamanho definido (buckets)
        int size = 7;
        dataMap = new Node[size];
    }

    private int hash(String key) {
// retorna o tamanho da string mod (resto da divisão) o tam. dos buckets
        return key.length() % dataMap.length;
//      se ocorrerem 2 strings de mesmo tamanho haverá colisão
    }

    public Integer get(String key) {
//      Calcular em qual bucket estará armazenado
        int index = hash(key);
//      Pegar o nó inicial do bucket (pois é uma lista encadeada)
        Node temp = dataMap[index];
//      Percorrer a lista encadeada até encontrar a chave
        while (temp != null) {
//          Se encontrar a chave, retornar o valor
            if (temp.key.equals(key)) return temp.value;
//          Se não, ir para o próximo nó
            temp = temp.next;
        }
        return null; // Se não encontrar, retornar null
    }

    public void set(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value); // Crio novo nó
        // Se bucket não for vazio, insiro na cabeça da lista
        if (dataMap[index] != null) newNode.next = dataMap[index];
        // Caso trivial: bucket vazio -> novo nó é o primeiro
        dataMap[index] = newNode; // Aponto para o novo nó
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.set("casa", 10);
        hashTable.set("asa", 20);
        hashTable.set("azul", 25);

        System.out.println(hashTable.get("azul")); // esperado: 25
        System.out.println(hashTable.get("teste")); // esperado: null
    }
}
