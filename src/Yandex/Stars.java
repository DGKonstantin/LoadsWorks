package Yandex;

import java.util.ArrayList;
import java.util.Scanner;

public class Stars {

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[] x = new int[n];
        int[] y = new int[n];
        int[] t = new int[n];

        for (int i = 0; i < n; i++){
            x[i] = scan.nextInt();
            y[i] = scan.nextInt();
            t[i] = scan.nextInt();
        }

        /*
        нам нужно проверить каждый отрезок между звездами одного типа
        если ни один отрезое между красивыми звездами не пересекает ни один отрезок между некрасивыми
        то линию провести можно

        вроде так должно быть
         */

        ArrayList<Integer> beauty = new ArrayList<>();
        ArrayList<Integer> ugly = new ArrayList<>();


        // разделим звезды на 2 группы
        for (int i = 0; i < n; i++){
            if (t[i] == 1)
                beauty.add(i);
            else
                ugly.add(i);
        }

        // определим количество линий которые можно провести через отрезки
        int countBeauty = 0;
        int countUgly = 0;
        for (int i = 1; i < beauty.size(); i++){
            countBeauty += i;
        }
        for (int i = 1; i < ugly.size(); i++){
            countUgly += i;
        }


        // создадим все отрезки
        int[] ax = new int[countBeauty];
        int[] ay = new int[countBeauty];

        int[] bx = new int[countUgly];
        int[] by = new int[countUgly];

        // запишем координаты всех векторов
        for (int i = 0; i < countBeauty;){
            for (int i1 = 1; i1 < beauty.size(); i1++){
                for (int i2 = i1; i2 < beauty.size(); i2++){
                    ax[i] = x[beauty.get(i1 - 1)] - x[beauty.get(i1)];
                    ay[i] = y[beauty.get(i1 - 1)] - y[beauty.get(i1)];
                    i++;
                }
            }
        }
        for (int i = 0; i < countUgly;){
            for (int i1 = 1; i1 < ugly.size(); i1++){
                for (int i2 = i1; i2 < ugly.size(); i2++){
                    bx[i] = x[ugly.get(i1 - 1)] - x[ugly.get(i1)];
                    by[i] = y[ugly.get(i1 - 1)] - y[ugly.get(i1)];
                    i++;
                }
            }
        }

        // теперь надо брать перемножение каждого вектора с каждым (из разных групп)
        // определять пересекаются они или нет будем по знаку третьей компоненты


    }
}
