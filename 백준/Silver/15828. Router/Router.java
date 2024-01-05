import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        int packet = 1;

        while (queue.size() <= N && packet >= 0) {
            packet = Integer.parseInt(br.readLine());
            if (packet > 0) {
                queue.offer(packet);
            } else if (packet == 0) {
                queue.poll();
            }
        }
        br.close();

        if (queue.isEmpty()) {
            bw.write("empty");
        } else {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                bw.write(queue.poll() + " ");
            }
        }

        bw.flush();
        bw.close();
    }
}