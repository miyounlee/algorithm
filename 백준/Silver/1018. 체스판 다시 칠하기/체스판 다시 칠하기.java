import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int MIN = 64;
    static boolean[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == 'W') {
                    board[i][j] = true;
                }
            }
        }

        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                count(i, j);
            }
        }

        System.out.println(MIN);
    }

    public static void count(int startRow, int startCol) {
        int endRow = startRow + 8;
        int endCol = startCol + 8;
        boolean color = board[startRow][startCol];
        int times = 0;

        for (int i = startRow; i < endRow; i++) {
            for (int j = startCol; j < endCol; j++) {
                if (color != board[i][j]) {
                    times++;
                }
                color = !color;
            }
            color = !color;
        }

        times = Math.min(times, 64 - times);
        MIN = Math.min(MIN, times);
    }
}