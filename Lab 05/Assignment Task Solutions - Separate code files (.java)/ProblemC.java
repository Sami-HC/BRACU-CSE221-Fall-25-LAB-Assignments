import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class ProblemC {
    public static ArrayList <Integer> [] arr;
    public static int [] parent;
    public static PrintWriter pr = new PrintWriter(System.out);
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s1 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(s1.nextToken());
        arr = new ArrayList [n+1];
        parent = new int [n+1];

        StringTokenizer s2 = new StringTokenizer(br.readLine());
        StringTokenizer s3 = new StringTokenizer(br.readLine());


        int m = Integer.parseInt(s1.nextToken());
        for (int i = 0; i<m; i++) {
            int u = Integer.parseInt(s2.nextToken());
            int v = Integer.parseInt(s3.nextToken());
            build (u, v);
            build (v, u);
        }

        for (int i = 1; i<arr.length; i++) {
            if (arr[i]!=null) {
                Collections.sort(arr[i]);

            }
        }

        int x = Integer.parseInt(s1.nextToken());
        int y = Integer.parseInt(s1.nextToken());
        bfs(arr, x);

        if (x==y) {
            pr.print(0+"\n"+x);
        }
        else if (parent[y]!=0) {
            int count = 0;
            StringBuilder path = new StringBuilder();
            path.append(y);

            int temp = y;
            while (parent[temp]!=0) {
                count += 1;
                path.insert(0, parent[temp]+" ");
                if (temp==x) {
                    break;
                }
                temp = parent[temp];
            }
            pr.print(count+"\n"+path);
        }
        else {
            pr.print(-1);
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
    public static void bfs (ArrayList <Integer> [] arr, int x) {
        boolean [] visited = new boolean [arr.length];
        Queue <Integer> q = new LinkedList<>();
        visited[x] = true;
        q.add(x);

        while (!q.isEmpty()) {

            int current = q.poll();

            if (arr[current]!=null) {
                for (int i = 0; i<arr[current].size(); i++) {
                    int check = arr[current].get(i);
                    if (visited[check]==false) {
                        visited[check] = true;
                        parent[check] = current;
                        q.add(check);
                    }
                }
            }
        }
    }
}