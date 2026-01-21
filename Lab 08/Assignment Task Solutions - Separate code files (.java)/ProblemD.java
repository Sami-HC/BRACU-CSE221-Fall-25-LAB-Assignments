import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ProblemD {
    public static int count = 0;
    public static int lastend = -1;
    public static PriorityQueue <int []> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    public static StringBuilder sb = new StringBuilder();
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i<n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());

            pq.add(new int [] {start, end});
        }

        while (!pq.isEmpty()) {
            int [] arr = pq.poll();
            int start = arr[0];
            int end = arr[1];

            if (start > lastend) {
                count++;
                sb.append("\n").append(start).append(" ").append(end);
                lastend = end;
            }
        }

        pr.print(count+sb.toString());

        br.close();
        pr.close();
    }
}
