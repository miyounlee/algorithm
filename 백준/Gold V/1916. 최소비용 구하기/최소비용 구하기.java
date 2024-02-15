import java.io.*;
import java.util.*;

public class Main {
    static List<List<Pair>> graph;
    static boolean[] visit; // 시간복잡도를 줄이기 위해 
    static int[] costs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        visit = new boolean[n + 1];
        costs = new int[n + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        graph = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        StringTokenizer st;
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int arrival = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Pair(arrival, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int arrival = Integer.parseInt(st.nextToken());

        System.out.println(findMinCost(start, arrival));
    }

    public static int findMinCost(int start, int arrival) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(start, 0));
        costs[start] = 0;
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            if (visit[current.node]) {
                continue;
            }
            visit[current.node] = true;
            for (Pair next : graph.get(current.node)) {
                int nextNode = next.node;
                int cost = next.cost;
                if (costs[nextNode] > costs[current.node] + cost) {
                    costs[nextNode] = costs[current.node] + cost;
                    pq.offer(new Pair(nextNode, costs[current.node] + cost));
                }
            }
        }
        return costs[arrival];
    }
}

class Pair implements Comparable<Pair>{
    int node;
    int cost;

    public Pair(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Pair o) {
        return this.cost - o.cost;
    }
}