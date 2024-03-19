import java.io.*;
import java.util.*;

public class Main {
    static int[][] paper;
    static int[] answer = new int[2];

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
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    public static void division(int row, int col, int n) {
        if (n == 1) {
            answer[paper[row][col]]++;
            return;
        }
        if (isSame(row, col, n)) {
            answer[paper[row][col]]++;
        } else {
            n = n / 2;
            division(row, col, n);
            division(row, col + n, n);
            division(row + n, col, n);
            division(row + n, col + n, n);
        }
    }

    public static boolean isSame(int row, int col, int n) {
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