import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        TreeMap<Integer, String> nameByPhoneBook = new TreeMap<>();
        Scanner reader = new Scanner(System.in);
        nameByPhoneBook.put(1, "a");
        nameByPhoneBook.put(2, "b");
        nameByPhoneBook.put(3, "c");

        for (; ; ) {
            System.out.print("Введите LIST / Контакт / Телефон / EXIT ");
            var inputData = reader.nextLine().trim();

            if (DigitTrue(inputData)) {
                var phone = Integer.valueOf(inputData);
                if (nameByPhoneBook.containsKey(phone)) {
                    System.out.println("---> " +
                            "Телефон: " + inputData + ", Записан как: "
                            + nameByPhoneBook.get(Integer.valueOf(inputData)));
                } else {
                    System.out.print("Телефон записан, введите имя контакта: ");
                    String value = reader.nextLine();
                    if (value.matches("[a-zA-Zа-яА-Я\\s]+")) {
                        nameByPhoneBook.put(phone, value);
                    } else {
                        System.out.println("Неверный ввод");
                    }
                }
            } else if (inputData.equals("LIST")) {
                for (Integer name : nameByPhoneBook.keySet())
                    System.out.println("Number: " + name + " name: " + nameByPhoneBook.get(name));
            } else if (inputData.equals("EXIT")) {
                break;
            } else if (nameByPhoneBook.containsValue(inputData)) {
                System.out.print("---> ");
                for (Integer name : nameByPhoneBook.keySet()) {
                    if (nameByPhoneBook.get(name).equals(inputData)) {
                        System.out.println("Телефон: " + name + ", Записан как: "
                                + nameByPhoneBook.get(name));
                    }
                }
            } else {
                System.out.print("Контакт записан, введите номер телефона: ");
                var keyPhone = reader.nextLine().trim();
                if (DigitTrue(keyPhone)) {
                    nameByPhoneBook.put(Integer.valueOf(keyPhone), inputData);
                } else {
                    System.out.println("Неверный ввод");
                }
            }
        }

    }

    public static boolean DigitTrue(String str) {
        boolean matchDig = false;
        if (str.matches("[0-9]+")){
            matchDig = true;
        }
            return matchDig;
    }

}
