import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        String regex = "(?<cmd>ADD|LIST)\\s*(?<email>\\S*)?";
        String regexEmail = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

        String string ="";
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> emails = new TreeSet<>();
        System.out.println(" Введите команды управлением спиcка дел: \n" +
                " ** LIST  //Вывод текущего списка email\n" +
                " ** ADD Адрес email\n" +
                "-----> Ожидаю комманду на ввод:");
        for (;;) {
            string = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
            Pattern patternEmail = Pattern.compile(regexEmail, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(string);

            while (matcher.find()) {
                String email = matcher.group("email");
                Matcher matcherEmail = patternEmail.matcher(email);
                switch (matcher.group("cmd")) {
                    case "ADD": {
                        if (matcherEmail.find()) {
                            emails.add(email);
                        }
                        else {
                            System.out.println("Введен некорректный адрес e-mail");
                        }
                        break;
                    }
                    case "LIST": {
                        for (String word : emails) {
                            System.out.println(word);
                        }
                        break;
                    }
                }
            }
            System.out.println("-----> Ожидаю комманду на ввод:");
        }
    }
}
