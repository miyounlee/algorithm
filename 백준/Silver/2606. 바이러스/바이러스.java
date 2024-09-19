import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    static boolean[] isVisited;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        isVisited = new boolean[V + 1];

        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        dfs(1);

        System.out.println(count);
    }

    public static void dfs (int node) {
        isVisited[node] = true;
        for (int next : graph.get(node)) {
            if (!isVisited[next]) {
                count++;
                dfs(next);
            }
        }
    }
}