import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProblemG {
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
        long [] arrpre = new long [n];
        for (int i = 0; i<arrpre.length; i++) {
            arrpre[i] = Long.parseLong(s2.nextToken());
        }

        build(arrin, arrpre, 0, arrin.length-1, 0, arrpre.length-1);

        pr.close();
    }
    public static void build (long [] arrin, long [] arrpre, int lin, int rin, int lpre, int rpre) {
        if (lin<=rin && lpre<=rpre) {

            int index = -1;
            for (int i = lin; i<=rin; i++) {
                if (arrin[i]==arrpre[lpre]) {
                    index = i;
                }
            }

            build(arrin, arrpre, lin, index-1, lpre+1, lpre+(index-lin));
            build(arrin, arrpre, index+1, rin, lpre+(index-lin)+1, rpre);

            if (lpre==0 && rpre==arrpre.length-1) {
                pr.print(arrpre[lpre]);
            }
            else {
                pr.print(arrpre[lpre]+" ");
            }
        }
    }
}