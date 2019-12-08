
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Loader {
    public static void main(String[] args) throws IOException {
        System.out.println("Program is running...");
        String[] series = {"A", "B", "E", "K", "M", "H", "O", "P", "C", "T", "Y"};
        String[] numbers = new String[9];
        String[] region;
        String[] carNumber;
        String[] carNumberNotUnique = new String[2000000];
        ArrayList seriesNum = new ArrayList();

        StringBuffer sb = new StringBuffer();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long start = Calendar.getInstance().getTimeInMillis();

        for (int i = 1; i <= numbers.length; i++) {
            numbers[i - 1] = String.valueOf(i) + String.valueOf(i) + String.valueOf(i);
        }
        region = nullFillString(2);
        //Заполенение серий номеров
        for (int i = 0; i < series.length; i++) {
            for (int j = 0; j < series.length; j++) {
                for (int z = 0; z < series.length; z++) {
                    seriesNum.add(series[i] + series[j] + series[z]);
                }
            }
        }
        //Склеивание номера и генерация номеров
        for (int i = 0; i < carNumberNotUnique.length; i++) {
            carNumberNotUnique[i] = sb.append(seriesNum.get((int) (seriesNum.size() * Math.random())))
                    .append(region[(int) ((region.length - 1) * Math.random())])
                    .insert(1, numbers[(int) ((numbers.length - 1) * Math.random())]).toString();
            sb.delete(0, sb.length());
        }
        carNumber = justUniques(carNumberNotUnique);

        System.out.println("Время генерации номеров: " + (Calendar.getInstance().getTimeInMillis() - start)
                + " миллисекунд, Сгенерировано: " + carNumberNotUnique.length +" Уникальных: " + carNumber.length);
        System.out.println("//Введите номер ТС:  код региона 01-99, блатной - это одинаковые цифры в номере\n" +
                "//серия Заглавными ENG \"A\",\"B\",\"E\",\"K\",\"M\",\"H\",\"O\",\"P\",\"C\",\"T\",\"Y\"");
        String numConsole = reader.readLine().trim();
        start = System.nanoTime();
        //Первый поиск
        boolean searched = false;
        for (int i = 0; i < carNumber.length - 1; i++) {
            if (numConsole.equals(carNumber[i])) {
                System.out.println("--> Найдена/ Время поиска перебором номера в ns: "
                        + (System.nanoTime() - start) + "\n");
                searched = true;
                break;
            }
        }
        if (!searched) {
            System.out.println("Данного номера ТС не сгенерированно, поиск: "
                    + (System.nanoTime() - start) + "ns");
        }
        //Блок для других поисков

        ArrayList<String> carNumberSearch = new ArrayList<>();
        HashSet<String> carNumberSearchHash = new HashSet<>();
        TreeSet<String> carNumberSearchTree = new TreeSet<>();

        start = System.nanoTime();
        System.out.println("...Идет процес присвоения...");
        for (int i = 0; i < carNumber.length; i++) {
            carNumberSearch.add(carNumber[i]);
            carNumberSearchHash.add(carNumber[i]);
            carNumberSearchTree.add(carNumber[i]);
        }
        System.out.println("В коллекции записано, затратило: " + (System.nanoTime() - start) + "ns");

        long startHash = System.nanoTime();
        if (carNumberSearchHash.contains(numConsole))
            System.out.println("Hash search " + (System.nanoTime() - startHash) + "ns - true");
        else
            System.out.println("Hash search " + (System.nanoTime() - startHash) + "ns - false");

        long startTree = System.nanoTime();
        if (carNumberSearchTree.contains(numConsole))
            System.out.println("Tree search " + (System.nanoTime() - startTree) + "ns - true");
        else
            System.out.println("Tree search " + (System.nanoTime() - startTree) + "ns - false");

        long startSort = System.nanoTime();
        if (Collections.binarySearch(carNumberSearch, numConsole) > 0)
            System.out.println("Поиск binary занял : " + (System.nanoTime() - startSort) + "ns - true");
        else
            System.out.println("Поиск binary занял : " + (System.nanoTime() - startSort) + "ns - false");
    }

    public static String[] nullFillString(Integer length) {
        Integer powLength = (int) Math.pow(10, length);
        String[] stringToFill = new String[powLength];
        String conCat = "";
        int dec = 10;
        for (int i = 0; i < length - 1; i++) {
            conCat +="0";
        }

        for (int i = 0; i < powLength - 1; i++) {
            stringToFill[i] = conCat.concat(String.valueOf(i + 1));
            if ((i + 1) % dec == 0) {
                conCat = conCat.replaceFirst("0", "");
                stringToFill[i] = conCat.concat(String.valueOf(i + 1));
                dec = dec * 10;
            }
        }
        return stringToFill;
    }

    public static String[] justUniques(String[] arr) {
        if (arr == null || arr.length == 0) return arr;
        Arrays.sort(arr);
        int n = 1;
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i].equals(arr[i - 1])) n++;
        }
        String[] res = new String[n];
        res[0] = arr[0];
        n = 1;
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i].equals(arr[i - 1])) res[n++] = arr[i];
        }
        Random rnd = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);

            String a = arr[index];
            arr[index] = arr[i];
            arr[i] = a;
        }
        return res;

    }
}
