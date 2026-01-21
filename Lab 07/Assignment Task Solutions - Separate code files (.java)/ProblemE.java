import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class ProblemE {
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

        for (int i = 1; i<dis.length; i++) {
            if (i==1) {
                dis[i][0] = 0;
                dis[i][1] = 0;
                pq.add(new long [] {dis[i][0], i});
                pq.add(new long [] {dis[i][1], i});
            }
            else {
                dis[i][0] = inf;
                dis[i][1] = inf;
            }
        }

        bfs(1);

        if (1==n) {
            pr.println(0);
        }
        else if (dis[n][0]==inf && dis[n][1]==inf) {
            pr.print(-1);
        }
        else {
            long temp = Math.min(dis[n][0], dis[n][1]);
            pr.print(temp);
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

                    if (chweight%2==0 && dis[current][1]!=inf) {
                        Long tempweight = dis[current][1] + chweight;
                        if (tempweight < dis[chnode][0]) {
                            dis[chnode][0] = tempweight;
                            pq.add(new long [] {dis[chnode][0], chnode});
                        }
                    }

                    else if (chweight%2!=0 && dis[current][0]!=inf){
                        Long tempweight = dis[current][0] + chweight;
                        if (tempweight < dis[chnode][1]) {
                            dis[chnode][1] = tempweight;
                            pq.add(new long [] {dis[chnode][1], chnode});
                        }
                    }
                }
            }
        }
    }
}