import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Program is running...");
        System.out.println("//Введите номер ТС:  код региона 01-99, блатной - это одинаковые цифры в номере\n" +
                "//серия Заглавными ENG \"A\",\"B\",\"E\",\"K\",\"M\",\"H\",\"O\",\"P\",\"C\",\"T\",\"Y\":\n");

        //CarNumber carNumber = new CarNumber(new Scanner(System.in).nextLine());
        CarNumber carNumber = new CarNumber("B555AM44");
    }
}
