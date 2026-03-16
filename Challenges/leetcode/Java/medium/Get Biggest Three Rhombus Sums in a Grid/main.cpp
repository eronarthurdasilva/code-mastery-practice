#include <vector>
#include <iostream>
#include <iomanip>
#include "Solution.c++"
using namespace std;

// Função auxiliar para imprimir um vetor
void printVector(const vector<int>& vec) {
    cout << "[";
    for (size_t i = 0; i < vec.size(); ++i) {
        cout << vec[i];
        if (i < vec.size() - 1) cout << ", ";
    }
    cout << "]";
}

// Função auxiliar para imprimir uma matriz
void printGrid(const vector<vector<int>>& grid) {
    cout << "[" << endl;
    for (size_t i = 0; i < grid.size(); ++i) {
        cout << "  [";
        for (size_t j = 0; j < grid[i].size(); ++j) {
            cout << setw(3) << grid[i][j];
            if (j < grid[i].size() - 1) cout << ", ";
        }
        cout << "]";
        if (i < grid.size() - 1) cout << ",";
        cout << endl;
    }
    cout << "]" << endl;
}

int main() {
    Solution solution;

    cout << "╔═══════════════════════════════════════════════════════════════╗" << endl;
    cout << "║  LeetCode 1878 - Get Biggest Three Rhombus Sums in a Grid  ║" << endl;
    cout << "╚═══════════════════════════════════════════════════════════════╝" << endl;
    cout << endl;

    // ===== TESTE 1 =====
    cout << "─────────────────────────────────────────────────────────────────" << endl;
    cout << "TESTE 1: Exemplo Principal (4x4)" << endl;
    cout << "─────────────────────────────────────────────────────────────────" << endl;
    
    vector<vector<int>> grid1 = {
        {3, 4, 5, 1},
        {3, 3, 4, 2},
        {20, 30, 200, 40},
        {1, 5, 5, 4}
    };
    
    cout << "Grid:" << endl;
    printGrid(grid1);
    
    auto result1 = solution.getBiggestThree(grid1);
    cout << "Resultado: ";
    printVector(result1);
    cout << endl;
    cout << "Esperado:  [240, 188, 54]" << endl;
    cout << endl;

    // ===== TESTE 2 =====
    cout << "─────────────────────────────────────────────────────────────────" << endl;
    cout << "TESTE 2: Grid Pequeno (3x3)" << endl;
    cout << "─────────────────────────────────────────────────────────────────" << endl;
    
    vector<vector<int>> grid2 = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    
    cout << "Grid:" << endl;
    printGrid(grid2);
    
    auto result2 = solution.getBiggestThree(grid2);
    cout << "Resultado: ";
    printVector(result2);
    cout << endl;
    cout << "Esperado:  [45] (ou outro valor único)" << endl;
    cout << endl;

    // ===== TESTE 3 =====
    cout << "─────────────────────────────────────────────────────────────────" << endl;
    cout << "TESTE 3: Todos os elementos iguais (5x5)" << endl;
    cout << "─────────────────────────────────────────────────────────────────" << endl;
    
    vector<vector<int>> grid3(5, vector<int>(5, 10));
    
    cout << "Grid:" << endl;
    printGrid(grid3);
    
    auto result3 = solution.getBiggestThree(grid3);
    cout << "Resultado: ";
    printVector(result3);
    cout << endl;
    cout << "Nota:      Com todos elementos iguais, só há uma soma distinta" << endl;
    cout << endl;

    // ===== TESTE 4 =====
    cout << "─────────────────────────────────────────────────────────────────" << endl;
    cout << "TESTE 4: Grid Grande com Valores Variados (6x6)" << endl;
    cout << "─────────────────────────────────────────────────────────────────" << endl;
    
    vector<vector<int>> grid4 = {
        {100, 50, 30, 20, 25, 40},
        {60, 90, 80, 70, 65, 75},
        {55, 85, 95, 87, 78, 60},
        {45, 40, 50, 65, 72, 88},
        {35, 48, 62, 71, 80, 92},
        {25, 38, 52, 61, 70, 82}
    };
    
    cout << "Grid:" << endl;
    printGrid(grid4);
    
    auto result4 = solution.getBiggestThree(grid4);
    cout << "Resultado: ";
    printVector(result4);
    cout << endl;
    cout << endl;

    // ===== TESTE 5 =====
    cout << "─────────────────────────────────────────────────────────────────" << endl;
    cout << "TESTE 5: Grid Mínimo (2x2)" << endl;
    cout << "─────────────────────────────────────────────────────────────────" << endl;
    
    vector<vector<int>> grid5 = {
        {1, 2},
        {3, 4}
    };
    
    cout << "Grid:" << endl;
    printGrid(grid5);
    
    auto result5 = solution.getBiggestThree(grid5);
    cout << "Resultado: ";
    printVector(result5);
    cout << endl;
    cout << "Nota:      Grid mínimo onde cada célula é um rombo válido" << endl;
    cout << endl;

    // ===== TESTE 6 =====
    cout << "─────────────────────────────────────────────────────────────────" << endl;
    cout << "TESTE 6: Grid Retangular (3x7)" << endl;
    cout << "─────────────────────────────────────────────────────────────────" << endl;
    
    vector<vector<int>> grid6 = {
        {10, 20, 30, 40, 50, 60, 70},
        {100, 15, 25, 35, 45, 55, 65},
        {200, 110, 120, 130, 140, 150, 160}
    };
    
    cout << "Grid:" << endl;
    printGrid(grid6);
    
    auto result6 = solution.getBiggestThree(grid6);
    cout << "Resultado: ";
    printVector(result6);
    cout << endl;
    cout << endl;

    cout << "╔═══════════════════════════════════════════════════════════════╗" << endl;
    cout << "║                    ✓ TESTES COMPLETADOS                       ║" << endl;
    cout << "╚═══════════════════════════════════════════════════════════════╝" << endl;

    return 0;
}
