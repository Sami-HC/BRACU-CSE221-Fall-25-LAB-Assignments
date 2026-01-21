import java.io.*;
import java.util.StringTokenizer;
public class ProblemH {
    public static store [] arr;
    public static int n;
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        StringTokenizer s1 = new StringTokenizer(br.readLine());

        int nn = Integer.parseInt(s1.nextToken());
        n = nn;
        arr = new store [n+1];

        for (int i = 1; i<=n; i++) {
            for (int j = i+1; j<=n; j++) {
                if (gcd(i,j)==1) {
                    build(i,j);
                    build(j,i);
                }
            }
        }

        int m = Integer.parseInt(s1.nextToken());

        for (int i = 0; i<m; i++) {

            if (i!=0) {
                pr.print("\n");
            }

            StringTokenizer s2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(s2.nextToken());
            int k = Integer.parseInt(s2.nextToken());

            if (arr[x]==null || k>arr[x].count) {
                pr.print(-1);
            }
            else {
                pr.print(arr[x].starr[k]);
            }
        }
        
        br.close();
        pr.close();
    }
    public static void build (int from, int to) {
        if (arr[from]==null) {
            arr[from] = new store (n);
        }
        store tar = arr[from];
        tar.count += 1;
        tar.starr[tar.count] = to;
    }
    public static int gcd (int from, int to) {
        while (to!=0) {
            int temp = to;
            to = from%to;
            from = temp;
        }
        return from;
    }
}
class store {
    int count = 0;
    int [] starr = null;
    public store (int n) {
        this.starr = new int [n];
    }
}