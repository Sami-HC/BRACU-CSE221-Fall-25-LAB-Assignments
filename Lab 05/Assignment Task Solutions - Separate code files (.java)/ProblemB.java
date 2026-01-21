import java.io.*;
import java.util.StringTokenizer;
public class ProblemB {
    public static edge [] arr;
    public static boolean [] visited;
    public static PrintWriter pr = new PrintWriter(System.out);
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s1 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(s1.nextToken());
        arr = new edge [n+1];
        visited = new boolean[n+1];

        StringTokenizer s2 = new StringTokenizer(br.readLine());
        StringTokenizer s3 = new StringTokenizer(br.readLine());


        int m = Integer.parseInt(s1.nextToken());
        for (int i = 0; i<m; i++) {
            int u = Integer.parseInt(s2.nextToken());
            int v = Integer.parseInt(s3.nextToken());
            build (u, v);
            build (v, u);
        }
        dfs(arr, 1);
        br.close();
        pr.close();
    }
    public static void build (int from, int to) {
        edge temp = new edge (to);
        temp.next = arr[from];
        arr[from] = temp;
    }
    public static void dfs (edge [] arr, int i) {
        if (visited[i]==false) {

            visited[i] = true;
            if (i==1) {
                pr.print(i);
            }
            else {
                pr.print(" "+i);
            }

            edge temp = arr[i];
            while (temp!=null) {
                int check = temp.to;
                if (visited[check]==false) {
                    dfs (arr, check);
                }
                temp = temp.next;
            }
        }
    }
}
class edge {
    int to;
    edge next = null;
    public edge (int to) {
        this.to = to;
    }
}