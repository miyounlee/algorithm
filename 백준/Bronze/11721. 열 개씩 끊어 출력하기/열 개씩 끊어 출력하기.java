import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        br.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < a.length(); i++) {
            sb.append(a.charAt(i));
            if (i % 10 == 9) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}