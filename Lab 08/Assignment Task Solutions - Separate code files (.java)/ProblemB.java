import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ProblemB {
    public static int [] parent;
    public static long [] size;
    public static int count = 0;
    public static PriorityQueue <int []> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        parent = new int [n+1];
        size = new long [n+1];
        for (int i = 1; i<n+1; i++) {
            parent[i] = i;
            size[i] = 0;
        }

        int m = Integer.parseInt(st1.nextToken());
        for (int i = 0; i<m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());
            int w = Integer.parseInt(st2.nextToken());

            pq.add(new int [] {w, u, v});
        }

        while (count < n-1) {
            int [] tarr = pq.poll();
            int up = find(tarr[1]);
            int vp = find(tarr[2]);
            if (up != vp) {
                count++;
                long tsize = size[up] + size[vp] + tarr[0];
                if (size[up] > size[vp]) {
                    size[up] = tsize;
                    parent[vp] = up;
                }
                else {
                    size[vp] = tsize;
                    parent[up] = vp;
                }
            }
        }

        for (int i = 1; i<n+1; i++) {
            if (parent[i] == i) {
                pr.print(size[i]);
            }
        }

        br.close();
        pr.close();
    }
    public static int find (int k) {
        while (true) {
            if (parent[k] == k) {
                return k;
            }
            else {
                k = parent[k];
            }
        }
    }
}
