import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProblemG {
    public static void main (String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());

        long [] arr = new long [n+1];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 1; i<arr.length; i++) {
            arr[i] = Long.parseLong(st2.nextToken());
        }

        for(int i = 0; i<m; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            pr.println(findcount(arr, Long.parseLong(st3.nextToken()), Long.parseLong(st3.nextToken())));
        }

        pr.close();
    }
    public static int findcount (long [] arr, long start, long end) {
        int l = bnlow(arr, start);
        int r = bnhigh(arr, end);
        return r-l;
    }
    public static int bnlow (long [] arr, long val) {
        int l = 1;
        int r = arr.length;
        while (l < r) {
            int mid = l + ((r-l)/2);
            if (arr[mid] < val) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return l;
    }
    public static int bnhigh (long [] arr, long val) {
        int l = 1;
        int r = arr.length;
        while (l < r) {
            int mid = l + ((r-l)/2);
            if (arr[mid] <= val) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return l;
    }
}