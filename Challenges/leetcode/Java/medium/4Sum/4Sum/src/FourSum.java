// Código fonte do desafio: https://leetcode.com/problems/4sum/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        // Ordenar o array
        Arrays.sort(nums);
        int n = nums.length;

        // Primeiro loop para o primeiro número
        for (int i = 0; i < n - 3; i++) {
            // Evitar duplicatas no primeiro número
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Segundo loop para o segundo número
            for (int j = i + 1; j < n - 2; j++) {
                // Evitar duplicatas no segundo número
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // Dois ponteiros
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        // Adicionar a combinação ao resultado
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Avançar ponteiros e evitar duplicatas
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++; // Precisamos de uma soma maior
                    } else {
                        right--; // Precisamos de uma soma menor
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Teste 1
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int target1 = 0;
        System.out.println(fourSum(nums1, target1)); // [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]

        // Teste 2
        int[] nums2 = {2, 2, 2, 2, 2};
        int target2 = 8;
        System.out.println(fourSum(nums2, target2)); // [[2, 2, 2, 2]]
    }
}


