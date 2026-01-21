import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class ProblemD {
    public static ArrayList <Integer> [] arrto;
    public static long [] weight;
    public static long inf = Long.MAX_VALUE;
    public static PriorityQueue <long []> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
    public static long [] dis;
    public static PrintWriter pr = new PrintWriter(System.out);
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s1 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(s1.nextToken());
        arrto = new ArrayList [n+1];
        weight = new long [n+1];
        dis = new long [n+1];

        StringTokenizer s3 = new StringTokenizer(br.readLine());
        for (int i = 1; i<weight.length; i++) {
            weight[i] = Long.parseLong(s3.nextToken());
        }
 
        int m = Integer.parseInt(s1.nextToken());
        for (int i = 0; i<m; i++) {
            StringTokenizer s2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(s2.nextToken());
            int v = Integer.parseInt(s2.nextToken());
            build (u, v);
        }

        int x = Integer.parseInt(s1.nextToken());
        int y = Integer.parseInt(s1.nextToken());

        for (int i = 1; i<dis.length; i++) {
            if (i==x) {
                dis[i] = weight[i];
                pq.add(new long [] {dis[i], i});
            }
            else {
                dis[i] = inf;
            }
        }

        bfs(x);

        if (x==y) {
            pr.println(dis[x]);
        }
        else if (dis[y]==inf) {
            pr.print(-1);
        }
        else {
            pr.print(dis[y]);
        }

        br.close();
        pr.close();
    }
    public static void build (int from, int to) {
        if (arrto[from]==null) {
            arrto[from] = new ArrayList<>();
        }
        arrto[from].add(to);
    }
    public static void bfs (int x) {
        while (!pq.isEmpty()) {
 
            long [] carr = pq.poll();
            int current = (int)(carr[1]);
 
            if (arrto[current]!=null) {
                for (int i = 0; i<arrto[current].size(); i++) {
                    int chnode = arrto[current].get(i);
                    long tempweight = dis[current] + weight[chnode];

                    if (tempweight < dis[chnode]) {
                        dis[chnode] = tempweight;
                        pq.add(new long [] {dis[chnode], chnode});
                    }
                }
            }
        }
    }
}