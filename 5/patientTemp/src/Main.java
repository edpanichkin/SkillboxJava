public class Main {

    public static double minTemp = 32;
    public static double maxTemp = 40;
    public static int patientsCount = 30;

    public static final double MIN_HEALTH_TEMP = 36.2;
    public static final double MAX_HEALTH_TEMP = 36.9;

    public static void main(String[] args) {
        Double[] temp = new Double[patientsCount+1];
        double averageSum = 0.0;

        int healthySum = 0;
        for (int i = 0; i < patientsCount; i++) {
            temp[i] = rnd(minTemp, maxTemp);
            averageSum += temp[i];
            if (temp[i] > MIN_HEALTH_TEMP && temp[i]< MAX_HEALTH_TEMP){
                healthySum++;
            }
        }
        averageSum /= patientsCount;
        System.out.printf("Average temperature is %.3f, healthy patient is %d",
                averageSum, healthySum);
    }

    public static double rnd(double min, double max) {
        max -= min;
        return (Math.random() * ++max) + min;
    }
}