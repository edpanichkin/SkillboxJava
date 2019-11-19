import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader
{
    public static void main(String[] args)
    {
        String debetString = "Вася заработал 1 рублей, Петя - 10 рубля, а Маша - 100 рублей";
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(debetString);

        Integer debetCount = 0;

        while (matcher.find()){
            debetCount += Integer.parseInt(debetString.substring(matcher.start(), matcher.end()));
        }
        System.out.print("Друзья заработали: " + debetCount);

        System.out.println("\n\nДругое задание:   ");
        System.out.println("Введите ФИО для парсинга:  ");
        Scanner scanner = new Scanner(System.in);
        //String text= scanner.nextLine();
        String text ="Иванов Сергей Петрович";

        pattern = Pattern.compile("[a-zA-Zа-яА-Я\\s]*");
        matcher = pattern.matcher(text);
        if(matcher.matches()){
            parseFIO_v1(text);
            parseFIO_v2(text);
        }
        else {
            System.out.println("Ошибка ввода, введены не буквенные символы");
        }

    //Латинские
        pattern = Pattern.compile("[a-zA-Z]*");
        for (char i ='A'; i < 'z'; i++ ){
            matcher = pattern.matcher(String.valueOf(i));
            if (matcher.matches()){
                System.out.printf("Символ %c номер: %d%n", i, (int)i);
            }
        }
    }
    public static void parseFIO_v1(String text){
        System.out.println("Данные для парсинга: " + text + "\n");
        System.out.println("Фамилия: " + text.substring(0, text.indexOf(' ')));
        System.out.println("Имя: " + text.substring(text.indexOf(' ') + 1).substring(0, text.indexOf(' ')));
        System.out.println("Отчество: " + text.substring(text.lastIndexOf(' ')).trim() + "\n");
    }

    public static void parseFIO_v2 (String text){
        System.out.println("Версия 2:\n" );
        String originalText = text;
        String fioLegend[] = {"Фамилия:  ", "Имя:  ", "Отчество:  "};
        String fio[] = originalText.split("\\s+");
        int fioL=fio.length;
        for (int i=0; i<fioL; i++){
            System.out.println(fioLegend[i] + fio[i]);
        }
        System.out.printf("%n");
    }
}

