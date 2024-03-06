import java.util.*;

public class Main {
    static int N, M;
    static int[] nums;
    static LinkedList<Integer> result = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        nums = new int[N];
        // nums 초기화
        for (int i = 0; i < N; i++) {
            nums[i] = i + 1;
        }
        backtrack(0);
        System.out.println(sb);
    }

    public static void backtrack(int start) {
        if (result.size() == M) {
            for (int i : result) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < N; i++) {
            result.addLast(nums[i]);
            backtrack(i + 1);
            result.removeLast();
        }
    }
}