import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class ProblemG {
    public static char [] [] arr;
    public static boolean [] [] visited;
    public static int count = 0;
    public static int fcount = 0;
    public static PrintWriter pr = new PrintWriter(System.out);
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s1 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(s1.nextToken());
        int m = Integer.parseInt(s1.nextToken());
        arr = new char [n][m];
        visited = new boolean[n][m];

        for (int i = 0; i<n; i++) {
            String s2 = br.readLine();
            for (int j = 0; j<m; j++) {
                arr[i][j] = s2.charAt(j);
                if (arr[i][j]=='#') {
                    visited[i][j] = true;
                }
            }
        }

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (visited[i][j]==false) {
                    count = 0;
                    bfs(arr, i,j);
                    if (count > fcount) {
                        fcount = count;
                    }
                }
            }
        }

        pr.print(fcount);

        br.close();
        pr.close();
    }
    public static void bfs (char [][] arr, int r, int c) {
        Queue <Integer> rq = new LinkedList<>();
        Queue <Integer> cq = new LinkedList<>();

        visited[r][c] = true;
        if (arr[r][c] == 'D') {
            count += 1;
        }
        rq.add(r);
        cq.add(c);

        while (!rq.isEmpty() && !cq.isEmpty()) {
            int rt = rq.poll();
            int ct = cq.poll();

            for (int i = rt-1; i<=rt+1; i+=2) {
                int j = ct;
                if (i>=0 && i<arr.length && j>=0 && j<arr[0].length) {
                    if (visited[i][j]==false) {
                        visited[i][j] = true;
                        if (arr[i][j] == 'D') {
                            count += 1;
                        }
                        rq.add(i);
                        cq.add(j);
                    }
                }
            }
            
            for (int j = ct-1; j<=ct+1; j+=2) {
                int i = rt;
                if (i>=0 && i<arr.length && j>=0 && j<arr[0].length) {
                    if (visited[i][j]==false) {
                        visited[i][j] = true;
                        if (arr[i][j] == 'D') {
                            count += 1;
                        }
                        rq.add(i);
                        cq.add(j);
                    }
                }
            }
        }
    }
}
