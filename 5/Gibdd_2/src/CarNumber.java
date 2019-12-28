import javax.sound.sampled.EnumControl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CarNumber {
    public static final int NUM_GENERATE = 2000000;
    public boolean searched = false;

    public CarNumber(String numConsole) {

        String[] series = {"A", "B", "E", "K", "M", "H", "O", "P", "C", "T", "Y"};
        String[] numbers = new String[9];
        String[] region;
        ArrayList<String> carNumber = new ArrayList<>();
        ArrayList<String> seriesNum = new ArrayList<>();

        StringBuffer sb = new StringBuffer();

        for (int i = 1; i <= numbers.length; i++) {
            numbers[i - 1] = String.valueOf(i) + String.valueOf(i) + String.valueOf(i);
        }
        region = nullFillString(2);
        //Заполнение серий номеров
        for (String item : series) {
            for (String value : series) {
                for (String s : series) {
                    seriesNum.add(item + value + s);
                }
            }
        }
        //Склеивание номера и генерация номеров
        for (int i = 0; i < NUM_GENERATE; i++) {
            carNumber.add(sb.append(seriesNum.get((int) (seriesNum.size() * Math.random())))
                    .append(region[(int) ((region.length - 1) * Math.random())])
                    .insert(1, numbers[(int) ((numbers.length - 1) * Math.random())]).toString());
            sb.delete(0, sb.length());
        }

        carNumber = justUniques(carNumber, System.nanoTime());
        ArrayList<String> carNumberSearch = new ArrayList<>(carNumber);
        HashSet<String> carNumberSearchHash = new HashSet<>(carNumber);
        TreeSet<String> carNumberSearchTree = new TreeSet<>(carNumber);
        //String numConsole = reader.readLine().trim();

        System.out.println("DIRECT  Search | "
                + OutputString(DirectSearch(carNumber, numConsole, System.nanoTime())));
        System.out.println("BINARY  Search | "
                + OutputString(BinarySearch(carNumber, numConsole, System.nanoTime())));
        System.out.println("HASHSET Search | "
                + OutputString(HashSearch(carNumberSearchHash, numConsole, System.nanoTime())));
        System.out.println("TREESET Search | "
                + OutputString(TreeSearch(carNumberSearchTree, numConsole, System.nanoTime())));
    }

    public String[] nullFillString(Integer length) {
        var powLength = (int) Math.pow(10, length);
        String[] stringToFill = new String[powLength];
        for (int i = 0; i < powLength; i++) {
            stringToFill[i] = String.format("%0" + length + "d", i);
        }
        return stringToFill;
    }
    public String OutputString(long time){
        Underline();
        return time > 0 ? (String.valueOf(time) + " ns ") : "false ";
    }

    public ArrayList justUniques(ArrayList arr, long start) {
        Set<String> set = new HashSet<>(arr);
        arr.clear();
        arr.addAll(set);
        System.out.println(" ---> Генерация и удаление дубликатов заняло: "
                + (System.nanoTime() - start) + " ns"
                + "\n ---> Сгенерировано уникальных: " + arr.size());
        return arr;
    }

    public long BinarySearch(ArrayList carNumber, String numConsole, long start) {
        start = System.nanoTime() - start;
        Collections.sort(carNumber);
        if(Collections.binarySearch(carNumber, numConsole)<0){
            start = -1l;
        }
        return start;
    }

    public long DirectSearch(ArrayList carNumber, String numConsole, long start) {
        for (int i = 0; i < carNumber.size() - 1; i++) {
            if (carNumber.get(i).equals(numConsole)) {
                searched = true;
                break;
            }
            start = System.nanoTime() - start;
        }
        if (!searched) {
            start =-1l;
        }
        return start;
    }

    public long HashSearch(HashSet carNumber, String numConsole, long start) {
        if (carNumber.contains(numConsole)) {
            start = System.nanoTime() - start;
        } else {
            start =-1l;
        }
        return start;
    }

    public long TreeSearch(TreeSet carNumber, String numConsole, long start) {
        if (carNumber.contains(numConsole)) {
            start = System.nanoTime() - start;
        } else {
            start =-1l;
        }
        return start;
    }

    public void Underline() {
        System.out.println("________________________________________");
    }
}

