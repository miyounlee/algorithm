import java.io.*;
import java.util.*;

public class Main{
    static int SIZE = 100001;
    static int[] total = new int[SIZE];
    static boolean[] visited = new boolean[SIZE];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        bfs(n, k);
        System.out.println(total[k]);
    }

    public static void bfs(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        visited[n] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == k) {
                break;
            }
            int time = total[curr];
            if (2 * curr < SIZE && !visited[2 * curr]) {
                visited[2 * curr] = true;
                total[2 * curr] = time;
                q.offer(2 * curr);
            }
            if (curr - 1 >= 0 && !visited[curr - 1]) {
                visited[curr - 1] = true;
                total[curr - 1] = time + 1;
                q.offer(curr - 1);
            }
            if (curr + 1 < SIZE && !visited[curr + 1]) {
                visited[curr + 1] = true;
                total[curr + 1] = time + 1;
                q.offer(curr + 1);
            }
        }
    }
}