import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        int alphabet;
        int index;
        int[] array = new int[26];
        Arrays.fill(array, -1);

        for (int i = 0; i < 100; i++) {
            alphabet = System.in.read();
            if (alphabet == 10) {
                break;
            }
            index = alphabet - 97;
            if (array[index] == -1) {
                array[index] = i;
            }
        }

        for (int val : array) {
            System.out.print(val + " ");
        }
    }
}