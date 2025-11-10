# Programação Dinâmica — Estudos

Olá! Este repositório é um espaço simples e prático para estudar implementações em Java de algoritmos clássicos — principalmente buscas e ordenações — com comentários e exemplos curtos para ajudar no aprendizado.

[LinkedIn](https://www.linkedin.com/in/Joannabraccini)

---

Sumário: Sobre • Pacotes • Tabela comparativa • Compilar & Executar • Contribuições • Contato

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

---

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
