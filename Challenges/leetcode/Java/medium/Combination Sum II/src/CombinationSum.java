import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * é um problema clássico de combinação, onde o objetivo é encontrar todas as combinações únicas de números que somam a um valor-alvo (target). 
 * Para resolver o problema, vamos seguir uma abordagem baseada em backtracking, que é eficiente para lidar com problemas de busca em árvores de possibilidades.
 */
class combinationSum{
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Lista para armazenar todas as combinações válidas
        List<List<Integer>> result = new ArrayList<>();
        // Ordenar os candidatos para facilitar a remoção de duplicatas
        Arrays.sort(candidates);
        // Chamar a função de backtracking
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result){
        // Caso base: se o alvo for 0, adicionamos a combinação atual ao resultado
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        // Percorrer os candidatos a partir da posição "start"
        for (int i = start; i < candidates.length; i++) {
            // Ignorar duplicatas: se o candidato atual é igual ao anterior, pule
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            // Se o candidato for maior que o alvo, não há mais combinações válidas
            if (candidates[i] > target) break;

            // Escolher o candidato atual
            current.add(candidates[i]);

            // Chamar a recursão com o próximo índice e o novo alvo reduzido
            backtrack(candidates, target - candidates[i], i + 1, current, result);

            // Retroceder (remover o último candidato para explorar outras combinações)
            current.remove(current.size() - 1);
        }
    }
    public static void main(String[] args) {
        combinationSum cs = new combinationSum();
        int[] candidates = {10,1,2,7,6,1,5};
        int[] candidates1 = {2,5,2,1,2};
        int target = 8;
        System.out.println(cs.combinationSum2(candidates, target));
        System.out.println(cs.combinationSum2(candidates1, target));
    }
}
