import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int time = 0;

        while (true) {
            int s = System.in.read();

            if (s == 10) break; // LF

            if (s <= 67) time += 3;
            else if (s <= 70) time += 4;
            else if (s <= 73) time += 5;
            else if (s <= 76) time += 6;
            else if (s <= 79) time += 7;
            else if (s <= 83) time += 8;
            else if (s <= 86) time += 9;
            else time += 10;
        }

        System.out.println(time);
    }
}