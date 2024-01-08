import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        while (true) {
            String input = br.readLine();
            char[] charArr = input.toCharArray();
            if (charArr[0] == '.') break;
            Stack<Character> stack = new Stack<>();

            for (char ch : charArr) {
                if (ch == '(') {
                    stack.push(ch);
                } else if (ch == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        stack.push(ch);
                        break;
                    }
                    stack.pop();
                } else if (ch == '[') {
                    stack.push(ch);
                } else if (ch == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        stack.push(ch);
                        break;
                    }
                    stack.pop();
                } else if (ch == '.') {
                    break;
                }
            }
            if (stack.isEmpty()) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }
        bw.flush();
    }
}