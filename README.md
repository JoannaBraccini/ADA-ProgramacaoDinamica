# Programação Dinâmica — Estudos 🧠

[![Joannabraccini](https://img.shields.io/badge/LinkedIn-Joannabraccini-0A66C2?logo=linkedin)](https://www.linkedin.com/in/Joannabraccini)


Esse repositório reúne implementações simples (Java) para estudo de algoritmos — principalmente buscas e ordenações quadráticas — com comentários e exemplos para aprendizado.

---

Sumário
- [Sobre](#sobre)
- [Estrutura do projeto](#estrutura-do-projeto)
- [Tabela comparativa (resumo)](#tabela-comparativa-resumo)
- [Exemplos rápidos](#exemplos-rápidos)

---

## Sobre

Objetivo: ter um espaço pequeno e prático para experimentar implementações, comparar comportamento (trocas, estabilidade, complexidade) e testar ideias.

Uso: ideal para leitura de código, execução local e exercício de análise de complexidade.

Nota: este estudo faz parte do programa "Elas + Tech" da Ada — material de aprendizado e prática desenvolvido no âmbito do programa.

---

## Estrutura do projeto

- `src/main/java/analiseDeAlgoritmos` — buscas e utilitários (ex.: `BuscaBinariaRecursiva`).
- `src/main/java/ordenacaoQuadratica` — implementações O(n²): `BubbleSort.java`, `SelectionSort.java`, `InsertionSort`.

### Arquivos em `src/main/java/analiseDeAlgoritmos`

Abaixo há uma descrição dos arquivos presentes no pacote `analiseDeAlgoritmos`: foco no propósito, complexidade assintótica e pontos importantes para análise.

- `BuscaBinariaRecursiva.java` — Implementação recursiva da busca binária.
  - Propósito: demonstrar busca em tempo logarítmico quando o array está ordenado.
  - Complexidade: O(log n) tempo, O(1) espaço auxiliar (recursão adiciona O(log n) na pilha).
  - Pontos de estudo: condicionais de término, cálculo de "meio" para evitar overflow, pré-condição de array ordenado, comportamento com arrays pares/ímpares e com elementos duplicados.

- `BuscaSequencial.java` — Implementação da busca linear.
  - Propósito: mostrar o algoritmo mais simples para procurar um valor em uma coleção não ordenada.
  - Complexidade: O(n) tempo no pior caso, O(1) espaço.
  - Pontos de estudo: melhor caso (encontrado na primeira posição), pior caso (não encontrado), uso de um método utilitário `contem` como wrapper booleano.

- `BuscaSequencialLoopsAninhados.java` — Busca sequencial em matrizes (loops aninhados) com uma versão "segura" que trata linhas nulas/irregulares.
  - Propósito: ilustrar custos de algoritmos com estruturas bidimensionais e problemas práticos como linhas com comprimentos diferentes ou nulas.
  - Complexidade: O(rows * cols) tempo, O(1) espaço (ignorando a representação da matriz).
  - Pontos de estudo: mapeamento de posição 2D para índice linear (row-major), diferenças entre implementação "original" e a versão que evita NullPointerException, trade-offs para arrays ragged.

- `PotenciaDeDois.java` — Demonstra crescimento logarítmico por iterações exponenciais (1,2,4,...).
  - Propósito: mostrar iterações que crescem em potências de dois, contar e listar potências <= n.
  - Complexidade: O(log n) iterações; utilitários adicionais retornam arrays com todas as potências <= n.
  - Pontos de estudo: uso de shifts para multiplicação por 2, cuidado com overflow e uso de tipos maiores quando necessário, variantes seguras que validam parâmetros.

- `Teorema Master` — Nota/arquivo texto com enunciado e exemplos do Teorema Mestre; material de referência para resolver recorrências.
  - Formulação (resumo): para recorrências da forma
    T(n) = a T(n/b) + f(n), com a > 0, b > 1,
    defina k = log_b(a).
    - Se f(n) = O(n^{k - eps}) para algum eps > 0  => T(n) = Theta(n^k).
    - Se f(n) = Theta(n^k)                         => T(n) = Theta(n^k log n).
    - Se f(n) = Omega(n^{k + eps}) e condição regularidade => T(n) = Theta(f(n)).
  - Exemplos objetivos:
    - Merge sort: T(n) = 2 T(n/2) + Theta(n)  => a=2, b=2, k=1 => T(n) = Theta(n log n).
    - Busca binária: T(n) = T(n/2) + Theta(1) => a=1, b=2, k=0 => T(n) = Theta(log n).
    - Caso com maior subdivisão: T(n) = 4 T(n/2) + Theta(n) => a=4, b=2, k=2 => T(n) = Theta(n^2).
  - Observação: verificar hipóteses do teorema (formas de f e condição de regularidade) antes de aplicar; o arquivo `Teorema Master` contém enunciado e exemplos usados neste repositório.

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

Algumas classes incluem um método `main` com exemplos simples que demonstram uso básico das implementações.

---

## Contato / Referência

Perfil LinkedIn: https://www.linkedin.com/in/Joannabraccini
