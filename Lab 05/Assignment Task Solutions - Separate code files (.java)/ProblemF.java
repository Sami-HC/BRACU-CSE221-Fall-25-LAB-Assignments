import java.io.*;
import java.util.StringTokenizer;
public class ProblemF {
    public static edge [] arr;
    public static boolean [] visited;
    public static boolean [] instack;
    public static String s = "NO";
    public static PrintWriter pr = new PrintWriter(System.out);
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s1 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(s1.nextToken());
        arr = new edge [n+1];
        visited = new boolean[n+1];
        instack = new boolean[n+1];
        int m = Integer.parseInt(s1.nextToken());
 
        for (int i = 0; i<m; i++) {
            StringTokenizer s2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(s2.nextToken());
            int v = Integer.parseInt(s2.nextToken());
            build (u, v);
        }

        for (int i = 1; i<n+1; i++) {
            if (s.equals("NO") && visited[i]==false) {
                dfs(arr, i);
            }
        }
 
        pr.print(s);

        br.close();
        pr.close();
    }
    public static void build (int from, int to) {
        edge temp = new edge (to);
        temp.next = arr[from];
        arr[from] = temp;
    }
    public static void dfs (edge [] arr, int i) {
        visited[i] = true;
        instack[i] = true;

        edge temp = arr[i];
        while (temp!=null && s.equals("NO")) {
            int check = temp.to;
            if (visited[check]==false) {
                dfs (arr, check);
            }
            else if (instack[check]==true) {
                s = "YES";
            }
            temp = temp.next;
        }
        instack[i] = false;
    }
}
class edge {
    int to;
    edge next = null;
    public edge (int to) {
        this.to = to;
    }
}