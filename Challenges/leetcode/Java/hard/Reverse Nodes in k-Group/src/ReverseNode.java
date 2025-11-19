/*O problema e Reverse Nodes in k-Group 
    Exige que você reverta os nós de uma lista encadeada em grupos de k.
    Por exemplo, se a lista encadeada for 1 -> 2 -> 3 -> 4 -> 5 e k = 2, a saída deve ser 2 -> 1 -> 4 -> 3 -> 5.
    sainda deve ser 3 -> 2 -> 1 -> 4 -> 5.
 * */
import java.util.*;


class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}

/**
 * A classe ReverseNode contém um método para reverter nós em grupos de k em uma lista ligada.
 */
class ReverseNode {

    /**
     * Reverte os nós de uma lista ligada em grupos de k.
     * 
     * @param head A cabeça da lista ligada.
     * @param k O tamanho do grupo a ser revertido.
     * @return A nova cabeça da lista ligada após a reversão dos grupos.
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // Dummy node ajuda a lidar com a cabeça da lista facilmente
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;

        while (true) {
            // Localiza o k-ésimo nó do grupo atual
            ListNode kthNode = getKthNode(groupPrev, k);
            if (kthNode == null) {
                // Se não houver k nós restantes, terminamos o processo
                break;
            }

            // Próximo grupo começa após o k-ésimo nó
            ListNode groupNext = kthNode.next;

            // Reverter o grupo atual
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {
                ListNode temp = curr.next; // Salva o próximo nó
                curr.next = prev; // Inverte o ponteiro atual
                prev = curr; // Avança o ponteiro prev
                curr = temp; // Avança o ponteiro curr
            }

            // Ajusta as conexões do grupo revertido
            ListNode temp = groupPrev.next; // Armazena o início do grupo original
            groupPrev.next = kthNode; // Conecta o início do grupo revertido
            groupPrev = temp; // Move o groupPrev para o final do grupo revertido
        }

        // Retorna a nova cabeça da lista
        return dummy.next;
    }

    /**
     * Função auxiliar para localizar o k-ésimo nó a partir de um ponto inicial.
     * 
     * @param start O nó inicial a partir do qual contar.
     * @param k O número de nós a contar.
     * @return O k-ésimo nó a partir do ponto inicial, ou null se não houver k nós restantes.
     */
    private ListNode getKthNode(ListNode start, int k) {
        while (start != null && k > 0) {
            start = start.next;
            k--;
        }
        return start;
    }

    /**
     * Método principal para testar a funcionalidade de reversão de grupos de nós.
     * 
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        // Criação da lista: [1,2,3,4,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        ReverseNode solution = new ReverseNode();
        ListNode result = solution.reverseKGroup(head, k);

        // Imprime a lista resultante
        printList(result);
    }

    /**
     * Função para imprimir a lista ligada.
     * 
     * @param head A cabeça da lista ligada a ser impressa.
     */
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
