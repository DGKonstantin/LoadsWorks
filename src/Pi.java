import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Pi {

    static Random random;
    static Date dateStart;
    static Date dateFinish;

    public static void main(String[] args) {
        /*
        countPi(1, 100000000d);
        countPi(10, 10000000d);
        countPi(100, 1000000d);
        countPi(1000, 100000d);
        countPi(10000, 10000d);
        countPi(100000, 1000d);
        countPi(1000000, 100d);
        countPi(10000000, 10d);
         */
        countPi(100000000, 1d);
    }
    static void countPi(int countIter, Double countRandom){

        random = new Random();
        dateStart = new Date();

        ArrayList<Double> list = new ArrayList<Double>();

        Double x, y, r;
        r = 1d;
        for (int j = 0; j < countIter; j++){

            Double countPointCirkle = 0.;

            for (int i = 0; i < countRandom; i++){
                if (random.nextBoolean() == true)
                    x = -random.nextDouble();
                else x = random.nextDouble();

                if (random.nextBoolean() == true)
                    y = -random.nextDouble();
                else y = random.nextDouble();

                if (Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(r, 2)){
                    countPointCirkle++;
                }

            }
            Double pi = 4 * countPointCirkle / countRandom;
            list.add(pi);

        }
        Double pi = 0., s = 0.;
        for (Double dou : list){
            s += dou;
        }
        pi = s / list.size();
        dateFinish = new Date();
        Double time = (double) (dateFinish.getTime() - dateStart.getTime()) / 1000;
        System.out.println(String.format("%s : %s", pi, time));
    }
}
