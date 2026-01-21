import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProblemE {
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
    public static int findsum (long [] arr, long sum) {
        int l = 1;
        int length = 0;
        long arrsum = 0;
        int maxlength = 0;
        while (true) {
            if (arrsum <= sum) {
                if (length > maxlength) {
                    maxlength = length;
                }
            }
            if (!(length>=0 && l+length<arr.length)) {
                break;
            }
            if (arrsum <= sum) {
                arrsum += arr[l+length];
                length += 1;
            }
            else if (arrsum > sum) {
                arrsum -= arr[l];
                l += 1;
                length -= 1;
            }
        }
        return maxlength;
    }
}