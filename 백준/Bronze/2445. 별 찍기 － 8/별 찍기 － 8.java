import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        br.close();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i ; j++) {
                sb.append("*");
            }
            for (int k = 1; k <= 2 * (n - i); k++) {
                sb.append(" ");
            }
            for (int j = 1; j <= i ; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                sb.append("*");
            }
            for (int k = 1; k <= 2 * i; k++) {
                sb.append(" ");
            }
            for (int j = 1; j <= n - i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}