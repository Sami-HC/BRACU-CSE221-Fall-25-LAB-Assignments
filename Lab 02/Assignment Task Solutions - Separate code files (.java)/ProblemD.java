import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProblemD {
    public static void main (String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        long [] arr1 = new long [n+1];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i = 1; i<arr1.length; i++) {
            arr1[i] = Long.parseLong(st1.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        long [] arr2 = new long [m+1];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 1; i<arr2.length; i++) {
            arr2[i] = Long.parseLong(st2.nextToken());
        }

        long [] finalarr = merge(arr1, arr2);
        for(int i = 1; i<finalarr.length; i++) {
            if (i==1) {
                pr.print(finalarr[i]);
            }
            else {
                pr.print(" "+finalarr[i]);
            }
        }
        pr.close();
    }
    public static long[] merge (long [] arr1, long [] arr2) {
        int i = 1;
        int j = 1;
        int f = 1;
        long [] finalarr = new long [arr1.length+arr2.length-1];
        while (i<arr1.length && j<arr2.length) {
            if (arr1[i]<=arr2[j]) {
                finalarr[f] = arr1[i];
                i += 1;
                f += 1;
            }
            else if (arr1[i]>arr2[j]) {
                finalarr[f] = arr2[j];
                j += 1;
                f += 1;
            }
        }
        if (i <= arr1.length-1) {
            for(int n = i; n<arr1.length; n++) {
                finalarr[f] = arr1[n];
                f += 1;
            }
        }
        else if (j <= arr2.length-1) {
            for(int n = j; n<arr2.length; n++) {
                finalarr[f] = arr2[n];
                f += 1;
            }
        }
        return finalarr;
    }
}