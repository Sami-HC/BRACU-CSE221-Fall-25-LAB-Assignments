import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class ProblemC {
    public static int count = -1;
    public static boolean [][] visited;
    public static int n;
    public static PrintWriter pr = new PrintWriter(System.out);
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visited = new boolean [n+1][n+1];

        StringTokenizer s1 = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(s1.nextToken());
        int y = Integer.parseInt(s1.nextToken());
        int k = Integer.parseInt(s1.nextToken());
        int l = Integer.parseInt(s1.nextToken());

        if (x==k && y==l) {
            pr.print("0");
        }
        else {
            bfs(x, y, k, l);
            pr.print(count);
        }

        br.close();
        pr.close();
    }
    public static void bfs (int x, int y, int k, int l) {
        Queue <Integer> kq = new LinkedList<>();
        Queue <Integer> lq = new LinkedList<>();
        Queue <Integer> moves = new LinkedList<>();
        visited[x][y] = true;
        kq.add(x);
        lq.add(y);
        moves.add(1);
 
        while (!kq.isEmpty() && count==-1) {
 
            int cx = kq.poll();
            int cy = lq.poll();
            int cmoves = moves.poll();
 
            for (int r = cx-1; r<=cx+1; r+=2) {
                if (count!=-1) {
                    break;
                }
                for (int c = cy-2; c<=cy+2; c+=4) {
                    if (count!=-1) {
                        break;
                    }
                    if (r>0 && r<=n && c>0 && c<=n) {
                        if (r==k && c==l) {
                            count = cmoves;
                        }
                        else {
                            if (visited[r][c]==false) {
                                kq.add(r);
                                lq.add(c);
                                moves.add(cmoves+1);
                                visited[r][c] = true;
                            }
                        }
                    }
                }
            }
            for (int c = cy-1; c<=cy+1; c+=2) {
                if (count!=-1) {
                    break;
                }
                for (int r = cx-2; r<=cx+2; r+=4) {
                    if (count!=-1) {
                        break;
                    }
                    if (r>0 && r<=n && c>0 && c<=n) {
                        if (r==k && c==l) {
                            count = cmoves;
                        }
                        else {
                            if (visited[r][c]==false) {
                                kq.add(r);
                                lq.add(c);
                                moves.add(cmoves+1);
                                visited[r][c] = true;
                            }
                        }
                    }
                }
            }
        }
    }
}