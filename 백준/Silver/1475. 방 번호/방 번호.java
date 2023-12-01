import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        br.close();

        int[] counts = new int[9];
        int num = 0;
        int result = 1;
        for (int i = 0; i < n.length(); i++) {
            num = n.charAt(i) - '0';
            if (num == 6 || num == 9) {
                num = 6;
                if (counts[num] == (2 * result)) {
                    result++;
                }
                counts[num]++;
            } else {
                if (counts[num] == result) {
                    result++;
                }
                counts[num]++;
            }
        }
        System.out.println(result);
    }
}