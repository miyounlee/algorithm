import java.io.*;
import java.util.*;

public class Main{
    static int SIZE = 100000;
    static int[] seconds = new int[SIZE + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        bfs(n, k);
        System.out.println(seconds[k] - 1);
    }

    public static void bfs(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        seconds[n] = 1;
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == k) {
                break;
            }
            if (curr - 1 >= 0 && seconds[curr - 1] == 0) {
                q.offer(curr - 1);
                seconds[curr - 1] = seconds[curr] + 1;
            }
            if (curr + 1 <= SIZE && seconds[curr + 1] == 0) {
                q.offer(curr + 1);
                seconds[curr + 1] = seconds[curr] + 1;
            }
            if (2 * curr <= SIZE && seconds[2 * curr] == 0) {
                q.offer(2 * curr);
                seconds[2 * curr] = seconds[curr] + 1;
            }
        }
    }
}