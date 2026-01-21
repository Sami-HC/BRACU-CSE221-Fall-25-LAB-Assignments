import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProblemA {
    public static void main (String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        long sum = Long.parseLong(st1.nextToken());

        long [] arr = new long [n+1];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 1; i<arr.length; i++) {
            arr[i] = Long.parseLong(st2.nextToken());
        }
        pr.println(findsum(arr, sum));
        pr.close();
    }
    public static String findsum (long [] arr, long sum) {
        int l = 1;
        int r = arr.length-1;
        while (l<r) {
            if ((arr[l]+arr[r]) > sum) {
                r -= 1;
            }
            else if ((arr[l]+arr[r]) < sum) {
                l += 1;
            }
            else if ((arr[l]+arr[r]) == sum) {
                return l+" "+r;
            }
        }
        return "-1";
    }
}