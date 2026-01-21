import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
public class ProblemA {
    public static ArrayList <Integer> [] arr;
    public static HashMap <Integer, Integer> hm = new HashMap <>();
    public static int size;
    public static boolean [] instack;
    public static boolean check = true;
    public static int [] parent;
    public static boolean [] visited;
    public static boolean [] root;
    public static int [] endtime;
    public static PrintWriter pr = new PrintWriter(System.out);
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s1 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(s1.nextToken());
        arr = new ArrayList [n+1];
        parent = new int [n+1];
        endtime = new int [n+1];
        root = new boolean [n+1];
        instack = new boolean [n+1];
        visited = new boolean [n+1];
 
        int m = Integer.parseInt(s1.nextToken());
        for (int i = 0; i<m; i++) {
            StringTokenizer s2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(s2.nextToken());
            int v = Integer.parseInt(s2.nextToken());
            root[v] = true;
            build (u, v);
        }

        boolean check2 = false;
        for (int i = 1; i<root.length; i++) {
            if (root[i]==false) {
                check2 = true;
                dfs(arr, i);
            }
        }

        for (int i = 1; i<endtime.length; i++) {
            hm.put(endtime[i], i);
        }

        Arrays.sort(endtime);

        if (check && check2) {
            for (int i = endtime.length-1; i>0; i--) {
                if (i!=endtime.length-1) {
                    pr.print(" ");
                }
                pr.print(hm.get(endtime[i]));
            }
        }
        else {
            pr.print("-1");
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
    public static void dfs (ArrayList <Integer> [] arr, int i) {
        if (visited[i]!=true) {
            visited[i] = true;
            instack[i] = true;
            size += 1;

            if (arr[i] != null) {
                for (int j = 0; j<arr[i].size(); j++) {
                    if (instack[arr[i].get(j)]==true) {
                        check = false;
                    }
                    if (visited[arr[i].get(j)]==false) {
                        dfs (arr, arr[i].get(j));
                    }
                }

            }
            size += 1;
            instack[i] = false;
            endtime[i] = size;
        }
    }
}