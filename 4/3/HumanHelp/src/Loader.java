import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Loader {

    public static int containerCapacity = 27;
    public static int truckCapacity = 12;
    public static int truckQuantity;
    public static int containerQuantity;

    public static void main(String[] args) throws IOException {
        System.out.println("Ведите кол-во ящиков гуманитарной помощи:  ");
        Scanner scanner = new Scanner(System.in);
        Integer cargoNum = scanner.nextInt();

                //Integer.parseInt((new BufferedReader(new InputStreamReader(System.in))).readLine());

        for (int i = 0; i < cargoNum; i++) {
            cargoOutput(i);
        }
        System.out.println("_________________________________\nПогрузка завершена!" );
    }

    public static void cargoOutput(int cargo){
        if ((Math.round(cargo/(containerCapacity * truckCapacity))-truckQuantity) >= 0 ) {
            truckQuantity++;
            System.out.println("- Грузовик № " + truckQuantity);
        }
        if ((Math.round(cargo/containerCapacity)-containerQuantity) >= 0 ){
            containerQuantity++;
            System.out.println("- - Контейнер № " + containerQuantity);
        }
        System.out.println("- - - Ящик № " + (cargo + 1));
    }
}


