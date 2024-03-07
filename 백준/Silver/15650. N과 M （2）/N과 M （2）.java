import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[M];

        backtrack(1, 0);
        System.out.println(sb);
    }

    public static void backtrack(int start, int depth) {
        if (depth == M) {
            for (int val : result) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = start; i < N + 1; i++) {  
            result[depth] = i;  // depth는 topIndex
            backtrack(i + 1, depth + 1);
        }
    }
}
