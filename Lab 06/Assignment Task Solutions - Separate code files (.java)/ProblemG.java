import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class ProblemG {
    public static String[] store;
    public static boolean[] appear;
    public static int [] indegree;
    public static boolean key = true;
    public static ArrayList<Integer>[] arr;
    public static PriorityQueue <Integer> pq = new PriorityQueue<>();
    public static StringBuilder sb = new StringBuilder ();
    public static int addcount = 0;
    public static int appearcount = 0;
    public static PrintWriter pr = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        store = new String[n];
        arr = new ArrayList[27];
        appear = new boolean[27];
        indegree = new int[27];

        for (int i = 0; i < n; i++) {
            store[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            String s = store[i];
            for (int j = 0; j < s.length(); j++) {
                if (appear[s.codePointAt(j)-96] != true) {
                    appear[s.codePointAt(j)-96] = true;
                    appearcount += 1;
                }
            }
        }

        for (int i = 0; i < n - 1; i++) {
            String st1 = store[i];
            String st2 = store[i + 1];
            int index = Math.min(st1.length(), st2.length());
            boolean diffFound = false;
            for (int j = 0; j < index; j++) {
                int from = st1.codePointAt(j)-96;
                int to = st2.codePointAt(j)-96;
                if (st1.charAt(j) != st2.charAt(j)) {
                    build(from, to);
                    diffFound = true;
                    break;
                }
            }
            if (!diffFound && st1.length() > st2.length()) {
                key = false;
            }
        }

        topo();

        if (key==false || appearcount!=addcount) {
            pr.print(-1);
        }
        else {
            pr.print(sb);
        }

        br.close();
        pr.close();
    }

    public static void build(int from, int to) {
        if (arr[from] == null) {
            arr[from] = new ArrayList<>();
        }
        if (!arr[from].contains(to)) {
            arr[from].add(to);
            indegree[to] += 1;
        }
    }

    public static void topo () {
        for (int i = 1; i<appear.length; i++) {
            if (appear[i]==true && indegree[i]==0) {
                pq.add(i);
            }
        }
        while (!pq.isEmpty()) {
            int current = pq.poll();
            sb.append((char)(current+96));
            addcount+=1;
            if(arr[current]!=null) {
                for (int i = 0; i<arr[current].size(); i++) {
                    int check = arr[current].get(i);
                    indegree[check]-=1;
                    if (indegree[check]==0) {
                        pq.add(check);
                    }
                }
            }
        }
    }
}