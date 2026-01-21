import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class ProblemA {
    public static ArrayList <Integer> [] arrto;
    public static ArrayList <Long> [] arrweight;
    public static long inf = Long.MAX_VALUE;
    public static PriorityQueue <long []> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
    public static long [] dis;
    public static int [] parent;
    public static PrintWriter pr = new PrintWriter(System.out);
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s1 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(s1.nextToken());
        arrto = new ArrayList [n+1];
        arrweight = new ArrayList [n+1];
        dis = new long [n+1];
        parent = new int [n+1];
 
        StringTokenizer s2 = new StringTokenizer(br.readLine());
        StringTokenizer s3 = new StringTokenizer(br.readLine());
        StringTokenizer s4 = new StringTokenizer(br.readLine());


        int m = Integer.parseInt(s1.nextToken());
        for (int i = 0; i<m; i++) {
            int u = Integer.parseInt(s2.nextToken());
            int v = Integer.parseInt(s3.nextToken());
            long w = Long.parseLong(s4.nextToken());
            build (u, v, w);
        }

        int x = Integer.parseInt(s1.nextToken());
        int y = Integer.parseInt(s1.nextToken());

        for (int i = 1; i<dis.length; i++) {
            if (i==x) {
                dis[i] = 0;
                pq.add(new long [] {dis[i], i});
            }
            else {
                dis[i] = inf;
            }
        }

        bfs(x);

        if (x==y) {
            pr.println(0);
            pr.print(x);
        }
        else if (parent[y]==0) {
            pr.print(-1);
        }
        else {
            pr.println(dis[y]);
            String pathprint = "";
            int check = y;
            while (check != x) {
                pathprint = " " + check + pathprint;
                check = parent[check];
            }
            pr.print(x + pathprint);
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
 
            if (arrto[current]!=null) {
                for (int i = 0; i<arrto[current].size(); i++) {
                    int chnode = arrto[current].get(i);
                    long chweight = arrweight[current].get(i);
                    long tempweight = dis[current] + chweight;

                    if (tempweight < dis[chnode]) {
                        dis[chnode] = tempweight;
                        parent[chnode] = current;
                        pq.add(new long [] {dis[chnode], chnode});
                    }
                }
            }
        }
    }
}