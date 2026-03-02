#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int minSwaps(vector<vector<int>>& grid) {
        int n = grid.size();
        vector<int> trailingZeros(n);

        // 1. Pré-processamento: contar zeros à direita
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) count++;
                else break;
            }
            trailingZeros[i] = count;
        }

        int swaps = 0;
        // 2. Tentar encaixar a melhor linha em cada posição i
        for (int i = 0; i < n; i++) {
            int target = n - 1 - i; // Quantos zeros a linha i precisa ter
            int found = -1;

            // Busca a primeira linha que atende ao requisito
            for (int j = i; j < n; j++) {
                if (trailingZeros[j] >= target) {
                    found = j;
                    break;
                }
            }

            if (found == -1) return -1; // Não há linha disponível

            // "Puxa" a linha para cima e conta os passos
            for (int k = found; k > i; k--) {
                swap(trailingZeros[k], trailingZeros[k - 1]);
                swaps++;
            }
        }
        return swaps;
    }
};

// --- ALGORITMO DE TESTE ---
void rodarTeste(vector<vector<int>> grid, int esperado) {
    Solution sol;
    int resultado = sol.minSwaps(grid);
    
    cout << "Grade: ";
    if (resultado == esperado) {
        cout << "[SUCESSO] ";
    } else {
        cout << "[FALHA] ";
    }
    cout << "Resultado: " << resultado << " | Esperado: " << esperado << endl;
}

int main() {
    // Exemplo 1: Precisa de 3 trocas
    rodarTeste({{0,0,1}, {1,1,0}, {1,0,0}}, 3);

    // Exemplo 2: Impossível (-1)
    rodarTeste({{0,1,1,0}, {0,1,1,0}, {0,1,1,0}, {0,1,1,0}}, -1);

    // Exemplo 3: Já está correta (0 trocas)
    rodarTeste({{1,0,0}, {1,1,0}, {1,1,1}}, 0);

    return 0;
}