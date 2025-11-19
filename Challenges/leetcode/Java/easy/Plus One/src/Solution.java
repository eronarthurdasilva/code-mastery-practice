import java.io.*;

class Solution {
    public int[] plusOne(int[] digits) {
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

    // Método auxiliar para imprimir o resultado
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
}
