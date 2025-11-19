
# Permutações Únicas com Duplicatas

## Descrição

Este projeto resolve o problema de gerar todas as permutações únicas de uma lista de números inteiros, onde a lista pode conter elementos duplicados. A solução utiliza a técnica de **backtracking** para gerar todas as permutações possíveis e evita gerar duplicatas de forma eficiente.

## Estratégia e Abordagem

A solução segue os seguintes passos:

1. **Ordenação Inicial do Array**
   - Ordenamos o array `nums` para facilitar a detecção de duplicatas. A ordenação ajuda a agrupar números iguais, permitindo ignorar combinações repetidas durante o processo de backtracking.

2. **Uso de Backtracking**
   - Utilizamos backtracking para explorar todas as possíveis permutações de uma lista. A cada etapa, o algoritmo tenta gerar uma nova permutação fazendo combinações recursivamente.

3. **Evitar Duplicatas**
   - Um array booleano `used` é usado para controlar quais números já foram incluídos na permutação atual. Além disso, uma verificação adicional é feita para garantir que números duplicados não sejam usados de forma redundante.

4. **Uso de Lista de Resultados**
   - Uma lista de listas (`result`) é usada para armazenar todas as permutações únicas geradas.

---

## Implementação em Java

```java
import java.util.*;

public class UniquePermutations {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Ordena o array para facilitar a detecção de duplicatas
        backtrack(nums, new ArrayList<>(), result, new boolean[nums.length]);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> tempList, List<List<Integer>> result, boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));  // Adiciona a permutação completa à lista de resultados
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Pula números já usados
            if (used[i]) continue;
            // Evita duplicatas: Se o número é igual ao anterior e o anterior não foi usado
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            tempList.add(nums[i]);

            // Chama recursivamente para continuar a construção da permutação
            backtrack(nums, tempList, result, used);

            // Desfaz a última escolha para tentar outra permutação
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        UniquePermutations solution = new UniquePermutations();
        
        int[] nums1 = {1, 1, 2};
        System.out.println("Permutações de [1, 1, 2]:");
        System.out.println(solution.permuteUnique(nums1));

        int[] nums2 = {1, 2, 3};
        System.out.println("Permutações de [1, 2, 3]:");
        System.out.println(solution.permuteUnique(nums2));
    }
}
```

---

## Explicação do Código

### 1. Método `permuteUnique`

- **Entrada**: Recebe um array de inteiros `nums` que pode conter duplicatas.
- **Saída**: Retorna uma lista de listas contendo todas as permutações únicas de `nums`.
- **Ordenação**: O array `nums` é ordenado antes de chamar o método `backtrack`.

```java
Arrays.sort(nums);
backtrack(nums, new ArrayList<>(), result, new boolean[nums.length]);
```

### 2. Método `backtrack`

Este é o núcleo da solução. Ele gera todas as permutações possíveis usando uma abordagem recursiva.

**Parâmetros**:
- `nums`: O array original de números.
- `tempList`: Lista temporária usada para armazenar a permutação atual.
- `result`: Lista que contém todas as permutações únicas.
- `used`: Array booleano que indica se um número foi usado na permutação atual.

**Fluxo do método**:
- Verifica se `tempList` tem o mesmo tamanho que `nums`. Se sim, adiciona a permutação à lista `result`.
- Itera por cada número em `nums`:
  - Se o número já foi usado, pula para o próximo.
  - Se um número é igual ao anterior e o anterior não foi usado, pula para evitar duplicatas.

```java
if (used[i]) continue;
if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
```

### 3. Exemplo de Uso

```java
int[] nums1 = {1, 1, 2};
System.out.println(solution.permuteUnique(nums1)); // Saída: [[1, 1, 2], [1, 2, 1], [2, 1, 1]]

int[] nums2 = {1, 2, 3};
System.out.println(solution.permuteUnique(nums2)); // Saída: [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
```

---

## Complexidade

- **Tempo**: A complexidade é aproximadamente `O(n! * n)`, onde `n` é o tamanho do array.
- **Espaço**: A complexidade de espaço é `O(n! * n)` devido ao armazenamento das permutações e ao uso do array `used`.

---

## Executando o Código

Certifique-se de ter o Java instalado e compile o código com:

```bash
javac UniquePermutations.java
```

Em seguida, execute-o:

```bash
java UniquePermutations
```

---

## Licença

Este projeto é distribuído sob a licença MIT.
