import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        MyStack myStack = new MyStack();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("push")) {
                myStack.push(Integer.parseInt(st.nextToken()));
            } else if (cmd.equals("pop")) {
                bw.write(myStack.isEmpty() ? "-1\n" : myStack.pop() + "\n");
            } else if (cmd.equals("size")) {
                bw.write(myStack.size() + "\n");
            } else if (cmd.equals("empty")) {
                bw.write(myStack.isEmpty() ? "1\n" : "0\n");
            } else if (cmd.equals("top")) {
                bw.write(myStack.isEmpty() ? "-1\n" : myStack.top() + "\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}

class MyStack {
    private int[] stack = new int[10000];
    private int topIndex = -1;
    private int size = 0;

    public void push(int value) {
        stack[++topIndex] = value;
        size++;
    }

    public int pop() {
        int value = stack[topIndex];
        stack[topIndex--] = 0;
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int top() {
        return stack[topIndex];
    }
}