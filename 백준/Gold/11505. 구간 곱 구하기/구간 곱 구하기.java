import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        array = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        SegmentTree segmentTree = new SegmentTree(n); 

        for (int i = 0; i < m + k; i++) {   
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                segmentTree.update(1, 1, n, b, c); 
            } else if (a == 2) {
                bw.write(segmentTree.prefixMulti(1,1, n, b, c) + "\n"); 
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}

class SegmentTree {
    static int MOD = 1000000007;
    private long[] tree;

    public SegmentTree(int n) {
        int height = (int) Math.ceil((Math.log(n) / Math.log(2)));
        int size = (int) Math.pow(2, height + 1);
        tree = new long[size];
        init(1, 1, n);
    }

    private long init(int curr, int start, int end) { 
        if (start == end) {
            return tree[curr] = Main.array[start];
        }
        return tree[curr] = (init(2 * curr, start, (start + end) / 2) * init(2 * curr + 1, (start + end) / 2 + 1, end)) % MOD;
    }

    public long update(int curr, int start, int end, int index, int value) { 
        if (index < start || end < index) {
            return tree[curr];
        }
        if (start == end) {
            return tree[curr] = value;
        }
        return tree[curr] = (update(2 * curr, start, (start + end) / 2, index, value) * update(2 * curr + 1, (start + end) / 2 + 1, end, index, value)) % MOD;

    }

    public long prefixMulti(int curr, int start, int end, int src, int dest) {
        if (dest < start || end < src) {
            return 1;
        }
        if (src <= start && end <= dest) {
            return tree[curr];
        }
        return (prefixMulti(2 * curr, start, (start + end) / 2, src, dest) * prefixMulti(2 * curr + 1, (start + end) / 2 + 1, end, src, dest)) % MOD;
    }
}