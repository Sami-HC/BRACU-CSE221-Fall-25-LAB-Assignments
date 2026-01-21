import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProblemH {
    public static PrintWriter pr = new PrintWriter(System.out);
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer s1 = new StringTokenizer(br.readLine());
        long [] arrin = new long [n];
        for (int i = 0; i<arrin.length; i++) {
            arrin[i] = Long.parseLong(s1.nextToken());
        }
        StringTokenizer s2 = new StringTokenizer(br.readLine());
        long [] arrpost = new long [n];
        for (int i = 0; i<arrpost.length; i++) {
            arrpost[i] = Long.parseLong(s2.nextToken());
        }

        build(arrin, arrpost, 0, arrin.length-1, 0, arrpost.length-1);

        pr.close();
    }
    public static void build (long [] arrin, long [] arrpost, int lin, int rin, int lpost, int rpost) {
        if (lin<=rin && lpost<=rpost) {

            if (lpost==0 && rpost==arrpost.length-1) {
                pr.print(arrpost[rpost]);
            }
            else {
                pr.print(" "+arrpost[rpost]);
            }

            int index = -1;
            for (int i = lin; i<=rin; i++) {
                if (arrin[i]==arrpost[rpost]) {
                    index = i;
                }
            }

            build(arrin, arrpost, lin, index-1, lpost, lpost + (index-lin) - 1);
            build(arrin, arrpost, index+1, rin, lpost + (index-lin), rpost - 1);
        }
    }
}