import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        TreeMap<Integer, String> phoneBook = new TreeMap<>();
        Scanner reader = new Scanner(System.in);
        phoneBook.put(1, "a");
        phoneBook.put(2, "b");
        phoneBook.put(3, "c");


        //System.out.println(phoneBook.keySet());
        for (;;) {
            System.out.print("Введите LIST / Контакт / Телефон / EXIT ");
            var inputData = (reader.nextLine().trim());

            if (inputData.matches("[0-9]+")) {
                var key = Integer.valueOf(inputData);
                if (phoneBook.containsKey(key)) {
                    System.out.println("---> " +
                            "Телефон: " + inputData + ", Записан как: " + phoneBook.get(Integer.valueOf(inputData)));
                } else {
                    System.out.print("Телефон записан, введите имя контакта: ");
                    String value = reader.nextLine();
                    if (value.matches("[a-zA-Zа-яА-Я\\s]+")) {
                        phoneBook.put(key, value);
                    }
                    else {
                        System.out.println("Неверный ввод");
                    }
                }
            }
            else if (inputData.equals("LIST")) {
                for (Integer name : phoneBook.keySet())
                    System.out.println("Number: " + name + " name: " + phoneBook.get(name));
            }
            else if (inputData.equals("EXIT")) {
                break;
            }
            else if (phoneBook.containsValue(inputData)) {
                System.out.print("---> ");
                for (Integer name : phoneBook.keySet()) {
                    if (phoneBook.get(name).equals(inputData)) {
                        System.out.println("Телефон: " + name + ", Записан как: " + phoneBook.get(name));
                    }
                }
            }
            else {
                System.out.print("Контакт записан, введите номер телефона: ");
                var key = reader.nextLine().trim();
                if (key.matches("[0-9]+")) {
                    phoneBook.put(Integer.valueOf(key), inputData);
                }
                else {
                    System.out.println("Неверный ввод");
                }
            }
        }
    }
}