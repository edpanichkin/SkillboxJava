public class Loader {
    public static void main(String[] args) {
        //Цикл с использованием for
        for (int j = 200000 ; j<= 210000 ; j++)
        {
            System.out.println(j);
        }
        //Next
        System.out.println("\nСледующая пачка билетов: \n");

        for (int j = 220000 ; j<= 235000 ; j++)
        {
            System.out.println(j);
        }

        System.out.println("\nЦикл с использованием while: \n");
        int i=200000;
        while (i <= 210000)
        {
            System.out.println(i);
            i++;
        }

        //Next
        System.out.println("\nСледующая пачка билетов: \n");

	    i=220000;

        while (i <= 235000)
        {
            System.out.println(i);
            i++;
        }

    }
}
