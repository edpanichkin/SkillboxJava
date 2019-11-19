
public class Cat
{
    //Урок 4
    public static final int LEGS_COUNT = 4;
    public static final int EYES_COUNT = 2;
    public static final double MIN_WEIGHT = 1000.0;
    public static final double MAX_WEIGHT = 9000.0;

    private CatColor type;

    private Double originWeight;
    private Double weight;
    private Double foodAmount;
    private boolean alive;

    private Double minWeight;
    private Double maxWeight;

    public static Integer catCount = 0;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        foodAmount = 0.0;
        alive = true;
        catCount++;
    }

    public Cat(Double weight)
    {
        this();
        this.weight=weight;
        if (weight < minWeight) {
            alive = false;
            catCount--;
            System.out.println("Dead cat was created");
        }
    }

    public Cat(boolean isKitty) {
        this();
        weight = 100.0 + 100.0 * Math.random();
        minWeight = 100.0;
    }

    public static Integer getCount()
    {
        return catCount;
    }
    public void meow()
    {
        weight = weight - 1;
        System.out.print ("Meow ");
    }

    public void feed(Double amount)
    {
        foodAmount = foodAmount + amount;
        weight = weight + amount;
    }
// Урок 6
    public Cat deepCopy ()
    {
         Cat cat = new Cat (this.weight);
         return cat;
    }

    public void drink(Double amount)
    {
        weight = weight + amount;
        foodAmount = foodAmount + amount;
    }

    public Double getWeight()
    {
        return weight;
    }

    //Урок 2
    public void poo()
    {
        weight = weight - 1000 * Math.random();
        System.out.println("UFF");
    }

    public Double feedAmount()
    {
       return foodAmount;
    }

    public void setColorType (CatColor type)
    {
        this.type = type;
    }

    public CatColor getColorType ()
    {
        return type;
    }

    public String getStatus()
    {
        if(weight < minWeight) {
            if (alive == true) catCount--;
            alive = false;
            return "Dead";
        }
        else if(weight > maxWeight) {
            if (alive == true) catCount--;
            alive = false;
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
}