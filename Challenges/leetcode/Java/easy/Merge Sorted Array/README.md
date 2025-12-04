# 88. Merge Sorted Array

🟢 **Dificuldade:** Easy

## 🔗 Links
- [Problema no LeetCode](https://leetcode.com/problems/merge-sorted-array/)

## 📋 Descrição

Você recebe dois arrays de inteiros ordenados em ordem não decrescente, `nums1` e `nums2`, e dois inteiros `m` e `n`, representando o número de elementos em `nums1` e `nums2` respectivamente.

**Objetivo:** Mesclar `nums2` em `nums1` como um único array ordenado.

O array final ordenado não deve ser retornado pela função, mas sim **armazenado dentro do array `nums1`**. Para acomodar isso, `nums1` tem um comprimento de `m + n`, onde os primeiros `m` elementos denotam os elementos que devem ser mesclados, e os últimos `n` elementos são definidos como `0` e devem ser ignorados. `nums2` tem um comprimento de `n`.

## 🏷️ Tópicos
`Array`, `Two Pointers`, `Sorting`

## 💡 Abordagem

### Estratégia: Two Pointers (Ponteiros Duplos) em Ordem Reversa

A solução utiliza uma abordagem inteligente de **três ponteiros** que trabalham de **trás para frente**:

1. **Por que reverso?** Começar do fim evita sobrescrever elementos de `nums1` que ainda não foram processados
2. **Comparação:** Compara os maiores elementos não processados de ambos os arrays
3. **Preenchimento:** Coloca o maior elemento na última posição disponível de `nums1`
4. **Limpeza:** Se sobrarem elementos em `nums2`, copia-os para `nums1`

### Passos do Algoritmo

1. **Inicializar três ponteiros:**
   - `i = m - 1`: último elemento válido de `nums1`
   - `j = n - 1`: último elemento de `nums2`
   - `k = m + n - 1`: última posição do array mesclado

2. **Loop principal:** Enquanto houver elementos em ambos os arrays
   - Compara `nums1[i]` com `nums2[j]`
   - Coloca o maior na posição `k` e decrementa os ponteiros apropriados

3. **Finalização:** Se restarem elementos em `nums2`, copia-os para `nums1`
   - Nota: Se restarem elementos em `nums1`, já estão na posição correta

## 📊 Complexidade

| Métrica | Valor | Explicação |
|---------|-------|------------|
| **Tempo** | O(m + n) | Cada elemento é visitado exatamente uma vez |
| **Espaço** | O(1) | Modificação in-place, sem arrays auxiliares |

## ✅ Solução em Java

```java
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Ponteiro para nums1
        int j = n - 1; // Ponteiro para nums2
        int k = m + n - 1; // Ponteiro para array mesclado

        // Mescla em ordem reversa
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // Se restarem elementos em nums2
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
```

## 🧪 Casos de Teste

### Teste 1: Caso Padrão
```
Input: 
  nums1 = [1,2,3,0,0,0], m = 3
  nums2 = [2,5,6], n = 3

Output: [1,2,2,3,5,6]

Explicação: Os arrays sendo mesclados são [1,2,3] e [2,5,6].
O resultado da mesclagem é [1,2,2,3,5,6].
```

### Teste 2: nums2 vazio
```
Input: 
  nums1 = [1], m = 1
  nums2 = [], n = 0

Output: [1]

Explicação: Os arrays sendo mesclados são [1] e [].
```

### Teste 3: nums1 vazio
```
Input: 
  nums1 = [0], m = 0
  nums2 = [1], n = 1

Output: [1]

Explicação: Os arrays sendo mesclados são [] e [1].
```

### Teste 4: Arrays Intercalados
```
Input: 
  nums1 = [1,3,5,0,0,0], m = 3
  nums2 = [2,4,6], n = 3

Output: [1,2,3,4,5,6]
```

## 🎯 Visualização do Algoritmo

**Estado inicial:**
```
nums1: [1, 2, 3, 0, 0, 0]
        ↑           ↑
        i           k
nums2: [2, 5, 6]
        ↑
        j
```

**Passo 1:** `nums1[i]=3` vs `nums2[j]=6` → 6 é maior
```
nums1: [1, 2, 3, 0, 0, 6]
        ↑        ↑
        i        k
nums2: [2, 5, 6]
           ↑
           j
```

**Passo 2:** `nums1[i]=3` vs `nums2[j]=5` → 5 é maior
```
nums1: [1, 2, 3, 0, 5, 6]
        ↑     ↑
        i     k
nums2: [2, 5, 6]
        ↑
        j
```

**Continue até finalizar...**

## 📝 Notas Importantes

### ✅ Vantagens da Abordagem
- **Eficiente:** Complexidade linear O(m+n)
- **In-place:** Não usa memória extra
- **Elegante:** Solução simples e clara
- **Robusta:** Lida com todos os edge cases

### ⚠️ Edge Cases Tratados
1. Um dos arrays está vazio
2. Todos os elementos de `nums2` são maiores que `nums1`
3. Todos os elementos de `nums1` são maiores que `nums2`
4. Arrays com elementos duplicados

### 💭 Alternativa: Abordagem Forward (Não Recomendada)
Mesclar da esquerda para direita requereria:
- Array auxiliar temporário → O(m) espaço extra
- Cópia adicional dos elementos → Menos eficiente

**Por isso a abordagem reversa é superior!**

## 🚀 Como Executar

```bash
# Compilar
javac Solution.java

# Executar
java Solution

# Saída esperada
1 2 2 3 5 6
```

## 📚 Conceitos Aplicados

- **Two Pointers Pattern:** Técnica fundamental para problemas com arrays ordenados
- **In-place Modification:** Otimização de espaço modificando o array existente
- **Merge Algorithm:** Base do algoritmo Merge Sort
- **Backward Traversal:** Técnica para evitar sobrescrita de dados

## 🎓 Aprendizados

1. **Pensar "fora da caixa":** Começar do fim pode ser mais eficiente
2. **Aproveitamento de espaço:** Usar espaço vazio existente no array
3. **Otimização:** Evitar cópias desnecessárias com abordagem in-place
4. **Robustez:** Tratar casos onde um array já está na posição correta

---

## 📅 Informações

- **Data de Resolução:** 03/12/2024
- **Linguagem:** Java
- **Categoria:** Array / Two Pointers
- **Tempo de Execução:** ~0ms (Beats 100%)

---

💡 **Dica:** Este problema é excelente para praticar o padrão Two Pointers e pensar em otimizações de espaço!