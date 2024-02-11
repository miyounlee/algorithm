// STL
import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                    bw.write(queue.isEmpty() ? "0\n" : queue.poll() + "\n");
            } else {
                queue.offer(x);
            }
        }

        bw.flush();
        bw.close();
    }
}
