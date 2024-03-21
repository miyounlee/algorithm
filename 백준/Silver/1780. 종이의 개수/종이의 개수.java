import java.io.*;
import java.util.*;

public class Main {
    static int[][] paper;
    static int[] answer = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        division(0, 0, n);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int val : answer) {
            bw.write(val + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static void division(int row, int col, int n) {
        if (n == 1) {
            answer[paper[row][col] + 1]++;
            return;
        }
        if (isEqual(row, col, n)) {
            answer[paper[row][col] + 1]++;
        } else {
            n = n / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    division(row + i * n, col + j * n, n);
                }
            }
        }
    }

    private static boolean isEqual(int row, int col, int n) {
        int standard = paper[row][col];
        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + n; j++) {
                if (standard != paper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}