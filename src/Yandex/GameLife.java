package Yandex;

import java.util.ArrayList;
import java.util.Scanner;

public class GameLife {

    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);

        int n, m, k;

        // inicialization of vars
        n = reader.nextInt();
        m = reader.nextInt();
        k = reader.nextInt();

        // Создаем три масива, один первый хранит состояние поля,
        // второй количество изменений,
        // третий хранит временное состояние поля в цикле (для корректности данных)
        int[][] a = new int[n][m];
        int[][] b = new int[n][m];
        int[][] c = new int[n][m];

        //initialization of table
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                a[i][j] = reader.nextInt();
            }
        }

        for (int d = 0; d < k; d++){
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    // создаем массив для значений соседей данного объекта
                    // и инициализируем его
                    ArrayList <Integer> neighbors = new ArrayList<>();
                    try{
                        neighbors.add(a[i - 1][j]);
                    }catch (Exception e){};
                    try{
                        neighbors.add(a[i + 1][j]);
                    }catch (Exception e){};
                    try{
                        neighbors.add(a[i][j - 1]);
                    }catch (Exception e){};
                    try{
                        neighbors.add(a[i][j + 1]);
                    }catch (Exception e){};

                    // переменные для храниения количства (можно было в массив, но переменные понятней)
                    int nonactiveNeighbor = 0;
                    int stableNeighbor = 0;
                    int nonstableNeighbor = 0;

                    // считаем какие и сколько соседей у поля
                    for (int r = 0; r < neighbors.size(); r++){
                        if (neighbors.get(r) == 1)
                            nonactiveNeighbor++;
                        else if (neighbors.get(r) == 2)
                            stableNeighbor++;
                        else if (neighbors.get(r) == 3)
                            nonstableNeighbor++;
                    }

                    // воспроизводим условия задачи (вводим в впеменный массив)
                    if (stableNeighbor > 1)
                        c[i][j] = 2;
                    else if ((stableNeighbor + nonstableNeighbor) > 0)
                        c[i][j] = 3;
                    else
                        c[i][j] = 1;
                }
            }
            // проверяем было ли изменение и перносим значения из временного массива в постоянный
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    if (a[i][j] != c[i][j])
                        b[i][j]++;
                    a[i][j] = c[i][j];
                }
            }
        }
        // вывод данных
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                System.out.print(b[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
