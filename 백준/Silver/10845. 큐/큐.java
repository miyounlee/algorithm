import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        int count = 1;
        int lastValue = -1;
        while (count <= N) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    lastValue = Integer.parseInt(st.nextToken());
                    queue.offer(lastValue);
                    count++;
                    break;
                case "pop":
                    if (queue.isEmpty()) {
                        bw.write(-1 + "\n");
                        count++;
                        break;
                    }
                    bw.write(queue.poll() + "\n");
                    count++;
                    break;
                case "size":
                    bw.write(queue.size() + "\n");
                    count++;
                    break;
                case "empty":
                    if (queue.isEmpty()) {
                        bw.write(1 + "\n");
                    } else {
                        bw.write(0 + "\n");
                    }
                    count++;
                    break;
                case "front":
                    if (queue.isEmpty()) {
                        bw.write(-1 + "\n");
                        count++;
                        break;
                    }
                    bw.write(queue.peek() + "\n");
                    count++;
                    break;
                case "back":
                    if (queue.isEmpty()) {
                        bw.write(-1 + "\n");
                        count++;
                        break;
                    }
                    bw.write(lastValue + "\n");
                    count++;
                    break;
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }

}