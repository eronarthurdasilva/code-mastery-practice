import java.util.*;

public class App{
    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(App.class.getName());

    // Instância única de Random para reutilização
    private static final Random rand = new Random();

    public int mostBooked(int n, int[][] meetings){
        // Ordena as reuniões pelo horário de início
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        // Fila de salas livres (menor número primeiro)
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) freeRooms.offer(i);

        // Fila de salas ocupadas: [fim, sala]
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

        int[] count = new int[n]; // Contador de reuniões por sala

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            // Libera salas que já terminaram antes do início da reunião
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                freeRooms.offer((int)busyRooms.poll()[1]);
            }

            if (!freeRooms.isEmpty()) {
                // Sala livre disponível
                int room = freeRooms.poll();
                busyRooms.offer(new long[]{end, room});
                count[room]++;
            } else {
                // Todas ocupadas, pega a que termina mais cedo
                long[] next = busyRooms.poll();
                long newEnd = next[0] + (end - start);
                busyRooms.offer(new long[]{newEnd, next[1]});
                count[(int)next[1]]++;
            }
        }

        // Encontra a sala com mais reuniões (menor índice em caso de empate)
        int max = 0;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > max) {
                max = count[i];
                idx = i;
            }
        }
        return idx;
    }


    
    public static void main(String[] args) {
        App app = new App();
        int n = 3;
        int[][] meetings = randomlyGeneratedMeetings(10, 0, 100);
        int result = app.mostBooked(n, meetings);
        if (LOGGER.isLoggable(java.util.logging.Level.INFO)) {
            LOGGER.info(String.format("Sala com mais reuniões: %d", result));
        }
    }

  

    // Gera reuniões aleatórias para teste
    public static int[][] randomlyGeneratedMeetings(int count, int min, int max) {
        int[][] meetings = new int[count][2];
        for (int i = 0; i < count; i++) {
            int start = rand.nextInt(max - min + 1) + min;
            int duration = rand.nextInt((max - start) + 1);
            int end = start + duration;
            meetings[i][0] = start;
            meetings[i][1] = end;
        }
        return meetings;
    }
}
