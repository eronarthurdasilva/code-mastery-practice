# LeetCode 1878 - Get Biggest Three Rhombus Sums in a Grid

## 📋 Descrição do Problema

Dado uma matriz `grid` de dimensões `m x n`, você precisa encontrar os **3 maiores valores de soma de rombos** distintos na grade.

Um **rombo** é definido por:
- Um vértice superior em posição `(r, c)`
- Um tamanho/raio `l` (onde `l ≥ 0`)
- Formado por células que seguem a geometria de um rombo ao redor do vértice superior

### Geometria do Rombo (exemplo com l=2)

```
        (r,   c)          ← vértice superior
       /          \
  (r+1,c-1)  (r+1,c+1)  ← lados superiores
     /                \
 (r+2,c-2)      (r+2,c+2) ← vértices esquerdo e direito
     \                /
  (r+3,c-1)  (r+3,c+1)  ← lados inferiores
       \          /
        (r+4, c)           ← vértice inferior
```

**Casos Especiais:**
- Quando `l = 0`, o rombo é apenas a célula `(r, c)`
- O rombo inclui todos os vértices e as células nas arestas

## 📊 Exemplos

### Exemplo 1
```
Input: grid = [[3,4,5,1],[3,3,4,2],[20,30,200,40],[1,5,5,4]]
Output: [240,188,54]

Explicação:
- O rombo com vértice superior em (2,2) e raio 1:
  Células: 4 + 3 + 200 + 5 = 212
  
- O rombo com vértice superior em (1,1) e raio 2:
  Células: 3 + 4 + 5 + 1 + 3 + 4 ... = 240
  
- Os três maiores rombos têm somas: 240, 188, 54
```

### Exemplo 2
```
Input: grid = [[1,2,3],[4,5,6],[7,8,9]]
Output: [45]

Explicação:
- Há apenas um rombo válido (com raio 0 ou 1)
- A maior soma é 45
```

## 🎯 Abordagem

### Estratégia: Força Bruta com Enumeração Geométrica

1. **Para cada raio `l`** (de 0 até o máximo possível):
   - O raio máximo é `min(m-1, n-1) / 2`

2. **Para cada posição válida `(r, c)`** como vértice superior:
   - `r` deve estar em `[0, m-1]`
   - `c` deve estar em `[l, n-1-l]` (ter espaço para os lados)

3. **Calcular a soma do rombo**:
   - Somar os 4 vértices cardinais
   - Somar todas as células nas 4 arestas

4. **Armazenar as somas** em um conjunto para deduplicação

5. **Extrair os 3 maiores valores** do conjunto ordenado

## 📈 Análise de Complexidade

| Aspecto | Análise |
|---------|---------|
| **Tempo** | O(m × n × min(m,n)²) |
| **Espaço** | O(m × n × min(m,n)) |

**Justificativa:**
- Iteramos através de: m linhas × n colunas × min(m,n) raios possíveis
- Para cada rombo, calculamos a soma em O(raio) = O(min(m,n))
- Armazenamos no máximo O(m × n × min(m,n)) somas distintas

**Viabilidade:**
- Com restrições `m, n ≤ 50`, a solução é perfeitamente viável
- Máximo de operações: 50 × 50 × 25 × 25 = 1.5 milhões

## 💻 Implementação

A solução está em `Solution.c++` e utiliza:
- `set<int>` para manter as somas ordenadas e deduplic adas automaticamente
- Iteração geométrica para enumerar todos os rombos válidos
- Função auxiliar `computeRhombusSum()` para calcular a soma de um rombo

### Principais Funções

```cpp
vector<int> getBiggestThree(vector<vector<int>>& grid)
// Função principal que retorna os 3 maiores valores

int computeRhombusSum(const vector<vector<int>>& grid, int r, int c, int l)
// Calcula a soma de um rombo com vértice superior em (r,c) e raio l
```

## 🚀 Como Executar

```bash
# Compilar (C++)
g++ -std=c++17 -o solution Solution.c++

# Executar com teste
./solution
```

## 🔍 Observações Importantes

1. **Deduplicação automática**: O conjunto `set<int>` garante que valores duplicados apareçam apenas uma vez
2. **Espaço necessário**: O rombo deve estar completamente dentro da matriz
3. **Ordem dos resultados**: Os 3 maiores são retornados em ordem decrescente
4. **Menos de 3 rombos**: Se houver menos de 3 somas distintas, retorna os que existem

## 📚 Referências

- [LeetCode 1878](https://leetcode.com/problems/get-biggest-three-rhombus-sums-in-a-grid/)
- Dificuldade: **Medium**
- Tópicos: Array, Math, Enumeration

---

**Última atualização**: 2026-03-16
