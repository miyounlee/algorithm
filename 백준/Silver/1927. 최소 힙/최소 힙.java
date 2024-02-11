// min heap implement
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        MinHeap minHeap = new MinHeap(n);
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                bw.write(minHeap.pop() + "\n");
            } else {
                minHeap.push(x);
            }
        }
        bw.flush();
        bw.close();
    }
}

class MinHeap {
    static int[] heap;
    static int size;

    public MinHeap(int n) {
        heap = new int[n + 1];
        size = 0;
    }

    public void push(int x) {
        heap[++size] = x;
        int current = size;
        while (current > 1) {
            int parent = current / 2;
            if (heap[parent] <= heap[current]) {
                break;
            }
            swap(parent, current);
            current = parent;
        }
    }

    public int pop() {
        if (size == 0) {
            return 0;
        }
        int result = heap[1];
        heap[1] = heap[size--];
        int current = 1;
        while (current * 2 <= size) {
            int left = current * 2;
            int right = left + 1;
            int child = left;
            if (right <= size && heap[right] < heap[left]) {
                child = right;
            }
            if (heap[current] <= heap[child]) {
                break;
            }
            swap(current, child);
            current = child;
        }
        return result;
    }

    private void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

}
