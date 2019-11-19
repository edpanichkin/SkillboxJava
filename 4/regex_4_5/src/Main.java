import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String TEXT = "Вася заработал 1 рублей, Петя - 13 рубля, а Маша - 120 рублей";
        String regex = "(?<income>\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(TEXT);
        int debetCount = 0;

        while (matcher.find()) {
            debetCount += Integer.parseInt(matcher.group("income"));
        }
        System.out.printf("Друзья заработали: %s%n", debetCount);
////////////////////////////////////////////////////
        System.out.println("Введите номер телефона");
        Scanner scanner = new Scanner(System.in);
        String tNum = scanner.nextLine();
        System.out.println(tNum.replaceAll("\\D",""));

        String tales = "Are you ready for this, Amy?” David asked his daughter. The girl finished tying the laces of Are you ready for this, Amy?” David asked his daughter. The girl finished tying the laces of Are you ready for this, Amy?” David asked his daughter. The girl finished tying the laces of Are you ready for this, Amy?” David asked his daughter. The girl finished tying the laces of Are you ready for this, Amy?” David asked his daughter. The girl finished tying the laces of Are you ready for this, Amy?” David asked his daughter. The girl finished tying the laces of Are you ready for this, Amy?” David asked his daughter. The girl finished tying the laces of ";
        String[] talesArr = tales.split("\\s+");

        for (String a: talesArr){
            System.out.println(a);
        }
    }
}
