import java.util.Scanner;
public class ProblemF {
    public static void main (String [] args) {
        Scanner sc = new Scanner (System.in);
        int a = sc.nextInt();
        long [] arr = new long [a+1];
        for (int i = 1; i<arr.length; i++) {
            arr[i] = sc.nextLong();
        }
        arrsor(arr);
        for (int i = 1; i<arr.length; i++) {
            if (i!=1) {
                System.out.print(" ");
            }
            System.out.print(arr[i]);
        }
        sc.close();
    }
    public static void arrsor (long [] arr) {
        while (true) {
            boolean check = true;
            for (int i = 1; i<arr.length-1; i++) {
                if ((arr[i]%2==0 && arr[i+1]%2==0) || (arr[i]%2!=0 && arr[i+1]%2!=0)) {
                    if (arr[i]>arr[i+1]) {
                        long temp = arr[i];
                        arr[i] = arr[i+1];
                        arr[i+1] = temp;
                        check = false;
                    }
                }
            }
            if (check) {
                break;
            }
        }
    }
}