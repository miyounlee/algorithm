import java.io.*;
import java.util.*;

public class Main {
    static int SIZE = 1000001;
    static int[] count = new int[SIZE];
    static boolean[] visited = new boolean[SIZE];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(bfs(n));
    }

    public static int bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;
        int curr, next;
        while (q.peek() != n) {
            curr = q.poll();
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    next = curr * 3;
                } else if (i == 1) {
                    next = curr * 2;
                } else {
                    next = curr + 1;
                }
                if (next >= 0 && next < SIZE && !visited[next]) {
                    count[next] = count[curr] + 1;
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        return count[n];
    }
}