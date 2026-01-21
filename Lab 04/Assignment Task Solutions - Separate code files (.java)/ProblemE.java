import java.io.*;
import java.util.StringTokenizer;
public class ProblemE {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        StringTokenizer s1 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(s1.nextToken());
        int [] arr = new int [n+1];

        StringTokenizer s2 = new StringTokenizer(br.readLine());
        StringTokenizer s3 = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(s1.nextToken());
        for (int i = 0; i<m; i++) {
            int u = Integer.parseInt(s2.nextToken());
            int v = Integer.parseInt(s3.nextToken());
            arr[u] -= 1;
            arr[v] += 1;
        }
        for (int i = 1; i<arr.length; i++) {
            if (i!=arr.length-1) {
                pr.print(arr[i]+" ");
            }
            else {
                pr.print(arr[i]);
            }
        }
        br.close();
        pr.close();
    }
}