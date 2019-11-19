import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Loader {

    public static void main(String[] args) {
        String rainbow[] = {"Red", "Orange", "Yellow", "Green" , "Cyan", "Blue" , "Purple"};
        printArray(rainbow);
        List<String> list = Arrays.asList(rainbow);
        Collections.reverse(list);
        System.out.println("\n\nThe inversion process was performed:");
        list.forEach(x -> System.out.print(x + " "));

        //Другое решение

        for(int i = 0; i < rainbow.length / 2; i++)
        {
            String temp = rainbow[i];
            rainbow[i] = rainbow[rainbow.length - i - 1];
            rainbow[rainbow.length - i - 1] = temp;
        }
        System.out.println("\nДругое решение");
        printArray(rainbow);
    }

    public static void printArray (String[] arrayToPrint){
        System.out.println("\n    Print is starting: " +
                "\n    -%-%-%-%-%-%-%-%-%-%-%-%-%-%-%-%-%-%-\n  Data:  ");
        for (int i=0; i < arrayToPrint.length; i++){
            System.out.print(arrayToPrint[i] + " ");
        }
    }
}