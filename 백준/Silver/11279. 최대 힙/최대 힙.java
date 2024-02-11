// max heap implement
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        MaxHeap maxHeap = new MaxHeap(n);
        while(n-- > 0) {    // n번 반복
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                bw.write(maxHeap.pop() + "\n");
            } else {
                maxHeap.push(x);
            }
        }
        bw.flush();
        bw.close();
    }
}

class MaxHeap {
    static int[] heap;
    static int size;

    public MaxHeap(int n) {
        heap = new int[n + 1];
        size = 0;
    }

    public void push(int x) {   // shift up
        heap[++size] = x;
        int current = size;
        while(current > 1) {    // 현재가 루트노드이면 break
            int parent = current / 2;
            if (heap[parent] >= heap[current]) {
                break;
            }
            swap(parent, current);
            current = parent;
        }
    }

    public int pop() {  // shift down
        if (size == 0) {
            return 0;
        }
        int result = heap[1];
        heap[1] = heap[size--];
        int current = 1;
        while(current * 2 <= size) {    // 왼쪽 자식노드가 없으면 break
            int left = current * 2;
            int right = left + 1;
            int child = left;
            if (right <= size && heap[left] < heap[right]) {    // right > size 이면, 비교안함
                child = right;
            }
            if (heap[current] >= heap[child]) {
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
