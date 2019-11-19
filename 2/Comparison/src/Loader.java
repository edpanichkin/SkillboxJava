public class Loader {
    public static void main(String[] args) {

        // Надеюсь подход верен, понимаю, что переменные нужно иначе называть.
        int x = -222, y = 111, z = -333;

        int min = (x < y) ? x : y;
        min = (min < z) ? min: z;

        int max = (x > y) ? x : y;
        max = (max > z) ? y: z;

        int mid = x+y+z-min-max;

        System.out.println("min " + min + " mid " + mid + " max " + max);

    }
}
