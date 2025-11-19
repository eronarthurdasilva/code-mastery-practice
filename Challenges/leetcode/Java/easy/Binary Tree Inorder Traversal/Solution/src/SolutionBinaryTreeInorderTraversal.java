import java.util.ArrayList;
import java.util.List;

// Definição da classe TreeNode para representar um nó na árvore binária
class TreeNode {
    int val;           // Valor do nó
    TreeNode left;     // Referência para o filho à esquerda
    TreeNode right;    // Referência para o filho à direita

    // Construtor padrão
    TreeNode() {}

    // Construtor que define apenas o valor do nó
    TreeNode(int val) {
        this.val = val;
    }

    // Construtor que define o valor e os filhos (esquerda e direita)
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SolutionBinaryTreeInorderTraversal {

    // Definição da classe TreeNode
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Método para realizar a travessia inorder
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node != null) {
            inorderHelper(node.left, result);
            result.add(node.val);
            inorderHelper(node.right, result);
        }
    }

    /**
     * Método principal para testes.
     */
    public static void main(String[] args) {
        SolutionBinaryTreeInorderTraversal solution = new SolutionBinaryTreeInorderTraversal();

        // Exemplo 1
        TreeNode root1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println("Inorder Traversal 1: " + solution.inorderTraversal(root1)); 
        // Output esperado: [1, 3, 2]

        // Exemplo 2
        TreeNode root2 = new TreeNode(1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(6), new TreeNode(7))),
            new TreeNode(3, null, new TreeNode(8, new TreeNode(9), null))
        );
        System.out.println("Inorder Traversal 2: " + solution.inorderTraversal(root2)); 
        // Output esperado: [4, 2, 6, 5, 7, 1, 3, 9, 8]

        // Exemplo 3
        TreeNode root3 = null;
        System.out.println("Inorder Traversal 3: " + solution.inorderTraversal(root3)); 
        // Output esperado: []

        // Exemplo 4
        TreeNode root4 = new TreeNode(1);
        System.out.println("Inorder Traversal 4: " + solution.inorderTraversal(root4)); 
        // Output esperado: [1]
    }
}