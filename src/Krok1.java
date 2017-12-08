import java.util.ArrayList;
import java.util.Scanner;

public class Krok1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
        {
            a[i] = scanner.nextInt();
        }
        ArrayList <int[]> result = new ArrayList<>();
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                if (a[i] == a[j]){
                    int[] b = new int[]{i, j};
                    result.add(b);
                }
            }
        }
        for (int[] c : result){
            for (int i = 0; i < 2; i++){
                System.out.print(c[i] + 1 + " ");
            }
            System.out.println("");
        }
    }
}
