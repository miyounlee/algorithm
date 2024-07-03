import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long[] array;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        array = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = Long.parseLong(br.readLine());
        }

        SegmentTree segmentTree = new SegmentTree(n);

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            
            if (a == 1) {
                segmentTree.update(1, 1, n, b, c - array[b]);
                array[b] = c;
            } else if (a == 2) {
                bw.write(segmentTree.prefixSum(1, 1, n, b, c) + "\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}

class SegmentTree {
    long[] tree;

    public SegmentTree (int arrayLength) {
        int height = (int) Math.ceil(Math.log(arrayLength) / Math.log(2));
        int size = (int) Math.pow(2, height + 1); 
        tree = new long[size];
        initTree(1, 1, arrayLength);
    }

    private long initTree(int curr, int start, int end) {
        if (start == end) {
            return tree[curr] = Main.array[start];
        }
        return tree[curr] = initTree(2 * curr, start, (start + end) / 2)
                + initTree(2 * curr + 1, (start + end) / 2 + 1, end);
    }

    public void update (int curr, int start, int end, int index, long diff) {
        if (index < start || end < index) return;

        tree[curr] += diff;

        if (start != end) {
            update(2 * curr, start, (start + end) / 2, index, diff);
            update(2 * curr + 1, (start + end) / 2 + 1, end, index, diff);
        }
    }

    /**
     * 구간의 범위 : src ~ des
     * 노드의 범위 : start ~ end
     */
    public long prefixSum(int curr, int start, int end, int src, long des) {
        // 구간이 노드의 범위에서 완전히 벗어났을 경우
        if (src > end || des < start) return 0;
        // 노드의 범위가 구간안에 완전히 들어왔을 경우
        if (src <= start && end <= des) return tree[curr];

        return prefixSum(2 * curr, start, (start + end) / 2, src, des)
                + prefixSum(2 * curr + 1, (start + end) / 2 + 1, end, src, des);
    }


}