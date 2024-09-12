import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        while (N-- > 0) {
            if (isGroupWord(br.readLine())) {
                count++;
            }
        }

        System.out.print(count);
    }

    public static boolean isGroupWord(String word) {
        boolean[] isVisited = new boolean[26];
        char prev = ' ';

        for (int i = 0; i < word.length(); i++) {
            char now = word.charAt(i);

            if (prev != now) {
                if (!isVisited[now - 'a']) {
                    isVisited[now - 'a'] = true;
                    prev = now;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

}