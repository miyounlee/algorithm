import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Byte> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            byte[] input = br.readLine().getBytes();
            for (byte b : input) {
                if (b == '(') {
                    stack.push(b);
                } else if (b == ')') {
                    if (stack.isEmpty()) { // 삭제할 ) 가 없을 경우
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
            stack.clear();
        }
        br.close();
        bw.flush();
        bw.close();
    }
}