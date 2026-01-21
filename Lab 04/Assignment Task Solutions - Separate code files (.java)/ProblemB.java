import java.io.*;
import java.util.StringTokenizer;
public class ProblemB {
    public static edge [] arr;
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        StringTokenizer s1 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(s1.nextToken());
        arr = new edge [n+1];

        StringTokenizer s2 = new StringTokenizer(br.readLine());
        StringTokenizer s3 = new StringTokenizer(br.readLine());
        StringTokenizer s4 = new StringTokenizer(br.readLine());


        int m = Integer.parseInt(s1.nextToken());
        for (int i = 0; i<m; i++) {
            int u = Integer.parseInt(s2.nextToken());
            int v = Integer.parseInt(s3.nextToken());
            int w = Integer.parseInt(s4.nextToken());
            build (u, v, w);
        }

        for (int i = 1; i<arr.length; i++) {
            pr.print(i+":");
            edge temp = arr[i];
            while (temp!=null) {
                pr.print(" ("+temp.to+","+temp.weight+")");
                temp = temp.next;
            }
            pr.print("\n");
        }
        br.close();
        pr.close();
    }
    public static void build (int from, int to, int weight) {
        edge temp = new edge (to, weight);
        temp.next = arr[from];
        arr[from] = temp;
    }
}
class edge {
    int to;
    int weight;
    edge next = null;
    public edge (int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}