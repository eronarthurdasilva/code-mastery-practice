/*
 * Busca de Palavra em uma Grade
    Você recebe uma grade m x n de caracteres (board) e uma string word. Seu objetivo é verificar se a palavra word existe na grade.
    A palavra pode ser formada por letras de células adjacentes sequencialmente, onde células adjacentes são vizinhas horizontal ou verticalmente.
    uma mesma célula não pode ser usada mais de uma vez.
 */
import java.util.*;


public class Solution{

    /*
     * Método que verifica se a palavra existe na grade
     */
    public static boolean existe(char[][] grade, String palavra) {
        //verifica se a grade e maior que que o total de celulas
        if(palavra.length() > grade.length * grade[0].length) return false;
        //percorre todas as células da grade
        for(int linha = 0;  linha < grade.length; linha++){
            for(int coluna = 0; coluna < grade[0].length; coluna++){
                //verifica se a palavra existe a partir da célula atual
                if(buscar(grade, coluna, linha, palavra, 0)) return true;
            }
        }
        return false;
    }

    /*
     * Função recursiva de backtracking que verifica se a palavra existe a partir de uma célula
     * Funcionalidade do backtracking:
     * 1. Verifica se a célula atual é válida
     * 2. Marca a célula atual como visitada
     * 3. Verifica se a palavra é encontrada a partir da célula atual
     * 4. Desmarca a célula atual
     */
    private static boolean buscar(char[][] grade, int linha, int coluna,String palavra, int indice){
        //caso base: se a palavra foi encontrada
        if(indice == palavra.length()) return true;
        //verifica se a célula atual é válida
        if(linha < 0 || linha >= grade.length || coluna < 0 || coluna >= grade[0].length || grade[linha][coluna] != palavra.charAt(indice)) return false;
        //verifica se a letra atual não coincide
        if(grade[linha][coluna] != palavra.charAt(indice)) return false;
        //marca a célula atual como visitada
        char letraOriginal = grade[linha][coluna];
        grade[linha][coluna] = '#';

        //explora as 4 direções possiveis
        boolean achou = buscar(grade, linha + 1, coluna, palavra, indice + 1) ||
                        buscar(grade, linha - 1, coluna, palavra, indice + 1) ||
                        buscar(grade, linha, coluna + 1, palavra, indice + 1) ||
                        buscar(grade, linha, coluna - 1, palavra, indice + 1);
        //desmarca a célula atual
        grade[linha][coluna] = letraOriginal;
        return achou;
    }
    


    public static void main(String[] args) throws Exception {
        // Exemplo de uso
        char[][] grade = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        
        String palavra1 = "ABCCED";
        System.out.println(existe(grade, palavra1)); // Deve retornar true
        
        String palavra2 = "ABCB";
        System.out.println(existe(grade, palavra2)); // Deve retornar false
    }
}
