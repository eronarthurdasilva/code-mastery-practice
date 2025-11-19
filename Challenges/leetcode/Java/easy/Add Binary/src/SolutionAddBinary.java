/*
 * Descrição do Problema
 O problema consiste em somar duas strings binárias, como se estivéssemos realizando uma soma manual de números binários. Para isso, precisamos lidar com:
    1. Diferentes comprimentos das strings.
    2. O transporte ("carry") que ocorre durante a soma binária.
 */
public class SolutionAddBinary {
    /*
     * Solução:
     * 1. Inicialize um StringBuilder para armazenar o resultado.
     * 2. Inicialize uma variável de transporte (carry) como 0.
     * 3. Inicialize dois ponteiros i e j no final de ambas as strings.
     * 4. Percorra as duas strings da direita para a esquerda. 
     * 5. Adicione os dígitos das duas strings e o transporte.
     * 6. Adicione o dígito resultante ao StringBuilder e atualize o transporte.
     * 7. Se houver transporte após o loop, adicione-o ao StringBuilder.
     * 8. Inverta o StringBuilder e retorne a string resultante.
     * 9. finaliza a execução.
     */
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            result.append(sum % 2);
            carry = sum / 2;
        }

        if (carry != 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }
    public static void main(String[] args) {
        SolutionAddBinary solution = new SolutionAddBinary();
        String a = "11";
        String b = "1";
        System.out.println("Soma de " + a + " e " + b + ": " + solution.addBinary(a, b));

        String c = "1010";
        String d = "1011";
        System.out.println("Soma de " + c + " e " + d + ": " + solution.addBinary(c, d));
        
    }
}
