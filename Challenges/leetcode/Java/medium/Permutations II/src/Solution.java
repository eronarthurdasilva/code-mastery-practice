import java.util.*;

public class Solution{
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Ordena o array para facilitar a detecção de duplicatas
        backtrack(nums, new ArrayList<>(), result, new boolean[nums.length]);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> tempList, List<List<Integer>> result, boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));  // Se o tamanho da lista temporária for igual ao tamanho de nums, adiciona a permutação
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Pula números já usados
            if (used[i]) continue;
            // Evita usar o mesmo número em uma posição repetidamente
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            // Marca o número como usado e adiciona ao tempList
            used[i] = true;
            tempList.add(nums[i]);

            // Chama recursivamente
            backtrack(nums, tempList, result, used);

            // Desfaz a ação para o próximo ciclo
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 1, 2};
        System.out.println(solution.permuteUnique(nums1));

        int[] nums2 = {1, 2, 3};
        System.out.println(solution.permuteUnique(nums2));
    }
}
