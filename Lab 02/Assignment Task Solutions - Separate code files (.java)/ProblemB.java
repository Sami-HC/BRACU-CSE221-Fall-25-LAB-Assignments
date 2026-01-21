import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProblemB {
    public static void main (String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        long sum = Long.parseLong(st1.nextToken());

        long [] arr1 = new long [n+1];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 1; i<arr1.length; i++) {
            arr1[i] = Long.parseLong(st2.nextToken());
        }

        long [] arr2 = new long [m+1];
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for(int i = 1; i<arr2.length; i++) {
            arr2[i] = Long.parseLong(st3.nextToken());
        }

        pr.println(findsum(arr1, arr2, sum));
        pr.close();
    }
    public static String findsum (long [] arr1, long [] arr2, long sum) {
        int l = 1;
        int r = arr2.length-1;
        long sumcheck = Math.abs(sum-(arr1[l]+arr2[r]));
        int lcheck = l;
        int rcheck = r;

        while (l<arr1.length && r>0) {
            if ((arr1[l]+arr2[r]) == sum) {
                return l+" "+r;
            }
            else if ((arr1[l]+arr2[r]) > sum) {
                if (Math.abs(sum-(arr1[l]+arr2[r])) < sumcheck) {
                    sumcheck = Math.abs(sum-(arr1[l]+arr2[r]));
                    lcheck = l;
                    rcheck = r;
                }
                r -= 1;
            }
            else if ((arr1[l]+arr2[r]) < sum) {
                if (Math.abs(sum-(arr1[l]+arr2[r])) < sumcheck) {
                    sumcheck = Math.abs(sum-(arr1[l]+arr2[r]));
                    lcheck = l;
                    rcheck = r;
                }
                l += 1;
            }
        }
        return lcheck+" "+rcheck;
    }
}