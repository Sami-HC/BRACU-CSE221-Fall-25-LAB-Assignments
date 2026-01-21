import java.util.Scanner;
public class ProblemA {
  public static void main (String [] args) {
    Scanner sc = new Scanner (System.in);
    int a = sc.nextInt();
    for (int i = 0; i<a; i++) {
        int b = sc.nextInt();
        if (b%2==0) {
            System.out.println(b+" is an Even number.");
        }
        else {
            System.out.println(b+" is an Odd number.");
        }
    }
    sc.close();
}
}