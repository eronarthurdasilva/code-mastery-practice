/*
 * Descrição da Atvidade:
 * O problema consiste em gerar as primeiras numRows linhas do Triângulo de Pascal. 
 * O Triângulo de Pascal é uma estrutura matemática onde cada número é a soma dos dois números diretamente acima dele. 
 * As bordas do triângulo são sempre compostas por 1.
 */

import java.util.ArrayList;
import java.util.List;

class Solution{
    public List<List<Integer>> generate(int numRows) {
        //Cria uma lista de listas para armazenar o triângulo
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        //Se o número de linhas for 0, retorna o triângulo vazio
        if(numRows == 0) return triangle;
        //Cria a primeira linha do triângulo
        List<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(1);//Adiciona o 1 na primeira linha
        triangle.add(firstRow);//Adiciona a primeira linha no triângulo
        //Percorre as linhas do triângulo
        for(int i = 1; i < numRows; i++){
            //Pega a linha anterior
            List<Integer> prevRow = triangle.get(i - 1);
            //Cria uma nova linha
            List<Integer> row = new ArrayList<Integer>();
           //Adiciona o 1 na borda esquerda da linha 
            row.add(1);
            //Percorre a linha anterior e adiciona os valores na nova linha
            for(int j = 1; j < i; j++){
                //Adiciona o valor na nova linha
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            //Adiciona o 1 na borda direita da linha
            row.add(1);
            //Adiciona a linha no triângulo
            triangle.add(row);
        }
        //Retorna o triângulo
        return triangle;
    }
    public static void main(String[] args) {
        /*
         * Teste da função generate
         * Cria um objeto da classe Solution
         * Chama a função generate passando o valor 5
         * Chama a função generate passando o valor 3
         * Depois com um for each, percorre as linhas do triângulo e imprime cada linha
         * 
         */
        Solution solution = new Solution();
        List<List<Integer>> triangle = solution.generate(5);
        List<List<Integer>> triagleList = solution.generate(3);

        System.out.println("Valor de um triângulo de Pascal de tamanho 5: ");
        for(List<Integer> row : triangle){
           
            System.out.println(row);
        }
        System.out.println("Valor de um triângulo de Pascal de tamanho 3: ");
        for(List<Integer> row : triagleList){
            System.out.println(row);
        }
    }
}