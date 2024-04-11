import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] answer = new int[n + 1];
        answer[0] = 1;
        answer[1] = 1;
        
        for (int i = 2; i < n + 1; i++) {
            answer[i] = (answer[i - 1] + answer[i - 2]) % 10007;
        }
        System.out.println(answer[n]);
    }
}