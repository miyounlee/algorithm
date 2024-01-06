import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] stack = new int[10000];
        int topIndex = -1;

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("push")) {
                stack[++topIndex] = Integer.parseInt(st.nextToken());
            } else if (cmd.equals("pop")) {
                bw.write(topIndex == -1 ? "-1\n" : stack[topIndex--] + "\n");
            } else if (cmd.equals("size")) {
                bw.write(topIndex + 1 + "\n");
            } else if (cmd.equals("empty")) {
                bw.write(topIndex == -1 ? "1\n" : "0\n");
            } else if (cmd.equals("top")) {
                bw.write(topIndex == -1 ? "-1\n" : stack[topIndex] + "\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}