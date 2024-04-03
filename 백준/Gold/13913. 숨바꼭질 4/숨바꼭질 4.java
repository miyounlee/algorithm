import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int SIZE = 100001;
    static int[] prev = new int[SIZE];
    static int[] times = new int[SIZE];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(times[K] - 1 + "\n");

        Deque<Integer> stack = new ArrayDeque<>();
        while (K != N) {
            stack.offerLast(K);
            K = prev[K];
        }
        stack.offerLast(N);

        while (!stack.isEmpty()) {
            bw.write(stack.pollLast() + " ");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        times[N] = 1;

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == K) {
                break;
            }

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) {
                    next = curr - 1;
                } else if (i == 1) {
                    next = curr + 1;
                } else {
                    next = curr * 2;
                }

                if (0 <= next && next < SIZE && times[next] == 0) {
                    prev[next] = curr;
                    q.offer(next);
                    times[next] = times[curr] + 1;
                }
            }
        }
    }
}