import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            list.add(i);
        }

        int index = 0;
        int[] results = new int[n];
        int i = 0;
        while (!list.isEmpty()) {
            index = (index + (k - 1)) % list.size();
            results[i++] = list.remove(index);
        }
        System.out.println("<" + Arrays.stream(results)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ")) + ">");
    }
}

