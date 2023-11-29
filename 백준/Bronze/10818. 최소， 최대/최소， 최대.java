import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        br.close();

        int min = x;
        int max = x;

        for (int i = 1; i < n; i++) {
            x = Integer.parseInt(st.nextToken());
            if (min > x) {
                min = x;
            } else if (max < x) {
                max = x;
            }
        }
        System.out.print(min + " " + max);
    }
}