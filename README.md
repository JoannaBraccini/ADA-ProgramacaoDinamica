# Programação Dinâmica — Estudos

Olá! Este repositório é um espaço simples e prático para estudar implementações em Java de algoritmos clássicos — principalmente buscas e ordenações — com comentários e exemplos curtos para ajudar no aprendizado.

[LinkedIn](https://www.linkedin.com/in/Joannabraccini)

---

Sumário: Sobre • Pacotes • Tabela Hash • Algoritmos Gulosos • Tabela comparativa • Compilar & Executar • Contribuições • Contato

---

## Sobre

Objetivo: oferecer exemplos claros e comentados para estudo ou revisão de conceitos de análise de algoritmos: complexidade, estabilidade, número de trocas e trade-offs práticos.

---

## Pacotes

- `algoritmosDeOrdenacao`
  - Implementações de ordenação mais sofisticadas e suas variantes: `MergeSort`, `QuickSort`, `HeapSort`, `ShellSort`. Use este pacote para comparar desempenho médio, escolhas de pivô/gaps e uso de espaço auxiliar.
  - Exemplo de execução (após compilar):

    ```bash
    java -cp target\classes algoritmosDeOrdenacao.MergeSort
    ```

- `ordenacaoQuadratica`
  - Implementações didáticas O(n²): `BubbleSort`, `SelectionSort`, `InsertionSort`. Ótimo para entender trocas, estabilidade, e por que algoritmos melhores importam em casos maiores.
  - Exemplo de execução:

    ```bash
    java -cp target\classes ordenacaoQuadratica.InsertionSort
    ```

- `analiseDeAlgoritmos`
  - Utilitários e exemplos de buscas: `BuscaBinariaRecursiva`, `BuscaSequencial`, `PotenciaDeDois`, e material de apoio (Teorema Mestre). Bom para revisar recorrências e comportamento assintótico.
  - Exemplo de execução:

    ```bash
    java -cp target\classes analiseDeAlgoritmos.BuscaBinariaRecursiva
    ```

- `algoritmosDeBusca`
  - Implementações de buscas clássicas e didáticas (ex.: `BuscaBinaria`). Foca em versões recursivas/iterativas e pré-condições (array ordenado quando necessário).
  - Exemplo de execução:

    ```bash
    java -cp target\classes algoritmosDeBusca.BuscaBinaria
    ```

- `tabelaHash`
  - Implementação de tabela hash com tratamento de colisões por encadeamento (`HashTable`). Ideal para estudar hashing, funções de dispersão e redimensionamento automático.
  - Características: inserção, busca, remoção, redimensionamento e tratamento de colisões por listas encadeadas.
  - Exemplo de execução:

    ```bash
    java -cp target\classes tabelaHash.HashTable
    ```

- `algoritmosGulosos`
  - Conjunto de algoritmos gulosos clássicos e didáticos: `CodigoDeHuffman` (compressão), escalonamento por intervalos, e exemplos de troco/knapsack fracionário.
  - Bom para estudar heurísticas locais, sua correção e casos onde a estratégia gulosa falha.
  - Exemplo de execução:

    ```bash
    java -cp target\classes algoritmosGulosos.CodigoDeHuffman
    ```

---

## Tabela Hash

### Descrição

Implementação pedagógica de tabela hash com encadeamento para tratamento de colisões. A classe principal é `HashTable` no pacote `tabelaHash`. Observação: a implementação atual é simples — usa chaves `String` e valores `int` e um hash baseado no tamanho da string.

### Funcionalidades

- `set(String key, int value)` — inserir ou atualizar um par chave/valor.
- `get(String key)` — buscar valor por chave (retorna `Integer` ou `null` se não existir).

Observação: a implementação atual não fornece `remove` nem redimensionamento automático (o número de buckets é fixo na classe).

### Complexidade (esperada)

- Inserção: O(1) médio (dependendo da função de hash)
- Busca: O(1) médio
- Pior caso (muitas colisões): O(n)

### Exemplo de uso (baseado na classe `main` existente)

```text
HashTable hashTable = new HashTable();
hashTable.set("casa", 10);
hashTable.set("asa", 20);
hashTable.set("azul", 25);

System.out.println(hashTable.get("azul")); // esperado: 25
System.out.println(hashTable.get("teste")); // esperado: null
```

### Testes

- Atualmente não há testes em `src/test/java` neste repositório. Se desejar, posso adicionar testes básicos cobrindo inserção, colisões e busca.

---

## Algoritmos Gulosos

### Descrição

Coleção de implementações de algoritmos gulosos clássicos. No código atual existe `CodigoDeHuffman` no pacote `algoritmosGulosos`, que constrói a tabela de códigos de Huffman a partir de um `String` de entrada.

### Problemas/Implementações notáveis

- `CodigoDeHuffman` — construção de árvore de Huffman e geração de um mapa `Map<Character, String>` com os códigos.
- Possíveis materiais adicionais no pacote: escalonamento de intervalos, knapsack fracionário (não verificados automáticamente).

### API observada

- `public static Map<Character, String> encode(String text)` — gera o mapeamento de caracteres para códigos de bits.
- `public static void main(String[] args)` — exemplo de uso já presente na classe.

### Exemplo (baseado na implementação atual)

```text
String text = "BCCABBDDAECCBBAEDDCC";
Map<Character, String> huffmanTable = CodigoDeHuffman.encode(text);
for (char c : huffmanTable.keySet()) {
    System.out.println(c + ": " + huffmanTable.get(c));
}
```

## Tabela comparativa

| Algoritmo      | Complexidade (Melhor / Médio / Pior) | Espaço Aux. | # Trocas (ord.) | Estável? | Observações                                    |
|----------------|---------------------------------------:|------------:|----------------:|:--------:|------------------------------------------------|
| Bubble Sort    | O(n) / O(n²) / O(n²)                 | O(1)        | O(n²)           | sim      | Simples; ótimo para aprender; lento em grandes entradas |
| Selection Sort | O(n²) / O(n²) / O(n²)                | O(1)        | O(n)            | não      | Poucas trocas; útil quando trocas são caras; não estável     |
| Insertion Sort | O(n) / O(n²) / O(n²)                 | O(1)        | O(n²)           | sim      | Excelente para listas quase ordenadas; estável              |
| Merge Sort     | O(n log n) / O(n log n) / O(n log n)| O(n)        | O(n log n)      | sim      | Estável; bom para grandes volumes; usa espaço adicional     |
| Quick Sort     | O(n log n) / O(n log n) / O(n²)     | O(log n)    | O(n log n)      | não      | Muito rápido na prática; pivô/partição impactam o pior caso |
| Heap Sort      | O(n log n) / O(n log n) / O(n log n)| O(1)        | O(n log n)      | não      | Em-place e previsível; não estável                         |
| Shell Sort     | depende da sequência de gaps         | O(1)        | varia           | não      | Excelente para arrays moderados; performance depende da sequência de gaps |

> Nota: ShellSort depende fortemente da sequência de gaps; o número de trocas é uma indicação geral para ordenações in-place.

---

## Como compilar e executar

Requisitos: Java JDK 17; Maven instalado.

No Windows CMD (na raiz do projeto):

```bash
cd local-do-projeto\ProgramacaoDinamica
mvn -DskipTests package
# depois escolha a classe com main que quiser executar, por exemplo:
java -cp target\classes ordenacaoQuadratica.InsertionSort
```

Dica: se estiver usando uma IDE (IntelliJ/Eclipse), importe como projeto Maven para executar `main`s diretamente.

---

## Contato

LinkedIn: https://www.linkedin.com/in/Joannabraccini

---

License: uso educacional — sinta-se à vontade para estudar e adaptar o código.
