import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class ProblemD {
    public static int tdis = 0;
    public static int tnode = 1;
    public static ArrayList <Integer> [] arr;
    public static boolean [] visited;
    public static PrintWriter pr = new PrintWriter(System.out);
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new ArrayList [n+1];
        visited = new boolean [n+1];
 
        int m = n-1;
        for (int i = 0; i<m; i++) {
            StringTokenizer s2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(s2.nextToken());
            int v = Integer.parseInt(s2.nextToken());
            build (u, v);
            build (v, u);
        }

        bfs(arr, 1);
        int temp = tnode;
        tdis = 0;
        visited = new boolean [n+1];
        bfs(arr, tnode);

        pr.println(tdis);
        pr.println(temp+" "+tnode);

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
        Queue <Integer> q = new LinkedList<>();
        Queue <Integer> disq = new LinkedList<>();
        visited[p] = true;
        q.add(p);
        disq.add(1);
 
        while (!q.isEmpty()) {
 
            int current = q.poll();
            int cdis = disq.poll();
 
            if (arr[current]!=null) {
                for (int i = 0; i<arr[current].size(); i++) {
                    int check = arr[current].get(i);
                    if (visited[check]==false) {
                        if (cdis>tdis) {
                            tdis = cdis;
                            tnode = check;
                        }
                        visited[check] = true;
                        q.add(check);
                        disq.add(cdis+1);
                    }
                }
            }
        }
    }
}