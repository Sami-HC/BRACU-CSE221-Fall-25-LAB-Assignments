import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ProblemF {
    public static long count = 0;
    public static long time = 0;
    public static PriorityQueue <int []> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i<n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int dr = Integer.parseInt(st2.nextToken());
            int dl = Integer.parseInt(st2.nextToken());

            pq.add(new int [] {dr, dl});
        }

        while (!pq.isEmpty()) {
            int [] tarr = pq.poll();
            int dr = tarr[0];
            int dl = tarr[1];
            
            time += dr;

            count += (dl-time);
        }

        pr.print(count);

        br.close();
        pr.close();
    }
}
