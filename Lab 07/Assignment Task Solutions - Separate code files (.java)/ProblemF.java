import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class ProblemF {
    public static ArrayList <Integer> [] arrto;
    public static ArrayList <Long> [] arrweight;
    public static long inf = Long.MAX_VALUE;
    public static PriorityQueue <long []> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
    public static long [][] dis;
    public static PrintWriter pr = new PrintWriter(System.out);
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s1 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(s1.nextToken());
        arrto = new ArrayList [n+1];
        arrweight = new ArrayList [n+1];
        dis = new long [n+1][2];
 
        int m = Integer.parseInt(s1.nextToken());
        for (int i = 0; i<m; i++) {
            StringTokenizer s2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(s2.nextToken());
            int v = Integer.parseInt(s2.nextToken());
            long w = Long.parseLong(s2.nextToken());
            build (u, v, w);
            build (v, u, w);
        }

        int x = Integer.parseInt(s1.nextToken());
        int y = Integer.parseInt(s1.nextToken());

        for (int i = 1; i<dis.length; i++) {
            if (i==x) {
                dis[i][0] = 0;
                dis[i][1] = inf;
                pq.add(new long [] {dis[i][0], i});
            }
            else {
                dis[i][0] = inf;
                dis[i][1] = inf;
            }
        }

        bfs(x);

        if (dis[y][0]==inf || dis[y][1]==inf) {
            pr.println(-1);
        }
        else {
            pr.print(dis[y][1]);
        }

        br.close();
        pr.close();
    }
    public static void build (int from, int to, long weight) {
        if (arrto[from]==null) {
            arrto[from] = new ArrayList<>();
            arrweight[from] = new ArrayList<>();
        }
        arrto[from].add(to);
        arrweight[from].add(weight);
    }
    public static void bfs (int x) {
        while (!pq.isEmpty()) {
 
            long [] carr = pq.poll();
            int current = (int)(carr[1]);
            long currentweight = carr[0];
 
            if (arrto[current]!=null) {
                for (int i = 0; i<arrto[current].size(); i++) {
                    int chnode = arrto[current].get(i);
                    long chweight = arrweight[current].get(i);
                    long tempweight = currentweight + chweight;

                    if (tempweight < dis[chnode][0]) {
                        dis[chnode][1] = dis[chnode][0];
                        dis[chnode][0] = tempweight;
                        pq.add(new long [] {dis[chnode][0], chnode});
                    }
                    else if (tempweight > dis[chnode][0] && tempweight < dis[chnode][1]) {
                        dis[chnode][1] = tempweight;
                        pq.add(new long [] {dis[chnode][1], chnode});
                    }
                }
            }
        }
    }
}