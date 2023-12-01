import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        br.close();

        int[] counts = new int[10];

        String result = String.valueOf(a * b * c);
        for (int i = 0; i < result.length(); i++) {
            counts[result.charAt(i) - '0']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int count : counts) {
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }
}