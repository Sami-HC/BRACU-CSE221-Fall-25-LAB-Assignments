import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ProblemE {
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);

        int m = Integer.parseInt(br.readLine());
        for (int j = 0; j<m; j++) {

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st1.nextToken());
            int p = Integer.parseInt(st1.nextToken());
            int count = 0;
            PriorityQueue <int []> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            PriorityQueue <Integer> pq2 = new PriorityQueue<>();

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
                boolean check = false;

                ArrayList <Integer> ledger = new ArrayList<>();

                while (!pq2.isEmpty() && start > pq2.peek()) {
                    ledger.add(pq2.poll());
                }

                if (ledger.size() != 0) {
                    pq2.add(end);
                    count++;
                    check = true;
                }
                for(int k = 0; k<ledger.size()-1; k++) {
                    pq2.add(ledger.get(k));
                }

                if (check == false && pq2.size() < p) {
                    count++;
                    pq2.add(end);
                }
            }

            pr.print(count);
            if (j != m-1) {
                pr.print("\n");
            }

        }

        br.close();
        pr.close();
    }
}
