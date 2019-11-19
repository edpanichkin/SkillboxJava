
public class Loader
{
    public static void main(String[] args)
    {
        Integer milkAmount = 2000; // ml
        Integer powderAmount = 5000; // g
        Integer eggsCount = 1000; // items
        Integer sugarAmount = 200; // g
        Integer oilAmount = 1000; // ml
        Integer appleCount = 0;

        //powder - 400 g, sugar - 10 g, milk - 1 l, oil - 30 ml
        if(powderAmount >= 400 && sugarAmount >= 10 && milkAmount >= 1000 && oilAmount >= 30) {
            System.out.println("You can cook: Pancakes");
        }
        else
        {
            System.out.println("You can't cook: Pancakes");
        }

        //milk - 300 ml, powder - 5 g, eggs - 5
        if(powderAmount >= 5 && eggsCount >= 5 && milkAmount >= 300) {
            System.out.println("You can cook: Omelette");
        }
        else
        {
            System.out.println("You can't cook: Omelette");
        }

        //apples - 3, milk - 100 ml, powder - 300 g, eggs - 4
        if(powderAmount >= 300 && eggsCount >= 4 && milkAmount >= 100 && appleCount >= 3) {
            System.out.println("You can cook: Apple pie");
        }
        else
        {
            System.out.println("You can't cook: Apple pie");
        }
    }
}