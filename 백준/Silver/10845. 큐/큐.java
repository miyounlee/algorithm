import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        int lastValue = -1;

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (order.equals("push")) {
                lastValue = Integer.parseInt(st.nextToken());
                queue.offer(lastValue);
            } else if (order.equals("pop")) {
                bw.write(queue.isEmpty() ? -1 + "\n" : queue.poll() + "\n");
            } else if (order.equals("size")) {
                bw.write(queue.size() + "\n");
            } else if (order.equals("empty")) {
                bw.write(queue.isEmpty() ? 1 + "\n" : 0 + "\n");
            } else if (order.equals("front")) {
                bw.write(queue.isEmpty() ? -1 + "\n" : queue.peek() + "\n");
            } else if (order.equals("back")) {
                bw.write(queue.isEmpty() ? -1 + "\n" : lastValue + "\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }

}