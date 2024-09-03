import java.io.*;

public class Main {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] strings = br.readLine().split(" ");

            int r = Integer.parseInt(strings[0]);
            String str = strings[1];

            for (int i = 0; i < str.length(); i++) {
                for (int j = 0; j < r; j++) {
                    sb.append(str.charAt(i));
                }
            }
            sb.append("\n");
        }
        br.close();
        System.out.println(sb);
    }
}