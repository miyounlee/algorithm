import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] tree;
    static boolean[] isVisit;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        tree = new List[n + 1];
        isVisit = new boolean[n + 1];
        parents = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int str = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            tree[str].add(dst);
            tree[dst].add(str);
        }

        find(1);
        for (int i = 2; i <= n; i++) {
            bw.write(parents[i] + "\n");
        }

        bw.flush();
    }

    public static void find(int nodeNum) {
        isVisit[nodeNum] = true;
        for (int i = 0; i < tree[nodeNum].size(); i++) {
            int child = tree[nodeNum].get(i);
            if (!isVisit[child]) {
                parents[child] = nodeNum;
                find(child);
            }
        }
    }
}
