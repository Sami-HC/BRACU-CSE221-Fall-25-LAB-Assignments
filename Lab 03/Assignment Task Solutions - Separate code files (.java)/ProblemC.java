import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProblemC {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);

        StringTokenizer s1 = new StringTokenizer(br.readLine());
        long a = Long.parseLong(s1.nextToken());
        long b = Long.parseLong(s1.nextToken());
        
        pr.println(mod(a,b));
        pr.close();
    }
    public static long mod (long a, long b) {
        if (b==1) {
            return a%107;
        }
        else if (b==2) {
            return (a*a)%107;
        }
        else if (b%2==0) {
            long result = mod(a,b/2);
            return (result*result)%107;
        }
        else {
            long result = mod(a,b/2);
            return (((result*result)%107) * a%107)%107;
        }
    }
}