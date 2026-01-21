import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class ProblemB {
    public static ArrayList <Integer> [] arrto;
    public static ArrayList <Long> [] arrweight;
    public static long inf = Long.MAX_VALUE;
    public static PriorityQueue <long []> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
    public static long [] dis1;
    public static long [] dis2;
    public static PrintWriter pr = new PrintWriter(System.out);
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s1 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(s1.nextToken());
        arrto = new ArrayList [n+1];
        arrweight = new ArrayList [n+1];
        dis1 = new long [n+1];
        dis2 = new long [n+1];

        int m = Integer.parseInt(s1.nextToken());
        for (int i = 0; i<m; i++) {
            StringTokenizer s2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(s2.nextToken());
            int v = Integer.parseInt(s2.nextToken());
            long w = Long.parseLong(s2.nextToken());
            build (u, v, w);
        }

        int x = Integer.parseInt(s1.nextToken());
        int y = Integer.parseInt(s1.nextToken());

        for (int i = 1; i<dis1.length; i++) {
            if (i==x) {
                dis1[i] = 0;
                pq.add(new long [] {dis1[i], i});
            }
            else {
                dis1[i] = inf;
            }
        }

        bfs(x, dis1);

        pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        for (int i = 1; i<dis2.length; i++) {
            if (i==y) {
                dis2[i] = 0;
                pq.add(new long [] {dis2[i], i});
            }
            else {
                dis2[i] = inf;
            }
        }
        bfs(y, dis2);

        long findis = inf;
        int finindex = 0;
        for (int i = 1; i<dis1.length; i++) {
            if (dis1[i]!=inf && dis2[i]!=inf) {
                long tempdis = Math.max(dis1[i], dis2[i]);
                if (tempdis < findis) {
                    findis = tempdis;
                    finindex = i;                     
                }
            }
        }

        if (findis==inf) {
            pr.print(-1);
        }
        else {
            pr.print(findis+" "+finindex);
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
    public static void bfs (int x, long [] dis) {
        while (!pq.isEmpty()) {
 
            long [] carr = pq.poll();
            int current = (int)(carr[1]);
 
            if (arrto[current]!=null) {
                for (int i = 0; i<arrto[current].size(); i++) {
                    int chnode = arrto[current].get(i);
                    long chweight = arrweight[current].get(i);
                    long tempweight = dis[current] + chweight;

                    if (tempweight < dis[chnode]) {
                        dis[chnode] = tempweight;
                        pq.add(new long [] {dis[chnode], chnode});
                    }
                }
            }
        }
    }
}