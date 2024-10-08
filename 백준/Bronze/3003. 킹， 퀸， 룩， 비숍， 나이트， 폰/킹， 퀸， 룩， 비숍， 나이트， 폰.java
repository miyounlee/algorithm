import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] chess = {1, 1, 2, 2, 2, 8};

        for (int i = 0; i < 6; i++) {
            int b = Integer.parseInt(st.nextToken());
            sb.append(chess[i] - b).append(" ");
        }

        System.out.println(sb);
    }
}