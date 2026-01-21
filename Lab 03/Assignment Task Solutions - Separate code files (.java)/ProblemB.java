import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ProblemB {
    public static long count = 0;
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());

        StringTokenizer s1 = new StringTokenizer(br.readLine());
        long [] arr = new long [n];
        for (int i = 0; i<arr.length; i++) {
            arr[i] = Long.parseLong(s1.nextToken());
        }

        arrsor(arr, new long[arr.length], 0, arr.length-1);

        pr.println(count);

        pr.close();
    }
    public static void arrsor (long [] arr, long [] temp, int l, int r) {
        if (!(l-r==0)) {
            int mid = (l+r)/2;
            arrsor(arr, temp, l, mid);
            arrsor(arr, temp, mid+1, r);
            merge(arr, temp, l, mid, mid+1, r);
        }
    }
    public static void merge (long [] arr, long [] temp, int l, int midl, int midr, int r) {
        int i = l;
        int k = l;
        while (l<=midl && midr<=r) {
            if (arr[l]<=arr[midr]) {
                temp[i] = arr[l];
                l++;
                i++;
            }
            else {
                long a = arr[midr]*arr[midr];
                int j = Arrays.binarySearch(arr, l, midl+1, a);
                if (j>=0) {
                    while (true){
                        if (arr[j]!=arr[j+1]) {
                            break;
                        }
                        j++;
                    }
                    if (j<=midl) {
                        count += (midl-j);
                    }
                }
                else if ((-j-1)<=midl) {
                    count += (midl-(-j-1)+1);
                }
                temp[i] = arr[midr];
                midr++;
                i++;
            }
        }
        if (l<=midl) {
            while (l<=midl) {
                temp[i] = arr[l];
                l++;
                i++;
            } 
        }
        else if (midr<=r) {
            while (midr<=r) {
                temp[i] = arr[midr];
                midr++;
                i++;
            }
        }
        for (int j = k; j<=r; j++) {
            arr[j] = temp[j];
        }
    }
}