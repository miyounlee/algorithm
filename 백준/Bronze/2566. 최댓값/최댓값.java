import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = -1;
        int row = 0;
        int col = 0;

        for (int i = 1; i <= 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= 9; j++) {
                int now = Integer.parseInt(st.nextToken());
                if (now > max) {
                    max = now;
                    row = i;
                    col = j;
                }
            }
        }

        System.out.println(max + "\n" + row + " " + col);
    }
}