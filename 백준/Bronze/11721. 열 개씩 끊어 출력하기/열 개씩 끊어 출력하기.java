import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        for (int i = 0; i < a.length(); i++) {
            System.out.print(a.charAt(i));
            if (i % 10 == 9) {
                System.out.println();
            }
        }
    }
}