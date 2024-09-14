import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[][] isVisited = new boolean[101][101];
        int area = 0;

        for (int k = 0; k < n; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for (int i = a; i < a + 10; i++) {
                for (int j = b; j < b + 10; j++) {
                    if (!isVisited[j][i]) {
                        isVisited[j][i] = true;
                        area++;
                    }
                }
            }
        }

        System.out.println(area);
    }
}