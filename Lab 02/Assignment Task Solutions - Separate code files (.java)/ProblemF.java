import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ProblemF {
    public static void main (String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int count = Integer.parseInt(st1.nextToken());

        long [] arr = new long [n+1];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 1; i<arr.length; i++) {
            arr[i] = Long.parseLong(st2.nextToken());
        }
        pr.println(findsum(arr, count));
        pr.close();
    }
    public static int findsum (long [] arr, int count) {
        Map <Long, Integer> fr = new HashMap<>();
        int l = 1;
        int length = 0;
        long arrcount = 0;
        int maxlength = 0;
        while (true) {
            if (arrcount <= count) {
                if (length > maxlength) {
                    maxlength = length;
                }
            }
            if (!(length>=0 && l+length<arr.length)) {
                break;
            }
            if (arrcount <= count) {
                int check = fr.getOrDefault(arr[l+length], 0);
                if (check == 0) {
                    arrcount += 1;
                }
                fr.merge(arr[l+length], 1, Integer::sum);
                length += 1;
            }
            else if (arrcount > count) {
                int remove = l;
                fr.merge(arr[remove], -1, Integer::sum);
                l += 1;
                length -= 1;
                int check = fr.getOrDefault(arr[remove], 0);
                if (check == 0) {
                    arrcount -= 1;
                }
            }
        }
        return maxlength;
    }
}