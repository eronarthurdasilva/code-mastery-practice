#include <vector>
#include <set>
#include <algorithm>
using namespace std;

class Solution {
public:
    /*
     * Problema: LeetCode 1878 - Get Biggest Three Rhombus Sums in a Grid
     *
     * Abordagem: Força bruta com enumeração geométrica
     *   - Para cada célula (tr, tc) como vértice superior do rombo
     *   - Para cada tamanho l (0 = célula única, 1 = 4 células, etc.)
     *   - Soma os 4 lados do rombo percorrendo os vértices intermediários
     *
     * Complexidade de Tempo:  O(m * n * min(m,n)²) no pior caso
     * Complexidade de Espaço: O(m * n * min(m,n)) para armazenar as somas
     *
     * Restrições: m, n ≤ 50 → solução viável
     */
    vector<int> getBiggestThree(vector<vector<int>>& grid) {
        const int m = grid.size();
        const int n = grid[0].size();

        // Usamos set para deduplicação automática e manter ordenação
        set<int> uniqueSums;

        // l = "raio" do rombo (0 = ponto único, l = distância do topo ao meio)
        const int maxRadius = min(m - 1, n - 1) / 2;

        for (int l = 0; l <= maxRadius; ++l) {
            // tr = linha do vértice superior do rombo
            for (int tr = 0; tr + 2 * l < m; ++tr) {
                // tc = coluna do vértice superior (deve ter espaço l para cada lado)
                for (int tc = l; tc + l < n; ++tc) {

                    uniqueSums.insert(computeRhombusSum(grid, tr, tc, l));
                }
            }
        }

        // Extrai os 3 maiores valores (set ordenado crescente → iteramos do fim)
        vector<int> result;
        result.reserve(3);

        for (auto it = uniqueSums.rbegin();
             it != uniqueSums.rend() && result.size() < 3;
             ++it) {
            result.push_back(*it);
        }

        return result;
    }

private:
    /*
     * Calcula a soma do rombo de raio `l` com vértice superior em (tr, tc)
     *
     * Geometria do rombo (l=2):
     *
     *        (tr,   tc)          <- vértice superior
     *       /          \
     *  (tr+1,tc-1)  (tr+1,tc+1)  <- lados sup-esq / sup-dir
     *     /                \
     * (tr+2,tc-2)      (tr+2,tc+2) <- vértice esquerdo / direito
     *     \                /
     *  (tr+3,tc-1)  (tr+3,tc+1)  <- lados inf-esq / inf-dir
     *       \          /
     *        (tr+4, tc)           <- vértice inferior
     */
    int computeRhombusSum(const vector<vector<int>>& grid,
                          int tr, int tc, int l) {
        // Caso base: rombo de raio 0 é uma célula única
        if (l == 0) return grid[tr][tc];

        int sum = 0;

        // Soma os 4 vértices cardinais
        sum += grid[tr][tc];                 // topo
        sum += grid[tr + l][tc - l];         // esquerdo
        sum += grid[tr + 2 * l][tc];         // base
        sum += grid[tr + l][tc + l];         // direito

        // Soma as arestas (células entre os vértices, excluindo os próprios vértices)
        for (int i = 1; i < l; ++i) {
            sum += grid[tr + i][tc - i];           // aresta superior-esquerda ↙
            sum += grid[tr + i][tc + i];           // aresta superior-direita  ↘
            sum += grid[tr + l + i][tc - l + i];   // aresta inferior-esquerda ↗
            sum += grid[tr + l + i][tc + l - i];   // aresta inferior-direita  ↖  ← BUG CORRIGIDO
        }

        return sum;
    }
};