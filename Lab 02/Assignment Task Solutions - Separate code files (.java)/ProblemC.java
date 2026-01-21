import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class ProblemC {
    public static void main (String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        long sum = Long.parseLong(st1.nextToken());

        data [] arr = new data [n+1];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 1; i<arr.length; i++) {
            arr[i] = new data ();
            arr[i].val = Long.parseLong(st2.nextToken());
            arr[i].old = i;
        }
        Arrays.sort(arr, 1, arr.length);
        pr.println(findsum(arr, sum));
        pr.close();
    }
    public static String findsum (data [] arr, long sum) {
        for(int i = 1; i<arr.length; i++) {
            long sumcheck = sum - arr[i].val;
            int l = i+1;
            int r = arr.length-1;
            while (l<r) {
                if ((arr[l].val+arr[r].val) > sumcheck) {
                    r -= 1;
                }
                else if ((arr[l].val+arr[r].val) < sumcheck) {
                    l += 1;
                }
                else if ((arr[l].val+arr[r].val) == sumcheck) {
                    return arr[i].old+" "+arr[l].old+" "+arr[r].old;
                }
            }
        }
        return "-1";
    }
}
class data implements Comparable<data> {
    long val;
    int old;

    public int compareTo (data n) {
        if (this.val>n.val) {
            return 1;
        }
        else if (this.val==n.val) {
            return 0;
        }
        else {
            return -1;
        }
    }
}