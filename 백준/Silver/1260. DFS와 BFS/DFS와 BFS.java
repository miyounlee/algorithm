import java.util.*;

public class Main {
    static int n, m, v;
    static boolean[] visited;
    static int[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int src = sc.nextInt();
            int dst = sc.nextInt();
            graph[src][dst] = 1;
            graph[dst][src] = 1;
        }

        dfs(v);
        System.out.println();
        visited = new boolean[n + 1];
        bfs(v);
    }

    static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int i = 1; i < n + 1; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    static Queue<Integer> q;
    static void bfs(int node) {
        visited[node] = true;
        q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            int currentNode = q.remove();
            System.out.print(currentNode + " ");
            for (int i = 1; i < n + 1; i++) {
                if (graph[currentNode][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}