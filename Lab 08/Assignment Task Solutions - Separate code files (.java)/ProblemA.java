import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProblemA {
    public static int [] parent;
    public static int [] size;
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        parent = new int [n+1];
        size = new int [n+1];
        for (int i = 1; i<n+1; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int m = Integer.parseInt(st1.nextToken());
        for (int i = 0; i<m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());

            int up = find(u);
            int vp = find(v);
            if (up == vp) {
                pr.println(size[up]);
            }
            else {
                int tsize = size[up] + size[vp];
                pr.println(tsize);
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
