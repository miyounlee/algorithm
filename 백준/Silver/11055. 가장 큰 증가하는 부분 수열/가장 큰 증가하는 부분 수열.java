import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n + 1];
        int[] dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            int num = Integer.parseInt(st.nextToken());
            nums[i] = num;
            dp[i] = num;    
        }

        int max = dp[1];    
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {   
                if ((nums[i] > nums[j]) && (dp[i] < dp[j] + nums[i])) {
                    dp[i] = dp[j] + nums[i];
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}