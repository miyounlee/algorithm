import java.util.*;

public class Main {
    static int N, M;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = i + 1;
        }

        LinkedList<Integer> curr = new LinkedList<>();
        backtrack(curr);
        System.out.println(sb);
    }

    public static void backtrack(LinkedList<Integer> curr) {
        if (curr.size() == M) {
            for (int i : curr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int num : nums) {
            if (!curr.contains(num)) {
                curr.addLast(num);
                backtrack(curr);
                curr.removeLast();
            }
        }
    }
}