import java.util.Scanner;
public class ProblemE {
    public static void main (String [] args) {
        Scanner sc = new Scanner (System.in);
        int a = sc.nextInt();
        obj [] arr = new obj [a+1];
        for (int i = 1; i<arr.length; i++) {
            obj n = new obj ();
            arr[i] = n;
            arr[i].val = sc.nextLong();
            arr[i].old = i;
        }
        System.out.println(arrsor(arr));
        sc.close();
    }
    public static String arrsor (obj [] arr) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i<arr.length; i++) {
            obj min = null;
            int minindex = i;
            boolean cng = false;
            for (int j = i+1; j<arr.length; j++) {
                if (min==null) {
                    if (arr[j].val<arr[i].val) {
                     min = arr[j];
                     minindex = j;
                     cng = true;
                    }
                }
                else if (arr[j].val==min.val && ((i%2==0 && j%2==0) || (i%2!=0 && j%2!=0))) {
                    min = arr[j];
                    minindex = j;
                    cng = true;
                }
                else if (arr[j].val<min.val) {
                    min = arr[j];
                    minindex = j;
                    cng = true;
                }
            }
            if (cng) {
                obj temp = arr[i];
                min.cng = arr[i].old;
                arr[i].old = min.old;

                if (min.old%2==0 && min.cng%2!=0) {
                    return "NO";
                }
                else if (min.old%2!=0 && min.cng%2==0) {
                    return "NO";
                }

                if ((min.old-min.cng)>2) {
                    int ab = min.cng;
                    int bc = ab+2;
                    while (bc<=min.old) {
                        count += 1;
                        sb.append('\n').append(ab).append(' ').append(bc);
                        ab = bc;
                        bc += 2;
                    }
                    ab = min.old - 2;
                    while (ab-2>=min.cng) {
                        count += 1;
                        sb.append('\n').append(ab-2).append(' ').append(ab);
                        ab -= 2;
                    }
                }

                else {
                    count += 1;
                    sb.append('\n').append(min.cng).append(' ').append(min.old);
                }
                
                arr[i] = min;
                arr[minindex] = temp;
            }
        }
        return "YES\n" + count + sb.toString();

    }
}
class obj {
    long val;
    int old;
    int cng;
}