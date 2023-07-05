import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (true) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if (a == 0 && b == 0) break;
            sb.append(a + b).append("\n");
        }

        System.out.println(sb);

    }
}