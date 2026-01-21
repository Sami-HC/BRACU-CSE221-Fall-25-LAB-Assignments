import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProblemH {
    public static void main (String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i<n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            pr.println(findcount(Long.parseLong(st1.nextToken()), Long.parseLong(st1.nextToken())));
        }

        pr.close();
    }
    public static long findcount (long position, long avoid) {
        long blocksize = avoid - 1;
        long fullblockcount = position / blocksize;
        long avoidreach = avoid * fullblockcount;
        long fullblockposition = blocksize * fullblockcount;
        long remainder = position - fullblockposition;
        if (remainder==0) {
            return avoidreach-1;
        }
        else {
            return avoidreach + remainder;
        }
    }
}