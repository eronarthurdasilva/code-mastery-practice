# Trapping Rain Water (Leetcode 42)

## Desafio
Dado um array `height` de números inteiros não-negativos representando um mapa de elevação onde a largura de cada barra é 1, o desafio é calcular a quantidade total de água que pode ser acumulada após a chuva.

### Exemplo
Para o array `height = [0,1,0,2,1,0,1,3,2,1,2,1]`, a saída deve ser `6`, representando a quantidade de unidades de água acumuladas.

### Explicação Visual
O mapa de elevação pode ser visualizado da seguinte maneira, onde as barras pretas representam as elevações e as áreas azuis representam a água acumulada:

     *
      *
    * **
    ****
    *****


Neste exemplo, 6 unidades de água são acumuladas nas depressões entre as elevações.

## Solução

### Intuição
A quantidade de água acumulada em cada posição `i` depende das alturas das "paredes" à sua esquerda e à sua direita. Para que haja água em uma posição, é necessário que exista uma parede mais alta tanto à esquerda quanto à direita dessa posição. A quantidade de água acumulada será limitada pela menor dessas duas alturas.

### Abordagem
#### Construir Arrays Auxiliares:
Construímos dois arrays auxiliares:
- `leftMax[i]`: armazena a altura máxima encontrada da posição inicial até a posição `i`.
- `rightMax[i]`: armazena a altura máxima encontrada da posição final até a posição `i`.

#### Calcular a Água Acumulada:
Para cada posição `i`, a água acumulada será dada pela diferença entre a menor altura das paredes à esquerda e à direita e a altura atual `height[i]` (se essa diferença for positiva).

water[i] = max(0, min(leftMax[i], rightMax[i]) - height[i])


#### Somar os Volumes de Água:
Somamos o volume de água em cada posição para obter o total.

### Complexidade
- **Complexidade de Tempo**: O(n)  
Construímos os arrays `leftMax` e `rightMax` com uma única passagem pelo array `height`, e somamos os volumes de água em uma outra passagem. A complexidade total é linear.

- **Complexidade de Espaço**: O(n)  
Precisamos dos arrays auxiliares `leftMax` e `rightMax`, então o espaço utilizado também é linear.

## Implementação
Aqui está a implementação em Java:

```java
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int waterTrapped = 0;

        // Construir o array leftMax
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Construir o array rightMax
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // Calcular a água acumulada
        for (int i = 0; i < n; i++) {
            waterTrapped += Math.max(0, Math.min(leftMax[i], rightMax[i]) - height[i]);
        }

        return waterTrapped;
    }
}
````

## Exemplo de uso
```java
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = solution.trap(height);
        System.out.println("Quantidade de água acumulada: " + result);
    }
}
