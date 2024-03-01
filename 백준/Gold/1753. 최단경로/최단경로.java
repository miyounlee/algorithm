import java.io.*;
import java.util.*;

public class Main {
    static int V, E;
    static List<List<Pair>> graph;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        // 그래프 구현
        graph = new ArrayList<>(V + 1);
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }
        // 그래프 초기화
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Pair(v, w));
        }
        distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        dijkstra(start);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i < V + 1; i++) {
            bw.write(distance[i] != Integer.MAX_VALUE ? distance[i] + "\n" : "INF\n");
        }
        bw.flush();
    }

    public static void dijkstra(int start) {
        boolean[] visited = new boolean[V + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            if (visited[curr.node]) {   // 메모리 초과 방지
                continue;
            }
            visited[curr.node] = true;
            for (Pair next : graph.get(curr.node)) {
                int nextNode = next.node;
                int nextWeight = next.weight;
                if (distance[nextNode] < distance[curr.node] + nextWeight) {
                    continue;
                }
                distance[nextNode] = distance[curr.node] + nextWeight;
                pq.offer(new Pair(nextNode, distance[curr.node] + nextWeight));
            }
        }
    }
}

class Pair implements Comparable<Pair> {
    int node;
    int weight;

    public Pair (int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Pair o) {
        return this.weight - o.weight;
    }
}