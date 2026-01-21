import java.io.*;
import java.util.StringTokenizer;
public class ProblemF {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());

        StringTokenizer s1 = new StringTokenizer(br.readLine());
        int i = Integer.parseInt(s1.nextToken());
        int j = Integer.parseInt(s1.nextToken());

        int count = 0;
        String st = "";

        for (int r = i-1; r<=i+1; r++) {
            for (int c = j-1; c<=j+1; c++) {
                if (r==i && c==j) {}
                else if (r>0 && r<=n && c>0 && c<=n) {
                    st += r+" "+c+"\n";
                    count += 1;
                }
            }
        }
        pr.print(count+"\n"+st);
        br.close();
        pr.close();
    }
}