import java.util.Scanner;
public class ProblemD {
  public static void main (String [] args) {
    Scanner sc = new Scanner (System.in);
    int a = sc.nextInt();
    for (int i = 0; i<a; i++) {
        long b = sc.nextLong();
        long check = 0;
        for (long j = 0; j<b; j++) {
            long c = sc.nextLong();
            if (c<check) {
                System.out.println("NO");
                sc.nextLine();
                break;
            }
            else {
                check = c;
            }
            if (j==b-1) {
                System.out.println("YES");
            }
        }
    }
    sc.close();
  }
}