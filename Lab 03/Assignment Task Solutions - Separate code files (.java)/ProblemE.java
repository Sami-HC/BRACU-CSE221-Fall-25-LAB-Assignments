import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProblemE {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i<n; i++) {
            StringTokenizer s1 = new StringTokenizer(br.readLine());
            long a = Long.parseLong(s1.nextToken());
            long b = Long.parseLong(s1.nextToken());
            long c = Long.parseLong(s1.nextToken());
            long [] result = sum(a,b,c);
            pr.println(result[0]);
        }
        pr.close();
    }
    public static long [] sum (long a, long b, long c) {
        if (b==1) {
            return new long[] {a%c , a%c};

        }
        else if (b==2) {
            long x = a%c;
            long y = (x*x)%c;
            return new long[] {(x+y)%c , y};

        }
        else if (b%2==0) {
            long [] result = sum(a,b/2,c);
            long x = result[0]%c;
            long y = result[1]%c;
            long nx = (x+(y*x)%c)%c;
            long ny = (y*y)%c;
            return new long[] {nx , ny};

        }
        else {
            long [] result = sum(a,b-1,c);
            long x = (result[1]*(a%c))%c;
            long y = (result[0]+x)%c;
            return new long[] {y , x};

        }
    }
    public static long mod (long a, long b, long c) {
        if (b==1) {
            return a%c;
        }
        else if (b==2) {
            return (a*a)%c;
        }
        else if (b%2==0) {
            long result = mod(a,b/2,c);
            return (result*result)%c;
        }
        else {
            long result = mod(a,b/2,c);
            return (((result*result)%c) * a%c)%c;
        }
    }
}