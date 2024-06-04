import java.io.*;

public class Main {
    static int SIZE = 1000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[] dp = new long[SIZE];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < SIZE; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < T; j++) {
            int m = Integer.parseInt(br.readLine());
            sb.append(dp[m]).append("\n");
        }
        System.out.println(sb);
    }
}
