import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProblemD {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i<m; i++) {
            long [][] mat = new long [2][2];
            StringTokenizer s1 = new StringTokenizer(br.readLine());
            mat[0][0] = Long.parseLong(s1.nextToken());
            mat[0][1] = Long.parseLong(s1.nextToken());
            mat[1][0] = Long.parseLong(s1.nextToken());
            mat[1][1] = Long.parseLong(s1.nextToken());

            long n = Long.parseLong(br.readLine());
        
            long [] [] result = pr(mat,n);
            pr.println(result[0][0]+" "+result[0][1]+"\n"+result[1][0]+" "+result[1][1]);
        }
    
        pr.close();
    }
    public static long[][] pr (long [][] mat, long n) {
        if (n==1) {
            return mat;
        }
        else if (n==2) {
            return mult(mat,mat);
        }
        else if (n%2==0) {
            long [][] tempmat = pr(mat,n/2);
            return mult(tempmat,tempmat);
        }
        else {
            long [][] tempmat = pr(mat,n/2);
            return mult(mult(tempmat,tempmat),mat);
        }
    }
    public static long[][] mult (long [][] mat1, long [][] mat2) {
        long [][] tempmat = new long [2][2];
        tempmat[0][0] = ((mat1[0][0]*mat2[0][0]) + (mat1[0][1]*mat2[1][0])) % 1000000007;
        tempmat[0][1] = ((mat1[0][0]*mat2[0][1]) + (mat1[0][1]*mat2[1][1])) % 1000000007;
        tempmat[1][0] = ((mat1[1][0]*mat2[0][0]) + (mat1[1][1]*mat2[1][0])) % 1000000007;
        tempmat[1][1] = ((mat1[1][0]*mat2[0][1]) + (mat1[1][1]*mat2[1][1])) % 1000000007;
        return tempmat;
    }
}