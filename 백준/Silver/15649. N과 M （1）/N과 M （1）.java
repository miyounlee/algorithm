import java.util.*;

public class Main {
    static int N, M;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        result = new int[M];
        visited = new boolean[N];

        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if (depth == M) {
            for (int val : result) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i + 1;  // depth에 현재 숫자를 넣어줌
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}