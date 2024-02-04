// Top down 
import java.util.*;

public class Main {
    static int[][] arr;
    static int[][] dp;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new int[n][n];
        dp = new int[n][n];
		// 미계산상태 식별을 위해 dp배열 -1로 초기화 
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(find(0, 0));
    }

    public static int find(int row, int col) {
        if (row == n - 1) {
            return arr[row][col];
        } else if (dp[row][col] == -1) {
            dp[row][col] = arr[row][col] + Math.max(find(row + 1, col), find(row + 1, col + 1));
        }
        return dp[row][col];
    }
}