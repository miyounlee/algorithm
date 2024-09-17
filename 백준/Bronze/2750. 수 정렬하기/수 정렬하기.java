import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {
        int[] arr = new int[2001];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine()) + 1000;
            arr[val]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) {
                sb.append(i - 1000).append('\n');
            }
        }

        System.out.println(sb);
    }
}