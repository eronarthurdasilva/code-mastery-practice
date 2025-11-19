/*
 * Desafio 50
 * Descrição 
 * Implemente a função que calcula x elevado a n, onde x é um número real e n é um número inteiro.
 */

class PowSolution{
    public double myPow(double x, int n) {
        // Caso base: qualquer número elevado a 0 é 1
        if (n == 0) {
            return 1.0;
        }

        // Se o expoente for negativo, convertemos para positivo
        // e invertemos a base (x se torna 1/x)
        if (n < 0) {
            x = 1 / x;
            // Precisamos lidar com possíveis problemas de overflow ao lidar com -n
            n = -n;
        }

        // Chamada da função helper para cálculo eficiente
        return fastPow(x, n);
    }

    private double fastPow(double x, int n) {
        // Caso base: qualquer número elevado a 0 é 1
        if (n == 0) {
            return 1.0;
        }

        // Calcula recursivamente x^(n/2)
        double half = fastPow(x, n / 2);

        // Se n for par, o resultado é half * half
        if (n % 2 == 0) {
            return half * half;
        } else {
            // Se n for ímpar, o resultado é half * half * x
            return half * half * x;
        }
    }

    // Método principal para testes
    public static void main(String[] args) {
        PowSolution solution = new PowSolution();

        // Testes
        System.out.println("2.00000^10 = " + solution.myPow(2.00000, 10)); // Output: 1024.00000
        System.out.println("2.10000^3 = " + solution.myPow(2.10000, 3));   // Output: 9.26100
        System.out.println("2.00000^-2 = " + solution.myPow(2.00000, -2)); // Output: 0.25000
    }
}

