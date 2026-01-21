import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class ProblemB {
    public static ArrayList <Integer> [] arr;
    public static boolean [] visited;
    public static int [] detect;
    public static int x = 0;
    public static int y = 0;
    public static int count = 0;
    public static PrintWriter pr = new PrintWriter(System.out);
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s1 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(s1.nextToken());
        arr = new ArrayList [n+1];
        detect = new int [n+1];
        visited = new boolean [n+1];
 
        int m = Integer.parseInt(s1.nextToken());
        for (int i = 0; i<m; i++) {
            StringTokenizer s2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(s2.nextToken());
            int v = Integer.parseInt(s2.nextToken());
            build (u, v);
            build (v, u);
        }

        for (int i = 1; i<arr.length; i++) {
            if (visited[i]==false) {
                bfs(arr, i);
                count += Math.max(x, y);
            }
        }

        pr.print(count);

        br.close();
        pr.close();
    }
    public static void build (int from, int to) {
        if (arr[from]==null) {
            arr[from] = new ArrayList<>();
        }
        arr[from].add(to);
    }
    public static void bfs (ArrayList <Integer> [] arr, int p) {
        x = 0;
        y = 0;
        Queue <Integer> q = new LinkedList<>();
        visited[p] = true;
        detect[p] = 1;
        x+=1;
        q.add(p);
 
        while (!q.isEmpty()) {
 
            int current = q.poll();
 
            if (arr[current]!=null) {
                for (int i = 0; i<arr[current].size(); i++) {
                    int check = arr[current].get(i);
                    if (visited[check]==false) {
                        if (detect[current]==1) {
                            detect[check] = -1;
                            y+=1;
                        }
                        else {
                            detect[check] = 1;
                            x+=1;
                        }
                        visited[check] = true;
                        q.add(check);
                    }
                }
            }
        }
    }
}