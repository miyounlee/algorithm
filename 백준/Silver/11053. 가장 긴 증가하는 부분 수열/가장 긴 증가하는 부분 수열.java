import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int[] length = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 1; 
        for (int i = 0; i < n - 1; i++) {
            if (length[i] == 0) {
                length[i] = 1;
            }
            for (int j = i + 1; j < n; j++) {
                if ((nums[j] > nums[i]) && (length[j] < length[i] + 1)) {
                    length[j] = length[i] + 1;
                    answer = Math.max(answer, length[j]);
                }
            }
        }
        System.out.println(answer);
    }
}