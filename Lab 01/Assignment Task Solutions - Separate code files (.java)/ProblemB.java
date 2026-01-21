import java.util.Scanner;
public class ProblemB {
    public static void main (String [] args) {
        Scanner sc = new Scanner (System.in);
        int a = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i<a; i++) {
            String b = sc.nextLine();
            String left = "";
            String right = "";
            int exp = 0;
            for (int j = 0; j<b.length(); j++) {
                int check = b.codePointAt(j);
                if (check<58 && check>47) {
                    if (exp==0) {
                        left += b.charAt(j);
                    }
                    else {
                        right += b.charAt(j);
                    }
                }
                else if (check<48 && check>41) {
                    exp = check;
                }
            }
            double lf = Integer.parseInt(left);
            double rt = Integer.parseInt(right);
            if (exp == 42) {
                System.out.println(lf*rt);
            }
            else if (exp == 43) {
                System.out.println(lf+rt);
            }
            else if (exp == 45) {
                System.out.println(lf-rt);
            }
            else if (exp == 47) {
                System.out.println(lf/rt);
            }
        }
        sc.close();
    }
}
