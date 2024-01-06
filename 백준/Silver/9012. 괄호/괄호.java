import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            Stack<Character> stack = new Stack<>();
            char[] input = br.readLine().toCharArray();
            for (char b : input) {
                if (b == '(') {
                    stack.push(b);
                } else if (b == ')') {
                    if (stack.isEmpty()) {
                        stack.push(b);
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (stack.isEmpty()) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}