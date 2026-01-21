import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class ProblemD {
    public static ArrayList <Integer> [] arr;
    public static int [] yparent;
    public static int [] kparent;
    public static int gcount = 0;
    public static PrintWriter pr = new PrintWriter(System.out);
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s1 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(s1.nextToken());
        arr = new ArrayList [n+1];
        kparent = new int [n+1];
        yparent = new int [n+1];

        int m = Integer.parseInt(s1.nextToken());
        for (int i = 0; i<m; i++) {
            StringTokenizer s2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(s2.nextToken());
            int v = Integer.parseInt(s2.nextToken());
            build (u, v);
        }

        int x = Integer.parseInt(s1.nextToken());
        int y = Integer.parseInt(s1.nextToken());
        int k = Integer.parseInt(s1.nextToken());
        kbfs(arr, x);
        ybfs(arr, k);

        if (x==y && y==k) {
            pr.print(0+"\n"+x);
        }
        else {
            String a = kpathbuild(x, k);
            String b = ypathbuild(k, y);
            if (a.equals("-1") || b.equals("-1")) {
                pr.print(-1);
            }
            else {
                pr.print(gcount+"\n"+a+" "+b);
            }
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
    public static void kbfs (ArrayList <Integer> [] arr, int x) {
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
                        kparent[check] = current;
                        q.add(check);
                    }
                }
            }
        }
    }
    public static void ybfs (ArrayList <Integer> [] arr, int k) {
        boolean [] visited = new boolean [arr.length];
        Queue <Integer> q = new LinkedList<>();
        visited[k] = true;
        q.add(k);

        while (!q.isEmpty()) {

            int current = q.poll();

            if (arr[current]!=null) {
                for (int i = 0; i<arr[current].size(); i++) {
                    int check = arr[current].get(i);
                    if (visited[check]==false) {
                        visited[check] = true;
                        yparent[check] = current;
                        q.add(check);
                    }
                }
            }
        }
    }
    public static String kpathbuild (int x, int k) {
        if (x==k) {
            return x+"";
        }
        else if (kparent[k]!=0) {
            int count = 0;
            StringBuilder path = new StringBuilder();
            path.append(k);

            int temp = k;
            while (kparent[temp]!=0) {
                count += 1;
                path.insert(0, kparent[temp]+" ");
                if (temp==x) {
                    break;
                }
                temp = kparent[temp];
            }
            gcount += count;
            return path.toString();
        }
        else {
            return "-1";
        }
    }
    public static String ypathbuild (int k, int y) {
        if (k==y) {
            return "";
        }
        else if (yparent[y]!=0) {
            int count = 0;
            StringBuilder path = new StringBuilder();
            path.append(y);

            int temp = y;
            while (yparent[temp]!=0) {
                count += 1;
                if (yparent[temp]==k) {
                    break;
                }
                path.insert(0, yparent[temp]+" ");
                temp = yparent[temp];
            }
            gcount += count;
            return path.toString();
        }
        else {
            return "-1";
        }
    }
}