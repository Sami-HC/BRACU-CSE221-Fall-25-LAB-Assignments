import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class ProblemF {
    public static int dis;
    public static HashMap <Integer, Boolean> hm;
    public static PrintWriter pr = new PrintWriter(System.out);
    public static boolean check = true;
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i<n; i++) {
            StringTokenizer s2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(s2.nextToken());
            int v = Integer.parseInt(s2.nextToken());
            if (u==v) {
                pr.println(0);
            }
            else if (u>v) {
                pr.println(-1);
            }
            else {
                dis = -1;
                hm = new HashMap<>();
                check = true;
                bfs(u, v);
                pr.println(dis);
            }
        }

        br.close();
        pr.close();
    }
    public static ArrayList <Integer> primer (int a) {
        ArrayList<Integer> arr = new ArrayList<>();
        int n = a;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                arr.add(i);
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        if (n > 1 && n!=a) {
            arr.add(n);
        }
        return arr;
    }
    public static void bfs (int a, int b) {
        Queue <Integer> q = new LinkedList<>();
        Queue <Integer> disq = new LinkedList<>();
        hm.put(a, true);
        q.add(a);
        disq.add(1);
 
        while (!q.isEmpty() && check) {
 
            int current = q.poll();
            int cdis = disq.poll();
            ArrayList <Integer> arr = primer(current);

            if (arr!=null && current<=b) {
                for (int i = 0; i<arr.size(); i++) {
                    if (hm.getOrDefault(current+arr.get(i), false)==false) {
                        if ((current+arr.get(i))==b) {
                        dis = cdis;
                        check = false;
                        break;
                        }
                        if ((current+arr.get(i))<=b) {
                            q.add(current+arr.get(i));
                            disq.add(cdis+1);
                            hm.put(current+arr.get(i), true);
                        }
                    }
                }
            }
        }
    }
}