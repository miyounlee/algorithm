import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int min = Integer.parseInt(st.nextToken());
        int max = min;
        br.close();

        for (int i = 1; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            min = Math.min(min, a);
            max = Math.max(max, a);
        }
        System.out.print(min + " " + max);
    }
}