public class Cat {
    public static final int LEGS_COUNT = 4;
    public static final int EYES_COUNT = 2;
    public static final double MIN_WEIGHT = 1000.0;
    public static final double MAX_WEIGHT = 9000.0;

    private Double originWeight;
    private Double weight;
    private Double foodAmount;
    private Double minWeight;
    private Double maxWeight;
    private CatColor type;
    private boolean alive;
    public static Integer catCount = 0;

    public Cat() {
        this(1500.0 + 3000.0 * Math.random());
    }
    public Cat(Double weight) {
        this.weight = weight;
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        foodAmount = 0.0;
        alive = true;
        catCount++;

        if (weight < minWeight) {
            alive = false;
            catCount--;
            System.out.println("Dead cat was created");
        }
    }
    public static Cat createKitten() {
        Cat cat = new Cat (100.0 + 100.0 * Math.random());
        return cat;
    }
    public Cat deepCopy () {
        Cat cat = new Cat (this.weight);
        return cat;
    }

    public void meow() {
        String s = this.getStatus();
        if (alive == true) {
            weight = weight - 1;
            System.out.print("Meow ");
        }
    }

    public void feed(Double amount) {
        String s = this.getStatus();
        if (alive == true) {
            foodAmount = foodAmount + amount;
            weight = weight + amount;
        }
    }
    public void drink(Double amount){
        String s = this.getStatus();
        if (alive == true) {
            weight = weight + amount;
            foodAmount = foodAmount + amount;
        }
    }
    public void poo() {
        String s = this.getStatus();
        if (alive == true) {
            weight = weight - 1000 * Math.random();
            System.out.println("UFF");
        }
    }
    public void setColorType (CatColor type) {
        this.type = type;
    }

    public Double getWeight(){
        return weight;
    }
    public Double feedAmount() {
        return foodAmount;
    }

    public static Integer getCount() {
        return catCount;
}
    public CatColor getColorType () {
        return type;
    }
    public String getStatus() {
        if(weight < minWeight) {
            if (alive == true) {
                catCount--;
            }
            alive = false;
            return "Dead";
        }
        else if (weight > maxWeight) {
            if (alive == true) {
                catCount--;
            }
                alive = false;
                return "Exploded";
        }
        else if (weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
}