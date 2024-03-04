import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int node;
    int weight;

    public Node(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

public class Main {
    static int N, E;
    static List<List<Node>> graph;
    static int[] distance;
    static boolean[] visited;
    static int INF = 200000000; // 가중치 최대값 * 간선의 최대 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        distance = new int[N + 1];
        visited = new boolean[N + 1];

        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        // 양방향 인접 리스트
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int result1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        int result2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);
        System.out.println(result1 >= INF && result2 >= INF ? -1 : Math.min(result1, result2));
    }

    public static int dijkstra(int start, int end) {
        Arrays.fill(distance, INF);
        Arrays.fill(visited, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (!visited[curr.node]) {
                visited[curr.node] = true;
                for (Node next : graph.get(curr.node)) {
                    if (distance[next.node] > distance[curr.node] + next.weight) {
                        distance[next.node] = distance[curr.node] + next.weight;
                        pq.offer(new Node(next.node, distance[curr.node] + next.weight));
                    }
                }
            }
        }
        return distance[end];
    }
}