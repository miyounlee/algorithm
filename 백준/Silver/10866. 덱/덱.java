import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> deque = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back" :
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front" :
                    bw.write(deque.isEmpty() ? "-1\n" : deque.removeFirst() + "\n");
                    break;
                case "pop_back" :
                    bw.write(deque.isEmpty() ? "-1\n" : deque.removeLast() + "\n");
                    break;
                case "size" :
                    bw.write(deque.size() + "\n");
                    break;
                case "empty" :
                    bw.write(deque.isEmpty() ? "1\n" : "0\n");
                    break;
                case "front" :
                    bw.write(deque.isEmpty() ? "-1\n" : deque.getFirst() + "\n");
                    break;
                case "back" :
                    bw.write(deque.isEmpty() ? "-1\n" : deque.getLast() + "\n");
                    break;
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}