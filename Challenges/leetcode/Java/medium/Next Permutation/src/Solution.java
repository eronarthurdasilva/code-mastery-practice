import java.util.Arrays;

public class Solution {
    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        
        // Encontra o primeiro elemento fora de ordem (da direita para a esquerda)
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        
        if (i >= 0) {
            int j = nums.length - 1;
            // Encontra o menor elemento maior que nums[i]
            while (nums[j] <= nums[i]) j--;
            // Troca nums[i] e nums[j]
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
        
        // Reverte a parte restante para obter a menor permutação
        for (int start = i + 1, end = nums.length - 1; start < end; start++, end--) {
            nums[start] ^= nums[end];
            nums[end] ^= nums[start];
            nums[start] ^= nums[end];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums)); // [1, 3, 2]

        int[] nums2 = {3, 2, 1};
        nextPermutation(nums2);
        System.out.println(Arrays.toString(nums2)); // [1, 2, 3]

        int[] nums3 = {1, 1, 5};
        nextPermutation(nums3);
        System.out.println(Arrays.toString(nums3)); // [1, 5, 1]
    }
}
