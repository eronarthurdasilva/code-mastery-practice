# Maximum Running Time of N Computers - Solução Completa

## 📋 Visão Geral do Problema

Dado um array de `n` baterias com capacidades diferentes e `n` computadores, determine o tempo máximo que todos os computadores podem funcionar simultaneamente. Cada computador consome 1 unidade de bateria por minuto.

---

## 🎯 Estratégia de Solução

### Abordagem: Binary Search + Greedy Validation

A solução utiliza **busca binária** para encontrar o tempo máximo viável, combinada com uma **estratégia gulosa (greedy)** para validar se um determinado tempo é alcançável.

#### Intuição
- O tempo máximo possível está entre 0 e a soma total de todas as baterias
- Se conseguimos executar por `t` minutos, podemos validar isso de forma eficiente
- Usamos busca binária para otimizar a busca pelo melhor tempo

---

## 🔍 Análise de Complexidade

### Complexidade de Tempo
- **O(n log S)**, onde `n` é o número de computadores e `S` é a soma total das capacidades das baterias
  - Binary Search: **O(log S)** iterações
  - Cada validação: **O(n)** para verificar se é possível atingir o tempo `t`

### Complexidade de Espacial
- **O(1)** - apenas variáveis auxiliares são utilizadas

---

## 💡 Algoritmo Passo a Passo

### 1. Definir limites de busca binária
```
left = 0
right = sum(batteries) / n
```

### 2. Para cada tempo candidato `mid`
```
Verificar se é possível todos os computadores rodarem por `mid` minutos
```

### 3. Validação Greedy
```
Para cada bateria:
  - Alocar o máximo possível: min(capacidade, tempo_necessário)
  - Subtrair do tempo necessário
```

### 4. Ajustar limites
```
Se viável: left = mid + 1
Se não viável: right = mid - 1
```

---

## 📝 Implementação

````java
// filepath: c:\Users\erona\OneDrive\Área de Trabalho\Projetos\Repositorios do GitHub\code-mastery-practice\code-mastery-practice\Challenges\leetcode\Java\Maximum Running Time of N Computers\src\Solution.java

public class Solution {
    public long maximumRuntime(int[] batteries, int n) {
        long left = 0;
        long right = 0;
        
        // Calcular soma total das baterias
        for (int battery : batteries) {
            right += battery;
        }
        
        // Dividir pelo número de computadores
        right /= n;
        
        long result = 0;
        
        // Binary Search
        while (left <= right) {
            long mid = left + (right - left) / 2;
            
            // Verificar se é possível rodar por 'mid' minutos
            if (canRunForTime(batteries, n, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    /**
     * Valida se é possível todos os computadores rodarem por 'time' minutos
     * usando a estratégia greedy
     */
    private boolean canRunForTime(int[] batteries, int n, long time) {
        long totalNeeded = (long) n * time;
        long totalAvailable = 0;
        
        for (int battery : batteries) {
            // Usar no máximo 'time' de cada bateria
            totalAvailable += Math.min(battery, time);
        }
        
        return totalAvailable >= totalNeeded;
    }
}