# Problema 66 Leetcode
### Incrementando um Número Grande Representado como um Array

Você recebe um grande número representado como um array de inteiros `digits`, onde cada `digits[i]` é o i-ésimo dígito do número. Os dígitos estão ordenados do mais significativo para o menos significativo na ordem da esquerda para a direita. O grande número não contém zeros à esquerda.

## Objetivo

Incrementar o grande número em um e retornar o array resultante de dígitos.

## Exemplos

### Exemplo 1

- **Entrada:** `digits = [1, 2, 3]`
- **Saída:** `[1, 2, 4]`
- **Explicação:** O array representa o número 123. Incrementando em um, obtemos 123 + 1 = 124. Assim, o resultado deve ser `[1, 2, 4]`.

### Exemplo 2

- **Entrada:** `digits = [4, 3, 2, 1]`
- **Saída:** `[4, 3, 2, 2]`
- **Explicação:** O array representa o número 4321. Incrementando em um, obtemos 4321 + 1 = 4322. Assim, o resultado deve ser `[4, 3, 2, 2]`.

### Exemplo 3

- **Entrada:** `digits = [9]`
- **Saída:** `[1, 0]`
- **Explicação:** O array representa o número 9. Incrementando em um, obtemos 9 + 1 = 10. Assim, o resultado deve ser `[1, 0]`.

## Restrições

- `1 <= digits.length <= 100`
- `0 <= digits[i] <= 9`
- `digits` não contém zeros à esquerda. ```markdown


## Solução 
O código implementado para solucionar esse desafio e simples, pecorre a array digits de trás para frente (do último digito para o primeiro), incrementa em +1 se o atual número for menor que 9. Caso todos os dígitos forem 9 (exemplo [9,9,9]), o método array result com um tamanho maior e definido, retornando [1, 0, 0, 0].

## Método main
```java
public static void main(String[] args) {
    Solution solution = new Solution();

    // Casos de teste
    int[] test1 = {1, 2, 3}; // Entrada: [1, 2, 3] -> Saída esperada: [1, 2, 4]
    int[] test2 = {4, 3, 2, 1}; // Entrada: [4, 3, 2, 1] -> Saída esperada: [4, 3, 2, 2]
    int[] test3 = {9}; // Entrada: [9] -> Saída esperada: [1, 0]
    int[] test4 = {9, 9, 9}; // Entrada: [9, 9, 9] -> Saída esperada: [1, 0, 0, 0]

    // Chamando o método e exibindo os resultados
    printResult(test1, solution.plusOne(test1));
    printResult(test2, solution.plusOne(test2));
    printResult(test3, solution.plusOne(test3));
    printResult(test4, solution.plusOne(test4));
}
```
## Método auxiliar printResult
```java
private static void printResult(int[] input, int[] output) {
    System.out.print("Entrada: [");
    for (int i = 0; i < input.length; i++) {
        System.out.print(input[i] + (i < input.length - 1 ? ", " : ""));
    }
    System.out.print("] -> Saída: [");
    for (int i = 0; i < output.length; i++) {
        System.out.print(output[i] + (i < output.length - 1 ? ", " : ""));
    }
    System.out.println("]");
}
```
Funcionamento simples: Imprime a entrada e a saíada do método plusOne no formato, facilitando a visulaização dos resultados

## Método plusOne
```java
public int[] plusOne(int[] digits) {SS
    // Percorremos os dígitos de trás para frente
    for (int i = digits.length - 1; i >= 0; i--) {
        if (digits[i] < 9) { 
            // Se o dígito atual for menor que 9, incrementamos ele e retornamos o array
            digits[i]++;
            return digits;
        }
        // Caso contrário, tornamos o dígito atual 0
        digits[i] = 0;
    }

    // Se todos os dígitos forem 9, precisamos criar um novo array
    int[] result = new int[digits.length + 1];
    result[0] = 1; // O primeiro dígito será 1
    return result; // Os demais permanecerão 0 por padrão
}
```
### Explicação do codigo 
- O método plusOne recebe um array de inteiros representando os dígitos de um número;
- Percorre os dígitos de trás para frente;
- Se encontrar um dígito menor que 9, incrementa-o e retorna o array atualizada;
