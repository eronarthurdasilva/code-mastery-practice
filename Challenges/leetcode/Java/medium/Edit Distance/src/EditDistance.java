/*
 * O problema do Edit Distance é um problema que pede o número de operações
 * (inserção, remoção e substituição) para transformr word1 em word2.
 * A solução mais eficiente é usar programação dinâmica (DP)
 */

import java.util.*;
public class EditDistance {


    /*
     * Definição da DP:
     * dp[i][j] = número de operações para transformar word1[0..i] em word2[0..j]
     * Caso base:
     * Se word1 for vazio (i == 0), a única opção é inserir todos os caracteres de word2, então dp[0][j] = j
     * Se word2 for vazio (j == 0), a única opção é remover todos os caracteres de word1, então dp[i][0] = i
     * Passo de transição:
     * Se word1[i] == word2[j], não é necessário fazer nenhuma operação, então dp[i][j] = dp[i-1][j-1]
     * Caso contrário, temos 3 opções:
     * 1. Inserir word2[j] após word1[0..i-1], então dp[i][j] = dp[i][j-1] + 1
     * 2. Remover word1[i], então dp[i][j] = dp[i-1][j] + 1
     * 3. Substituir word1[i] por word2[j], então dp[i][j] = dp[i-1][j-1] + 1
     */
    public int minDistance(String word1, String word2){
        int m = word1.length();
        int n = word2.length();
        
        // Criamos a matriz de DP (tamanho (m+1) x (n+1))
        int[][] dp = new int[m + 1][n + 1];

        // Caso base: transformar uma string vazia na outra
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // Deletar todos os caracteres de word1
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // Inserir todos os caracteres de word2
        }

        // Preenchendo a tabela de DP
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // Se os caracteres são iguais, herda o valor sem custo extra
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Se os caracteres são diferentes, pega a melhor opção (menor custo)
                    dp[i][j] = 1 + Math.min(
                        dp[i - 1][j],     // Remover (delete)
                        Math.min(
                            dp[i][j - 1], // Inserir (insert)
                            dp[i - 1][j - 1] // Substituir (replace)
                        )
                    );
                }
            }
        }

        // O resultado final está em dp[m][n]
        return dp[m][n];
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Entrada do usuário
        System.out.print("Digite a primeira palavra: ");
        String word1 = scanner.nextLine();

        System.out.print("Digite a segunda palavra: ");
        String word2 = scanner.nextLine();

        // Criando objeto da classe Solution
        EditDistance solution = new EditDistance();
        
        // Calculando e exibindo o resultado
        int result = solution.minDistance(word1, word2);
        System.out.println("Mínimo de operações necessárias: " + result);

        // Fechar scanner
        scanner.close();
    }
}
