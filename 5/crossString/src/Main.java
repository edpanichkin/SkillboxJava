public class Main {
    public static int arrayLength = 17;

    public static void main(String[] args) {
        String[] crossArray = new String[arrayLength];

        for (int i = 0; i < crossArray.length; i++) {
            fillArray(crossArray, i);
            printArray(crossArray);
        }
    }

    public static void printArray (String[] arrayToPrint){
        for (int i=0; i < arrayToPrint.length; i++){
            System.out.print(arrayToPrint[i] + " ");
        }
        System.out.println("\n");
    }

    public static String[] fillArray(String[] arrayToFill, int pos){
        String x = "X";
        nullfillArray(arrayToFill);

        arrayToFill[pos] = x;
        arrayToFill[arrayToFill.length-pos-1] = x;

        return arrayToFill;
    }

    public static String[] nullfillArray(String[] arrayToFill){

        for (int i = 0; i < arrayToFill.length; i++){
            arrayToFill[i] = "_";
        }
        return arrayToFill;
        }
}
