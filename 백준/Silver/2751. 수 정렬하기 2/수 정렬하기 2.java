import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[2000001];

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine()) +  + 1000000;
            arr[val] = true;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                bw.write((i - 1000000) + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}