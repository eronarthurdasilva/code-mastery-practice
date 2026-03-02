## Problema # Minimum Swaps to Arrange a Binary Grid

> Resolução do problema “Minimum Swaps to Arrange a Binary Grid” (LeetCode 1536)
> com implementação em C++ e explicação detalhada.

---

## 📌 Descrição do Problema

Dada uma matriz quadrada `grid` de dimensões `n x n` composta apenas por `0`s e `1`s, queremos rearranjar as linhas da grade através de *swaps* adjacentes de modo que, para cada linha `i` (0‑indexada), existam pelo menos `n‑i‑1` zeros à direita. Ou seja, a primeira linha deve terminar com pelo menos `n‑1` zeros, a segunda com pelo menos `n‑2` zeros, e assim por diante.

Cada operação permite trocar duas linhas adjacentes. O objetivo é determinar o número mínimo de operações necessárias para atingir a condição acima. Se a ordenação for impossível, o retorno deve ser `‑1`.

### Restrições

- `1 <= n <= 50`
- `grid[i][j]` é `0` ou `1`.

---

## 🧠 Estratégia de Resolução

A solução explora uma pré‑processamento e um processo guloso de “puxar” linhas adequadas para cada posição, evitando reconstruções completas da matriz:

1. **Contar zeros à direita**  
   Para cada linha `i`, calcule quantos zeros consecutivos existem a partir da última coluna. Armazene esses valores num vetor `trailingZeros`.

2. **Posicionar linha por linha**  
   Para a posição `i` (linha alvo), o requisito de zeros é `n - 1 - i`. Procure, a partir da linha `i` para baixo, a primeira linha cujo `trailingZeros` seja ≥ requisito.

3. **Swaps adjacentes**  
   Se encontrada, “puxe” essa linha para a posição `i` trocando progressivamente com as linhas acima — cada troca aumenta o contador de operações. Atualize também o vetor `trailingZeros` para refletir a movimentação.

4. **Verificação de impossibilidade**  
   Se não existir nenhuma linha viável para uma determinada posição, retorne `‑1`.

Este procedimento garante a escolha ótima em cada etapa e tem complexidade linear em \(n^2\).

---

## ✅ Implementação em C++

```cpp
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int minSwaps(vector<vector<int>>& grid) {
        int n = grid.size();
        vector<int> trailingZeros(n);

        // 1. Pré‑processamento: contar zeros à direita
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) count++;
                else break;
            }
            trailingZeros[i] = count;
        }

        int swaps = 0;
        // 2. Para cada posição i, localizar a linha adequada
        for (int i = 0; i < n; i++) {
            int target = n - 1 - i; // zeros necessários
            int found = -1;

            for (int j = i; j < n; j++) {
                if (trailingZeros[j] >= target) {
                    found = j;
                    break;
                }
            }

            if (found == -1) return -1; // impossível

            // 3. Puxa a linha achada para cima
            for (int k = found; k > i; k--) {
                swap(trailingZeros[k], trailingZeros[k - 1]);
                swaps++;
            }
        }
        return swaps;
    }
};
```

> O código de teste (`main`) presente no repositório demonstra o uso e valida alguns casos.

---

## 📈 Complexidade

- **Tempo:** \(O(n^2)\) – a contagem inicial percorre todas as células e cada linha pode ser movida no máximo \(n\) posições.
- **Espaço:** \(O(n)\) – vetor auxiliar de contagem de zeros.

---

## 🧪 Exemplos

| Entrada                                     | Saída | Observação                                        |
|---------------------------------------------|-------|---------------------------------------------------|
| `[[0,0,1],[1,1,0],[1,0,0]]`                 | `3`   | São necessários 3 swaps                           |
| `[[0,1,1,0],[0,1,1,0],[0,1,1,0],[0,1,1,0]]` | `‑1`  | Impossível satisfazer os requisitos               |
| `[[1,0,0],[1,1,0],[1,1,1]]`                 | `0`   | Já está na ordem esperada                        |

---

## 📂 Como Compilar e Executar

1. Abra um terminal no diretório do arquivo `Solution.c++`.
2. Compile:

   ```sh
   g++ -std=c++17 -O2 Solution.c++ -o minswaps
   ```

3. Execute o binário:

   ```sh
   ./minswaps
   ```

O `main` inclusivo mostrará saídas de teste e o resultado esperado.

---

## 📚 Notas Finais

- A abordagem adotada é escalável para o limite máximo de \(n=50\).
- O design privilegia clareza e reutilização: a lógica principal está isolada na classe `Solution`.
- Pequenas variações do problema (por exemplo, contar zeros à esquerda) podem ser abordadas com ajustes mínimos na pré‑processamento.

---

> Este README faz parte do repositório **code‑mastery‑practice**, que organiza soluções de desafios online com foco em legibilidade, eficácia e documentação.
