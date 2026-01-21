import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class ProblemE {
    public static ArrayList <Integer> [] arr;
    public static int [] sources;
    public static int [] dests;
    public static int [] dis;
    public static boolean [] visited;
    public static PrintWriter pr = new PrintWriter(System.out);
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s1 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(s1.nextToken());
        arr = new ArrayList [n+1];
        dis = new int [n+1];
        Arrays.fill(dis, -1);
        visited = new boolean [n+1];
 
        int m = Integer.parseInt(s1.nextToken());
        for (int i = 0; i<m; i++) {
            StringTokenizer s2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(s2.nextToken());
            int v = Integer.parseInt(s2.nextToken());
            build (u, v);
            build (v, u);
        }

        int p = Integer.parseInt(s1.nextToken());
        sources = new int [p];
        StringTokenizer s3 = new StringTokenizer(br.readLine());
        for (int i = 0; i<sources.length; i++) {
            sources[i] = Integer.parseInt(s3.nextToken());
        }

        int k = Integer.parseInt(s1.nextToken());
        dests = new int [k];
        StringTokenizer s4 = new StringTokenizer(br.readLine());
        for (int i = 0; i<dests.length; i++) {
            dests[i] = Integer.parseInt(s4.nextToken());
        }


        bfs(arr);

        for (int i = 0; i<dests.length; i++) {
            if (i!=0) {
                pr.print(" ");
            }
            pr.print(dis[dests[i]]);
        }

        br.close();
        pr.close();
    }
    public static void build (int from, int to) {
        if (arr[from]==null) {
            arr[from] = new ArrayList<>();
        }
        arr[from].add(to);
    }
    public static void bfs (ArrayList <Integer> [] arr) {

        Queue <Integer> q = new LinkedList<>();
        Queue <Integer> disq = new LinkedList<>();

        for (int i = 0; i<sources.length; i++) {
            visited[sources[i]] = true;
            q.add(sources[i]);
            disq.add(1);
            dis[sources[i]] = 0;
        }
 
        while (!q.isEmpty()) {
 
            int current = q.poll();
            int cdis = disq.poll();
 
            if (arr[current]!=null) {
                for (int i = 0; i<arr[current].size(); i++) {
                    int check = arr[current].get(i);
                    if (visited[check]==false) {
                        dis[check] = cdis;
                        visited[check] = true;
                        q.add(check);
                        disq.add(cdis+1);
                    }
                }
            }
        }
    }
}