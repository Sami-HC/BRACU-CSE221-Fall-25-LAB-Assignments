import java.io.*;
import java.util.StringTokenizer;
public class ProblemC {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        StringTokenizer s1 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(s1.nextToken());
        int [][] arr = new int [n][n];

        for (int i = 0; i<arr.length; i++) {
            StringTokenizer s2 = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(s2.nextToken());
            for (int j = 0; j<m; j++) {
                int v = Integer.parseInt(s2.nextToken());
                arr[i][v]=1;
            }
        }
        for (int r = 0; r<arr.length; r++) {
            for (int c = 0; c<arr[0].length; c++) {
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