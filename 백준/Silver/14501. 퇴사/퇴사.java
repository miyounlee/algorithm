import java.io.*;
import java.util.*;

public class Main {
    static int[] T, P, pay;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        T = new int[n + 1];
        P = new int[n + 1];
        pay = new int[n + 2];

        StringTokenizer st;
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(dp(n));
    }

    public static int dp(int n) {
        int answer = 0;
        for (int i = 1; i <= n + 1; i++) {
            pay[i] = Math.max(answer, pay[i]); 
            if (i < n + 1 && i + T[i] <= n + 1) {
                pay[i + T[i]] = Math.max(pay[i + T[i]], pay[i] + P[i]);
            }
            answer = Math.max(answer, pay[i]); 
        }
        return answer;
    }
}