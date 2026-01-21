import java.io.*;
import java.util.StringTokenizer;
public class ProblemD {
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
            arr[u] += 1;
            arr[v] += 1;
        }
        int check = 0;
        for (int i = 1; i<arr.length; i++) {
            if (arr[i]%2!=0) {
                check += 1;
            }
        }
        if (check==0 || check ==2) {
            pr.print("YES");
        }
        else {
            pr.print("NO");
        }
        br.close();
        pr.close();
    }
}