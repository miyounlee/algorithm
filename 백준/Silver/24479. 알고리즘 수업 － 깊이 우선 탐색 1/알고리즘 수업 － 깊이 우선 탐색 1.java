import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] isVisited;
    static int order = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        isVisited = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u); // 양방향 그래프
        }

        dfs(r);

        for (int i = 1; i < n + 1; i++) {
            sb.append(isVisited[i]).append('\n');
        }

        System.out.println(sb);
    }

    public static void dfs(int node) {
        isVisited[node] = order++;
        graph.get(node).sort(Comparator.naturalOrder());

        for (int next : graph.get(node)) {
            if (isVisited[next] == 0) {
                dfs(next);
            }
        }
    }
}