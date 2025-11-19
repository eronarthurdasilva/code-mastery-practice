# Busca de Palavra em uma Grade

Este projeto implementa uma solução para o problema de busca de uma palavra em uma grade de caracteres. A palavra pode ser formada por letras de células adjacentes sequencialmente, onde células adjacentes são vizinhas **horizontal ou verticalmente**. Uma mesma célula **não pode ser usada mais de uma vez**.

---

## 📋 Descrição do Problema

Dada uma grade `m x n` de caracteres (`board`) e uma string `word`, o objetivo é verificar se a palavra `word` existe na grade. A palavra pode ser construída a partir de letras de células adjacentes sequencialmente, onde células adjacentes são vizinhas **horizontal ou verticalmente**. A mesma célula **não pode ser usada mais de uma vez**.

---

## 🧩 Exemplos

### Exemplo 1:
**Input:**  
```java
board = [
    ["A","B","C","E"],
    ["S","F","C","S"],
    ["A","D","E","E"]
]
word = "ABCCED"
```
**Output:** `true`

### Exemplo 2:
**Input:**  
```java
board = [
    ["A","B","C","E"],
    ["S","F","C","S"],
    ["A","D","E","E"]
]
word = "SEE"
```
**Output:** `true`

### Exemplo 3:
**Input:**  
```java
board = [
    ["A","B","C","E"],
    ["S","F","C","S"],
    ["A","D","E","E"]
]
word = "ABCB"
```
**Output:** `false`

---

## 🚀 Solução

A solução utiliza uma abordagem de busca em profundidade (DFS) para explorar todas as possíveis sequências de letras na grade que podem formar a palavra. A cada passo, a função verifica se a célula atual corresponde à letra atual da palavra e, em caso afirmativo, continua a busca nas células adjacentes.

```java
public class Solution {
        public boolean exist(char[][] board, String word) {
                for (int i = 0; i < board.length; i++) {
                        for (int j = 0; j < board[i].length; j++) {
                                if (dfs(board, word, i, j, 0)) {
                                        return true;
                                }
                        }
                }
                return false;
        }

        private boolean dfs(char[][] board, String word, int i, int j, int count) {
                if (count == word.length()) {
                        return true;
                }
                if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(count)) {
                        return false;
                }

                char temp = board[i][j];
                board[i][j] = ' ';
                boolean found = dfs(board, word, i + 1, j, count + 1)
                                || dfs(board, word, i - 1, j, count + 1)
                                || dfs(board, word, i, j + 1, count + 1)
                                || dfs(board, word, i, j - 1, count + 1);
                board[i][j] = temp;

                return found;
        }
}
```