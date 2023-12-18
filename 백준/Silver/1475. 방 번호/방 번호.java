import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int[] counts = new int[10];
        for (int i = 0; i < N.length(); i++) {
            counts[N.charAt(i) - '0']++;
        }
        counts[6] = (int)Math.round((counts[6] + counts[9]) / (double)2);
        int result = 0;
        for (int i = 0; i < 9; i++) {
            if (result < counts[i]) {
                result = counts[i];
            }
        }
        System.out.println(result);
    }
}