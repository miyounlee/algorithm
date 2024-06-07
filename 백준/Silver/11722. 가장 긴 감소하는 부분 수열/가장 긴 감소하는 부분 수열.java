import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n + 1];
        int[] dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i + 1] = Integer.parseInt(st.nextToken());
        }

        int answer = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                if (nums[i] < nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    answer = Math.max(answer, dp[i]);
                }
            }
            if (dp[i] == 0) {
                dp[i] = 1;
            }
        }
        
        System.out.println(answer);
    }
}