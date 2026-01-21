import java.io.*;
import java.util.StringTokenizer;
public class ProblemA {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        StringTokenizer s1 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(s1.nextToken());
        int [][] arr = new int [n+1][n+1];

        int m = Integer.parseInt(s1.nextToken());
        for (int i = 0; i<m; i++) {
            StringTokenizer s2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(s2.nextToken());
            int v = Integer.parseInt(s2.nextToken());
            int w = Integer.parseInt(s2.nextToken());
            arr [u][v] = w;
        }
        for (int r = 1; r<arr.length; r++) {
            for (int c = 1; c<arr[0].length; c++) {
                if (c<arr[0].length-1) {
                    pr.print(arr[r][c]+" ");
                }
                else {
                    pr.print(arr[r][c]+"\n");
                }
            }
        }
        br.close();
        pr.close();
    }
}