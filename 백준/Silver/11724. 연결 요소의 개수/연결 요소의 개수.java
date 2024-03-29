import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        visited = new boolean[N + 1];
        graph = new int[N + 1][N + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        int answer = 0;
        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int node) {
        visited[node] = true;
        for (int i = 1; i < N + 1; i++) {
            if (!visited[i] && graph[node][i] == 1) {
                dfs(i);
            }
        }
    }
}