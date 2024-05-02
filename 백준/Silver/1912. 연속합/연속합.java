import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] nums = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[n + 1];
        dp[n] = nums[n];
        
        int answer = nums[n];
        for (int j = n - 1; j > 0; j--) {
            dp[j] = Math.max(nums[j], nums[j] + dp[j + 1]);
            answer = Math.max(answer, dp[j]);
        }
        
        System.out.println(answer);
    }
}