import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int count = 0;
    static int N;
    static boolean[][] isVisited;
    static boolean[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        isVisited = new boolean[N][N];
        graph = new boolean[N][N];
        int[] groups = new int[N * N]; // 단지 수 저장하는 배열

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                if ((str.charAt(j) - '0') == 1) {
                    graph[i][j] = true;
                }
            }
        }

        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] && !isVisited[i][j]) {
                    count = 0;
                    dfs(i, j);
                    if (count > 0) { // 수정
                        groups[idx++] = count;
                    }
                }
            }
        }
        sb.append(idx).append('\n'); // 단지 개수 출력

        Arrays.sort(groups);

        for (int val : groups) {
            if (val != 0) {
            sb.append(val).append('\n');
            }
        }

        System.out.println(sb);
    }

    public static void dfs (int row, int col) {
        // 범위안에 있고, 지도가 1이고(집이 있고), 방문하지 않았다면
        if (0 <= row && row < N && 0 <= col && col < N && graph[row][col] && !isVisited[row][col]) {
            isVisited[row][col] = true;
            count++;
            dfs(row + 1, col);
            dfs(row - 1, col);
            dfs(row, col + 1);
            dfs(row, col - 1);
        }
    }
}