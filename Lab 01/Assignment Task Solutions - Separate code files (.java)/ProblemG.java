import java.util.Scanner;
public class ProblemG {
    public static void main (String [] args) {
        Scanner sc = new Scanner (System.in);
        int a = sc.nextInt();
        for (int i = 0; i<a; i++) {
            int b = sc.nextInt();
            data [] arr = new data [b+1];
            for (int j = 1; j<arr.length; j++) {
                data n = new data ();
                arr[j] = n;
                arr[j].id = sc.nextInt();
                arr[j].old = j;
            }
            for (int j = 1; j<arr.length; j++) {
                arr[j].mark = sc.nextInt();
            }
            arrsor(arr);
            for (int j = 1; j<arr.length; j++) {
                if (j==arr[j].old) {
                    cycle.count += 1;
                }
                else if (arr[j].detected == false) {
                    arr[j].detected = true;
                    findcycle(arr, j, arr[j].old);
                }
            }
            System.out.println("Minimum swaps: "+(b-cycle.count));
            for (int j = 1; j<arr.length; j++) {
                System.out.println("ID: "+arr[j].id+" Mark: "+arr[j].mark);
            }
            cycle.count = 0;
        }
        sc.close();
    }
    public static void findcycle (data [] arr, int origin, int index) {
        if (index == origin) {
            arr[index].detected =  true;
            cycle.count += 1;
        }
        else {
            arr[index].detected = true;
            findcycle(arr, origin, arr[index].old);
        }
    }
    public static void arrsor (data [] arr) {
        for (int i = 1; i<arr.length; i++) {
            data max = null;
            int maxindex = i;
            int selfminid = arr[i].id;
            boolean elsefound = false;
            boolean cng = false;
            for (int j = i+1; j<arr.length; j++) {
                if (arr[j].mark==arr[i].mark && elsefound==false && arr[j].id<selfminid) {
                     max = arr[j];
                     maxindex = j;
                     selfminid = arr[j].id;
                     cng = true;
                    }
                else if (max==null) {
                    if (arr[j].mark>arr[i].mark) {
                     max = arr[j];
                     maxindex = j;
                     elsefound = true;
                     cng = true;
                    }
                }
                else if (arr[j].mark>max.mark) {
                    max = arr[j];
                    maxindex = j;
                    elsefound = true;
                    cng = true;
                }
                else if (arr[j].mark==max.mark && arr[j].id<max.id) {
                    max = arr[j];
                    maxindex = j;
                    cng = true;
                }
            }
            if (cng) {
                data temp = arr[i];
                arr[i] = max;
                arr[maxindex] = temp;
            }
        }
    }
}
class data {
    int id;
    int mark;
    int old;
    boolean detected = false;
}
class cycle {
    static int count = 0;
}