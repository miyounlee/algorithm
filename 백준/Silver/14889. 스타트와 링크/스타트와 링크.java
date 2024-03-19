import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int[][] table;
    static boolean[] visited;
    static int MIN = 99;   // diff의 최대값 : 99

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        table = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(MIN);
    }

    public static void dfs(int idx, int depth) {
        if (depth == N / 2) {
            int startTeam = 0;
            int linkTeam = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (visited[i] && visited[j]) {
                        startTeam += table[i][j];
                        startTeam += table[j][i];
                    } else if (!visited[i] && !visited[j]) {
                        linkTeam += table[i][j];
                        linkTeam += table[j][i];
                    }
                }
            }
            int diff = Math.abs(startTeam - linkTeam);
            if (diff == 0) {    // 차이가 0이면 최소값이므로 더 탐색하지 않고, 반환
                MIN = 0;
                return;
            }
            MIN = Math.min(MIN, diff);
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[idx]) {
                visited[idx] = true;
                dfs(i + 1, depth + 1);
                visited[idx] = false;
            }
        }
    }
}