import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;
public class ProblemG {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);

        StringTokenizer s1 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(s1.nextToken());
        int m = Integer.parseInt(s1.nextToken());
        int k = Integer.parseInt(s1.nextToken());

        HashMap <String, Integer> hm = new HashMap<>();
        boolean check = false;

        for (int p = 0; p<k; p++) {
            if (check) {
                break;
            }
            StringTokenizer s2 = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(s2.nextToken());
            int j = Integer.parseInt(s2.nextToken());

            if (hm.get(i+","+j)!=null) {
                pr.print("YES");
                check = true;
            }

            for (int r = i-1; r<=i+1; r+=2) {
                if (check) {
                    break;
                }
                for (int c = j-2; c<=j+2; c+=4) {
                    if (check) {
                        break;
                    }
                    if (r>0 && r<=n && c>0 && c<=m) {
                        hm.put(r+","+c, 1);
                    }
                }
            }
            for (int c = j-1; c<=j+1; c+=2) {
                if (check) {
                    break;
                }
                for (int r = i-2; r<=i+2; r+=4) {
                    if (check) {
                        break;
                    }
                    if (r>0 && r<=n && c>0 && c<=m) {
                        hm.put(r+","+c, 1);
                    }
                }
            }
        }
        if (!check) {
            pr.print("NO");
        }
        
        br.close();
        pr.close();
    }
}