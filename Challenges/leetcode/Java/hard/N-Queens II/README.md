# N-Queens II

O **N-Queens** é um problema clássico de colocar `n` rainhas em um tabuleiro de xadrez `n x n` de forma que nenhuma rainha ataque outra. No xadrez, uma rainha pode atacar outra se estiver na mesma linha, coluna ou diagonal.

## Problema
Dado um número inteiro `n`, retorne o número de soluções distintas para o quebra-cabeça N-Queens.

### Exemplo 1:
![Exemplo 1](https://assets.leetcode.com/uploads/2020/11/13/queens.jpg)

- **Entrada**: `n = 4`
- **Saída**: `2`
- **Explicação**: Existem duas soluções distintas para o quebra-cabeça de 4 rainhas, como mostrado.

### Exemplo 2:
- **Entrada**: `n = 1`
- **Saída**: `1`

## Solução em Java

A solução usa **backtracking** para explorar todas as possibilidades de forma eficiente. Aqui está a implementação em Java:

```java
import java.util.*;
/*
 * Autor: eron arthur
 * Data: 2025-03-19
 * Descrição:
 * N-Rainhas II ou N-Queens II é um problema onde o objetivo é contar o número de soluções 
 * distintas para colocar n rainhas em um tabuleiro NxN, de forma que nenhuma rainha possa atacar outra.
 * Uma rainha pode atacar outra se estiver na mesma linha, coluna ou diagonal.
 */
public class Solution {
    public int totalNQueens(int n) {
        // Array para armazenar as colunas ocupadas
        int[] posicoes = new int[n];
        // inicia a contagem de soluções 
        return backtrack(posicoes, 0, n);
    }

    private int backtrack(int[] posicoes, int linha, int n) {
        // se todas as rainhas foram colocadas, retorna 1
        if (linha == n) {
            return 1;
        }
        int contagem = 0;
        // itera pelas colunas
        for (int coluna = 0; coluna < n; coluna++) {
            // verifica se a posição é válida
            if (isValid(posicoes, linha, coluna)) {
                // coloca a rainha na posição
                posicoes[linha] = coluna;
                // chama recursivamente para a próxima linha
                contagem += backtrack(posicoes, linha + 1, n);
            }
        }
        return contagem;
    }

    private boolean isValid(int[] posicoes, int linha, int coluna) {
        // verifica se a coluna já está ocupada
        for (int i = 0; i < linha; i++) {
            // verifica se a coluna já está ocupada ou se as diagonais estão ocupadas
            if (posicoes[i] == coluna || Math.abs(posicoes[i] - coluna) == Math.abs(i - linha)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Random random = new Random();
        int n = random.nextInt(15) + 1; // Gera um valor aleatório entre 1 e 15
        System.out.println("Número de soluções para " + n + " rainhas: " + sol.totalNQueens(n));
    }
}

##