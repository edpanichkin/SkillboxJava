
public class Loader {
    public static void main(String[] args) {
        //Урок 1
        Cat catA = new Cat();
        Cat catB = new Cat();
        Cat catC = new Cat();
        Cat catD = new Cat();
        Cat catE = new Cat(1005.0);

        catE.setColorType(CatColor.BLACK);
        System.out.println("CatEColor    " + catE.getColorType());
        catE.setColorType(CatColor.RED);
        System.out.println("CatEColor    " + catE.getColorType());
        System.out.println("Количество кошек: " + Cat.getCount());
        System.out.println("Кошка A: " + catA.getStatus() + ", Вес " + catA.getWeight());
        System.out.println("Кошка В: " + catB.getStatus() + ", Вес " + catB.getWeight());
        catB.feed(1000.0);
        System.out.println("Кошка В: " + catB.getStatus() + ", Вес " + catB.getWeight());
        catC.feed(10000.0);
        System.out.println("Кошка C: " + catC.getStatus() + ", Вес " + catC.getWeight());
        System.out.println("Кошка D: " + catD.getStatus() + ", Вес " + catD.getWeight());
       catD.drink(1000.0);
       System.out.println("Кошка D: " + catD.getStatus() + ", Вес " + catD.getWeight());
        System.out.println("Кошка E: " + catE.getStatus() + ", Вес " + catE.getWeight());
        for (int i=0; i<10000; i++) {
            catE.meow();
        }
        System.out.println("Кошка E: " + catE.getStatus() + ", Вес " + catE.getWeight());
        System.out.println("Кошка съела: " + catB.feedAmount());
        System.out.println("Кошка В: " + catB.getStatus() + ", Вес " + catB.getWeight());
        catB.poo();
        System.out.println("Кошка В: " + catB.getStatus() + ", Вес " + catB.getWeight());
        System.out.println("Количество кошек: " + Cat.getCount());
        Cat catF = new Cat(1001.0);
        Cat kitten = Cat.createKitten();
        System.out.println("Кошка F: " + catF.getStatus() + ", Вес " + catF.getWeight());
        System.out.println("Котенок: " + kitten.getWeight());
        Cat catH = catA.deepCopy();
        System.out.println("Кошка H вес: " + catH.getWeight() + ", Вес оригинала " + catA.getWeight());
        catE.feed(10002.0);
        System.out.println("Dead eat "  + " catE status " + catE.getStatus() + "- catE weight " +catE.getWeight()
        + " - feedamount " + catE.feedAmount());
    }
}