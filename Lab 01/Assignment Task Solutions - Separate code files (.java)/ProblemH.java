import java.util.Scanner;
public class ProblemH {
    public static void main (String [] args) {
        Scanner sc = new Scanner (System.in);
        int a = sc.nextInt();
        sc.nextLine();
        details [] arr = new details [a+1];
        for (int j = 1; j<arr.length; j++) {
            String b = sc.nextLine();
            details n = new details ();
            arr[j] = n;
            for (int r = 0; r<b.length(); r++) {
                if (b.codePointAt(r)==32) {
                    break;
                }
                else {
                    arr[j].name += b.charAt(r);
                }
            }
            String minute = "" + b.charAt(b.length()-2) + b.charAt(b.length()-1);
            String hour = "" + b.charAt(b.length()-5) + b.charAt(b.length()-4);
            arr[j].time = Integer.parseInt(hour) + (Integer.parseInt(minute)/100.0);
            arr[j].old = j;
            arr[j].line = b;
        }
        arrsor(arr);
        for (int j = 1; j<arr.length; j++) {
            System.out.println(arr[j].line);
        }
        sc.close();
    }
    public static void arrsor (details [] arr) {
        for (int i = 1; i<arr.length; i++) {
            details min = arr[i];
            int minindex = i;
            boolean cng = false;
            for (int j = i+1; j<arr.length; j++) {
                int r = 0;
                while (true) {
                    if (r==min.name.length() || r==arr[j].name.length()) {
                        if (min.name.length() > arr[j].name.length()) {
                            min = arr[j];
                            minindex = j;
                            cng = true;
                        }
                        else if (min.name.length() == arr[j].name.length()) {
                            if (arr[j].time > min.time) {
                                min = arr[j];
                                minindex = j;
                                cng = true;
                            }
                            else if (arr[j].time < min.time) {}
                            else if (arr[j].old < min.old) {
                                min = arr[j];
                                minindex = j;
                                cng = true;
                            }
                        }
                        break;
                    }
                    else {
                        if (min.name.codePointAt(r) > arr[j].name.codePointAt(r)) {
                            min = arr[j];
                            minindex = j;
                            cng = true;
                            break;
                        }
                        else if (min.name.codePointAt(r) < arr[j].name.codePointAt(r)) {
                            break;
                        }
                        else {
                            r += 1;
                        }
                    }
                }
            }
            if (cng) {
                details temp = arr[i];
                arr[i] = min;
                arr[minindex] = temp;
            }
        }
    }
}
class details {
    String line;
    String name;
    double time;
    int old;
}