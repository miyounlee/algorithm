// 다익스트라
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());   // 열
        int n = Integer.parseInt(st.nextToken());   // 행
        int[][] graph = new int[n][m];
        int[][] costs = new int[n][m];

        // 그래프 인접행렬로 구현
        for (int i = 0; i < n; i++) {
            char[] chArr = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                graph[i][j] = chArr[j] - '0';
            }
            Arrays.fill(costs[i], Integer.MAX_VALUE);
        }

        // 방향 배열
        int[] directionRow = {-1, 1, 0, 0};
        int[] directionCol = {0, 0, -1, 1};

        // 다익스트라
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(0, 0, 0));
        costs[0][0] = 0;
        while(!pq.isEmpty()) {
            Point current = pq.poll();
            if (costs[current.row][current.col] < current.cost) continue;
            if (current.row == n - 1 && current.col == m - 1) break;
            for (int i = 0; i < 4; i++) {
                int nextRow = current.row + directionRow[i];
                int nextCol = current.col + directionCol[i];
                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) continue;
                if (costs[nextRow][nextCol] > costs[current.row][current.col] + graph[nextRow][nextCol]) {
                    costs[nextRow][nextCol] = costs[current.row][current.col] + graph[nextRow][nextCol];
                    pq.offer(new Point(nextRow, nextCol, costs[nextRow][nextCol]));
                }
            }
        }
        System.out.println(costs[n - 1][m - 1]);
    }
}

class Point implements Comparable<Point>{
    int row;
    int col;
    int cost;

    public Point(int row, int col, int cost) {
        this.row = row;
        this.col = col;
        this.cost = cost;
    }

    @Override
    public int compareTo(Point o) {
        return this.cost - o.cost;
    }
}