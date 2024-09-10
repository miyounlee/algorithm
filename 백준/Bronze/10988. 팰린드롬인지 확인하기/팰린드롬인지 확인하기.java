import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder(br.readLine());
        String s = new String(sb);

        System.out.println(s.equals(String.valueOf(sb.reverse())) ? 1 : 0);
    }
}