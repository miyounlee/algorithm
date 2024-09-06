import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;

        sb = new StringBuilder(st.nextToken());
        int x = Integer.parseInt(String.valueOf(sb.reverse()));

        sb = new StringBuilder(st.nextToken());
        int y = Integer.parseInt(String.valueOf(sb.reverse()));

        System.out.println(Math.max(x, y));
    }
}