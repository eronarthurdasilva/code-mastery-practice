class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Inicializa a primeira coluna (só pode vir de cima)
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        // Inicializa a primeira linha (só pode vir da esquerda)
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        // Preenche a matriz reutilizando os valores do próprio grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[m - 1][n - 1]; // Retorna a menor soma do caminho
    }

    public static void main(String[] args) {
        // Matriz predefinida para testes
        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };

        // Criar objeto e calcular o menor caminho
        Solution solution = new Solution();
        int result = solution.minPathSum(grid);

        // Exibir o resultado
        System.out.println("A menor soma de caminho é: " + result);
    }
}
