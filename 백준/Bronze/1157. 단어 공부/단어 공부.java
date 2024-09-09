import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] counts = new int[26];

        while (true) {
            int value = System.in.read();

            if (value == '\n') {
                break;
            }

            if ('a' <= value && value <= 'z') {
                counts[value - 'a']++;
            } else if ('A' <= value && value <= 'Z') {
                counts[value - 'A']++;
            }
        }

        int maxCount = -1;
        char ch = ' ';
        
        for (int i = 0; i < 26; i++) {
            if (maxCount < counts[i]) {
                maxCount = counts[i];
                ch = (char) (i + 'A');
            } else if (maxCount == counts[i]) {
                ch = '?';
            }
        }

        System.out.println(ch);
    }
}