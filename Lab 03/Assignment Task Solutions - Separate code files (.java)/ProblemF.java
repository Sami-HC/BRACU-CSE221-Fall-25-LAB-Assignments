import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProblemF {
    public static PrintWriter pr = new PrintWriter(System.out);
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer s1 = new StringTokenizer(br.readLine());
        long [] arr = new long [n];
        for (int i = 0; i<arr.length; i++) {
            arr[i] = Long.parseLong(s1.nextToken());
        }

        build(arr, 0, arr.length-1);

        pr.close();
    }
    public static void build (long [] arr, int l, int r) {
        if (l<=r) {
            int mid = (l+r)/2;
            if (l==0 && r==arr.length-1) {
                pr.print(arr[mid]);
            }
            else {
                pr.print(" "+arr[mid]);
            }
            build(arr, l, mid-1);
            build(arr, mid+1, r);
        }
    }
}