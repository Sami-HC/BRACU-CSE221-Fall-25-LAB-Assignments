import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class ProblemA {
    public static edge [] arr;
    public static PrintWriter pr = new PrintWriter(System.out);
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s1 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(s1.nextToken());
        arr = new edge [n+1];

        int m = Integer.parseInt(s1.nextToken());
        for (int i = 0; i<m; i++) {
            StringTokenizer s2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(s2.nextToken());
            int v = Integer.parseInt(s2.nextToken());
            build (u, v);
            build (v, u);
        }
        bfs(arr);
        br.close();
        pr.close();
    }
    public static void build (int from, int to) {
        edge temp = new edge (to);
        temp.next = arr[from];
        arr[from] = temp;
    }
    public static void bfs (edge [] arr) {
        boolean [] visited = new boolean [arr.length];
        Queue <Integer> q = new LinkedList<>();
        for (int i = 1; i<visited.length; i++) {
            if (visited[i]==false) {

                visited[i] = true;
                if (i==1) {
                    pr.print(i);
                }
                else {
                    pr.print(" "+i);
                }
                q.add(i);

                while (!q.isEmpty()) {

                    int current = q.poll();

                    edge temp = arr[current];
                    while (temp!=null) {
                        int check = temp.to;
                        if (visited[check]==false) {
                            visited[check] = true;
                            pr.print(" "+check);
                            q.add(check);
                        }
                        temp = temp.next;
                    }
                }

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