import java.io.*;
import java.util.StringTokenizer;
public class ProblemE {
    public static edge [] arr;
    public static boolean [] visited;
    public static int [] gsize;
    public static PrintWriter pr = new PrintWriter(System.out);
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s1 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(s1.nextToken());
        arr = new edge [n+1];
        visited = new boolean[n+1];
        gsize = new int [n+1];
        int m = Integer.parseInt(s1.nextToken());
 
        for (int i = 0; i<n-1; i++) {
            StringTokenizer s2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(s2.nextToken());
            int v = Integer.parseInt(s2.nextToken());
            build (u, v);
            build (v, u);
        }

        int tsize = dfs(arr, m);
 
        int p = Integer.parseInt(br.readLine());
        for (int i = 0; i<p; i++) {
            int x = Integer.parseInt(br.readLine());
            pr.println(gsize[x]);
        }

        br.close();
        pr.close();
    }
    public static void build (int from, int to) {
        edge temp = new edge (to);
        temp.next = arr[from];
        arr[from] = temp;
    }
    public static int dfs (edge [] arr, int i) {
        int size = 0;
        visited[i] = true;
        size += 1;

        edge temp = arr[i];
        while (temp!=null) {
            int check = temp.to;
            if (visited[check]==false) {
                size += dfs (arr, check);
            }
            temp = temp.next;
        }
        gsize[i] = size;
        return size;
    }
}
class edge {
    int to;
    edge next = null;
    public edge (int to) {
        this.to = to;
    }
}