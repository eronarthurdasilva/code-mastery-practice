# Minimum Path Sum

## Descrição do Problema
Dado uma grade `m x n` preenchida com números não negativos, encontre um caminho do canto superior esquerdo para o canto inferior direito que minimize a soma de todos os números ao longo do caminho.

Você só pode mover para baixo ou para a direita a qualquer momento.

### Exemplo 1:
```plaintext
Entrada: grid = [[1,3,1],[1,5,1],[4,2,1]]
Saída: 7
Explicação: O caminho 1 → 3 → 1 → 1 → 1 minimiza a soma.
```

### Exemplo 2:
```plaintext
Entrada: grid = [[1,2,3],[4,5,6]]
Saída: 12
```

## Solução 1: Programação Dinâmica com Matriz Auxiliar
### Estratégia Utilizada
A abordagem utiliza programação dinâmica para calcular o caminho mínimo até cada célula da grade. Criamos uma matriz `dp` onde `dp[i][j]` armazena o custo mínimo para alcançar aquela posição.

### Código
```java
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];
        
        // Preenche a primeira linha
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        
        // Preenche a primeira coluna
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        
        // Preenche o restante da matriz
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        
        return dp[m - 1][n - 1];
    }
}
```

### Complexidade
- **Tempo**: `O(m * n)`, pois percorremos toda a matriz uma única vez.
- **Espaço**: `O(m * n)`, devido à matriz auxiliar `dp`.

## Solução 2: Programação Dinâmica com Otimização de Espaço
### Estratégia Utilizada
A matriz `dp` pode ser otimizada para usar apenas um array de tamanho `n` (número de colunas), pois a cada iteração, precisamos apenas das informações da linha anterior e da célula anterior.

### Código
```java
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        
        dp[0] = grid[0][0];
        
        // Preenche a primeira linha
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }
        
        // Preenche as demais linhas
        for (int i = 1; i < m; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }
        
        return dp[n - 1];
    }
}
```

### Complexidade
- **Tempo**: `O(m * n)`, pois percorremos toda a matriz.
- **Espaço**: `O(n)`, pois utilizamos apenas um array de tamanho `n`, reduzindo significativamente o uso de memória.

## Comparação das Soluções
| Solução | Tempo | Espaço |
|---------|--------|--------|
| Matriz Auxiliar (`dp[m][n]`) | `O(m * n)` | `O(m * n)` |
| Otimização de Espaço (`dp[n]`) | `O(m * n)` | `O(n)` |

A segunda abordagem é preferível para grandes valores de `m` e `n`, pois reduz o uso de memória sem comprometer o desempenho.

## Como Rodar o Código
Para testar as soluções, utilize o seguinte código no `main`:
```java
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println("Resultado: " + solution.minPathSum(grid));
    }
}
```

## Conclusão
O problema do caminho mínimo pode ser resolvido eficientemente com programação dinâmica. A solução otimizada reduz o uso de memória, mantendo a mesma eficiência de tempo.
