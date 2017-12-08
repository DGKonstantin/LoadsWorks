package Codewars;

public class Celsium {

    public static void main(String[] args) {
        System.out.println(weatherInfo(convertToCelsius(100)));
    }


    public static String weatherInfo(int temp) {
        double c = (double) temp;
        if (c < 0)
            return (c + " is freezing temperature");
        else
            return (c + " is above freezing temperature");
    }

    public static int convertToCelsius(int temperature) {
        int celsius = (int)((temperature - 32) * (5.0/9.0));
        return celsius;
    }
}
