import java.util.Scanner;

public class App {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
            for (int b : batteries) sum += b;
            long low = 0;
            long high = sum / n; // limite superior possível

            while (low < high) {
                // mid bias para cima: queremos evitar loop infinito, probe o candidato "upper mid"
                long mid = (low + high + 1) >>> 1; // (low+high+1)/2
                if (canRunAll(n, batteries, mid)) {
                    low = mid; // mid é possível -> buscar maior
                } else {
                    high = mid - 1; // mid não é possível -> reduzir
                }
            }
        return low;
    }

    private boolean canRunAll(int n, int[] batteries, long t) {
        // calcula soma de min(battery[i], t)
        long total = 0;
        long need = (long) n * t;
        for (int b : batteries) {
            total += Math.min((long) b, t);
            // micro-otimização: se total já alcançou need, podemos retornar true cedo
            if (total >= need) return true;
        }
        return total >= need;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();       // número de máquinas
        int m = sc.nextInt();       // quantidade de baterias
        int[] batteries = new int[m];

        for (int i = 0; i < m; i++) {
            batteries[i] = sc.nextInt();
        }

        App sol = new App();
        long result = sol.maxRunTime(n, batteries);
        System.out.println(result);
    }
}
