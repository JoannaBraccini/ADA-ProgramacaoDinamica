# Análise de Algoritmos — Estudos 🧠

[![Joannabraccini](https://img.shields.io/badge/LinkedIn-Joannabraccini-0A66C2?logo=linkedin)](https://www.linkedin.com/in/Joannabraccini)


Esse repositório reúne implementações simples (Java) para estudo de algoritmos — principalmente buscas e ordenações quadráticas — com comentários e exemplos para aprendizado.

---

Sumário
- [Sobre](#sobre)
- [Estrutura do projeto](#estrutura-do-projeto)
- [Como compilar & executar (Windows - cmd.exe)](#como-compilar--executar-windows---cmdexe)
- [Tabela comparativa (resumo)](#tabela-comparativa-resumo)
- [Exemplos rápidos](#exemplos-rápidos)
- [Próximos passos sugeridos](#próximos-passos-sugeridos)

---

## Sobre

Objetivo: ter um espaço pequeno e prático para experimentar implementações, comparar comportamento (trocas, estabilidade, complexidade) e testar ideias.

Uso: ideal para leitura de código, execução local e exercício de análise de complexidade.

Nota: este estudo faz parte do programa "Elas + Tech" da Ada — material de aprendizado e prática desenvolvido no âmbito do programa.

---

## Estrutura do projeto

- `src/main/java/analiseDeAlgoritmos` — buscas e utilitários (ex.: `BuscaBinariaRecursiva`).
- `src/main/java/ordenacaoQuadratica` — implementações O(n²): `BubbleSort.java`, `SelectionSort.java`, `InsertionSort` (se houver).

---

## Como compilar & executar (Windows - cmd.exe)

Pré-requisitos: Java JDK (11+) e, se quiser, Maven.

Compilar com Maven:

```cmd
mvn -q package
```

Executar uma classe com `main` (ex.: `BubbleSort`):

```cmd
java -cp target/classes ordenacaoQuadratica.BubbleSort
```

Executar o jar (se existir):

```cmd
java -jar target\ProgramacaoDinamica-1.0-SNAPSHOT.jar
```

Dica rápida: se quiser apenas testar um arquivo, pode compilar direto com `javac` e executar com `java -cp`.

---

## Tabela comparativa (resumo)

| Algoritmo      | O(temporal)     | O(espaco) | # Trocas | Estável? | Considerações                                    |
|----------------|------------------|-----------|----------|----------|--------------------------------------------------|
| Bubble Sort    | O(n²) / O(n)*    | O(1)      | O(n²)    | sim      | Simples; bom para aprendizado; fraco em grandes dados    |
| Selection Sort | O(n²)            | O(1)      | O(n)     | não      | Simples; poucas trocas (útil quando trocas custam caro) |
| Insertion Sort | O(n²) / O(n)     | O(1)      | O(n²)    | sim      | Excelente para listas quase ordenadas; estável |

> (*) O(n) refere-se ao melhor caso (já ordenado / quase ordenado).

---

## Exemplos rápidos

No `main` de cada classe há um exemplo com arrays pequenos. Exemplos que recomendo testar:
- Array aleatório grande (para ver tempo e trocas)
- Array já ordenado (melhor caso para Bubble/Insertion)
- Array reverso (pior caso para muitos sortings)

---

## Contato / Referência

Perfil LinkedIn: https://www.linkedin.com/in/Joannabraccini