import java.util.*;

public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int waterTrapped = 0;

        // Construir o array leftMax
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Construir o array rightMax
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // Calcular a água acumulada
        for (int i = 0; i < n; i++) {
            waterTrapped += Math.max(0, Math.min(leftMax[i], rightMax[i]) - height[i]);
        }

        return waterTrapped;
    }
    public class Main {
        public static void main(String[] args) {
            Solution solution = new Solution();
            int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
            int result = solution.trap(height);
            System.out.println("Quantidade de água acumulada: " + result); // Deve imprimir 6
        }
    }
    
}
