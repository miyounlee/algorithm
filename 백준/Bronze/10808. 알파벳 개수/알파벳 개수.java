import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        int[] count = new int[26];
        for (int i = 0; i < input.length(); i++) {
           count[input.charAt(i) - 97]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int value : count) {
            sb.append(value + " ");
        }

        br.close();
        System.out.print(sb);
    }
}