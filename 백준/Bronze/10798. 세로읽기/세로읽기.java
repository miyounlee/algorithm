import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[][] chars = new char[5][15];
        int maxLength = -1;

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            maxLength = Math.max(maxLength, str.length());

            for (int j = 0; j < str.length(); j++) {
                chars[i][j] = str.charAt(j);
            }
        }

        for (int col = 0; col < maxLength; col++) {
            for (int row = 0; row < 5; row++) {
                if (chars[row][col] != 0) {
                    sb.append(chars[row][col]);
                }
            }
        }
        
        System.out.println(sb);
    }
}