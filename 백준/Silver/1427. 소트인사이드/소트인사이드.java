import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i) - '0');
        }

        list.sort(Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (int val : list) {
            sb.append(val);
        }

        System.out.println(sb);
    }
}