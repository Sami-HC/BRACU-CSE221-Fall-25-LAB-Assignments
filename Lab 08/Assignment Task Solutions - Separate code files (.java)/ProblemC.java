import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ProblemC {
    public static ArrayList <Integer> [] arrto;
    public static ArrayList <Integer> [] arrweight;
    public static boolean [] visited;
    public static int [] parent;
    public static int [][] dfsparent;
    public static long [] size;
    public static int count = 0;
    public static long maxcost = 0;
    public static long checkcost = Long.MAX_VALUE;
    public static long dfscost1 = -1;
    public static long dfscost2 = -1;
    public static PriorityQueue <int []> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    public static PriorityQueue <int []> tpq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        parent = new int [n+1];
        dfsparent = new int [n+1][2];
        size = new long [n+1];
        arrto = new ArrayList [n+1];
        arrweight = new ArrayList [n+1];
        for (int i = 1; i<n+1; i++) {
            parent[i] = i;
            size[i] = 0;
        }

        int m = Integer.parseInt(st1.nextToken());
        for (int i = 0; i<m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());
            int w = Integer.parseInt(st2.nextToken());

            pq.add(new int [] {w, u, v});
        }

        while (count < n-1 && !pq.isEmpty()) {
            int [] tarr = pq.poll();
            int up = find(tarr[1]);
            int vp = find(tarr[2]);
            if (up == vp) {
                tpq.add(tarr);
            }
            else {
                count++;
                long tsize = size[up] + size[vp] + tarr[0];
                if (size[up] > size[vp]) {
                    size[up] = tsize;
                    parent[vp] = up;
                }
                else {
                    size[vp] = tsize;
                    parent[up] = vp;
                }
                build(tarr[1], tarr[2], tarr[0]);
                build(tarr[2], tarr[1], tarr[0]);
            }
        }

        pq.addAll(tpq);

        for (int i = 1; i<n+1; i++) {
            if (parent[i] == i) {
                maxcost = size[i];
            }
        }

        while (!pq.isEmpty()) {
            int [] tarr = pq.poll();
            visited = new boolean [size.length];
            dfsparent = new int [n+1][2];
            dfscost1 = -1;
            dfscost2 = -1;
            dfs(tarr[1], tarr[2]);
            findcost(tarr[1], tarr[2]);
            long tempmaxcost = -1;
            if (tarr[0] > dfscost1 && dfscost1!=-1) {
                tempmaxcost = maxcost + tarr[0] - dfscost1;
            }
            else if (tarr[0] == dfscost1) {
                if (dfscost2 != -1) {
                    tempmaxcost = maxcost + tarr[0] - dfscost2;
                }
                else {
                    continue;
                }
            }
            else {
                continue;
            }
            if (tempmaxcost < checkcost && tempmaxcost>maxcost) {
                checkcost = tempmaxcost;
            }
        }

        if (checkcost != Long.MAX_VALUE && checkcost>maxcost && count==n-1) {
            pr.print(checkcost);
        }
        else {
            pr.print(-1);
        }

        br.close();
        pr.close();
    }
    public static int find (int k) {
        while (true) {
            if (parent[k] == k) {
                return k;
            }
            else {
                k = parent[k];
            }
        }
    }
    public static void build (int u, int v, int w) {
        if(arrto[u]==null) {
            arrto[u] = new ArrayList<>();
            arrweight[u] = new ArrayList<>();
        }
        arrto[u].add(v);
        arrweight[u].add(w);
    }
    public static void dfs (int u, int v) {
        visited[u] = true;
        if (arrto[u] != null) {
            for (int i = 0; i<arrto[u].size(); i++) {
                int ch = arrto[u].get(i);
                int chweight = arrweight[u].get(i);
                if (visited[ch] != true) {
                    dfsparent[ch] = new int [] {u, chweight};
                    dfs(ch, v);
                }
            }
        }
    }
    public static void findcost (int u, int v) {
        int [] arr = dfsparent[v];
        if (arr[1] > dfscost1) {
            dfscost2 = dfscost1;
            dfscost1 = arr[1];
        }
        else if (arr[1] < dfscost1 && arr[1] > dfscost2) {
            dfscost2 = arr[1];
        }
        if (arr[0] != u) {
            findcost(u, arr[0]);
        }
    }
}
