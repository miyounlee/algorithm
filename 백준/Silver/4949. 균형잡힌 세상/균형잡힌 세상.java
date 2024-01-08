import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        while (true) {
            boolean isValid = true;
            char[] charArr = br.readLine().toCharArray();
            if (charArr.length == 1 || charArr[0] == '.') break;
            char[] stack = new char[charArr.length];
            int topIndex = -1;
            
            for (char ch : charArr) {
               if (ch == '(' || ch == '[') {
                   stack[++topIndex] = ch;
               } else if (ch == ')' || ch == ']') {
                   if (topIndex < 0 || !isMatch(stack[topIndex--], ch)) {
                       isValid = false;
                       break;
                   }
               }
            }
            
            if (isValid && topIndex < 0) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }
        bw.flush();
    }
    
    public static boolean isMatch(char open, char close) {
        if (open == '(' && close == ')') {
            return true;
        } else if (open == '[' && close == ']') {
            return true;
        } else {
            return false;
        }
    }
}