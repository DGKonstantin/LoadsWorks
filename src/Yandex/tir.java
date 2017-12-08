package Yandex;

import java.util.Random;
import java.util.Scanner;

public class tir {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        int n, m, k;

        n = read.nextInt();
        m = read.nextInt();
        k = read.nextInt();

        Random random = new Random();

        int[][] a = new int[n][m];


        for (int i = 0; i < k; i++){
            double b = Math.random() * n;
            double c = Math.random() * m;
            for (int q = 1; q < n; q++){
                for (int w = 1; w < m; w++){
                    if (b >= q - 1 && b <= q && c >= w - 1 && c <= w){
                        a[q - 1][w - 1]++;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
