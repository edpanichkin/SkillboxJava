import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String regex = "(?<cmd>ADD|LIST|DELETE|EDIT)\\s*(?<num>\\d+)?\\s*(?<text>.*)";
        String string = "";
        ArrayList<String> todoList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Введите команды управлением спиcка дел: \n" +
                " ** LIST  //Вывод текущего списка дел\n" +
                " ** ADD Текст задачи\n" +
                " ** ADD (номер задачи) Текст задачи\n" +
                " ** EDIT (номер задачи) Текст задачи на замену\n" +
                " ** DELETE (номер задачи)\n" +
                "-----> Ожидаю комманду на ввод:");

        todoList.add("A");
        todoList.add("B");
        todoList.add("C");
        todoList.add("D");

        for (;;) {
            string = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
            Matcher matcher = pattern.matcher(string);

            while (matcher.find()) {
                int index = matcher.group("num") != null
                        ? Integer.parseInt(matcher.group("num")) : todoList.size() + 1;
                String text = matcher.group("text");
                switch (matcher.group("cmd")) {
                    case "ADD": {
                        if (index <= todoList.size()) {
                            todoList.add(index, text);
                        } else {
                            todoList.add(text);
                        }
                        break;
                    }
                    case "EDIT": {
                        if (index < todoList.size()) {
                            todoList.set(index, text);
                        } else {
                            System.out.println("Введен не верный индекс задачи");
                        }
                        break;
                    }
                    case "LIST": {
                        for (int i = 0; i < todoList.size(); i++) {
                            System.out.printf("Задача №: %d --> %s%n", i, todoList.get(i));
                        }
                        break;
                    }
                    case "DELETE": {
                        if (index < todoList.size()){
                            todoList.remove(index);
                        }
                        else {
                            System.out.println("Введен не верный индекс задачи");
                        }
                        break;
                    }
                }
            }
            System.out.println("-----> Ожидаю комманду на ввод:");
        }
    }
}
