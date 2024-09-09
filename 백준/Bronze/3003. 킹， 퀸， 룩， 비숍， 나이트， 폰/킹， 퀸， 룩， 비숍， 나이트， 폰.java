import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] standard = new int[6];
        standard[0] = 1;
        standard[1] = 1;
        standard[2] = 2;
        standard[3] = 2;
        standard[4] = 2;
        standard[5] = 8;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            sb.append(standard[i] - Integer.parseInt(st.nextToken()) + " ");
        }

        System.out.println(sb);
    }
}