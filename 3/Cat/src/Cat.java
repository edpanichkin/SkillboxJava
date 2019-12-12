public class Cat {
    public static final int LEGS_COUNT = 4;
    public static final int EYES_COUNT = 2;
    public static final double MIN_WEIGHT = 1000.0;
    public static final double MAX_WEIGHT = 9000.0;

    private Double originWeight;
    private Double weight;
    private Double foodAmount;
    private CatColor type;
    private boolean alive;
    public static Integer catCount = 0;

    public Cat() {
        this(1500.0 + 3000.0 * Math.random());
    }

    public Cat(Double weight) {
        this.weight = weight;
        originWeight = weight;
        foodAmount = 0.0;
        alive = weight > MIN_WEIGHT && weight <= MAX_WEIGHT;
        catCount = alive ? catCount + 1 : catCount;
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
        if (weight >= MIN_WEIGHT && alive) {
            weight = weight - 1;
            System.out.println("Meow " + weight);
            if (weight < MIN_WEIGHT) {
                alive = false;
                catCount--;
            }
        }
    }

    public void feed(Double amount) {
        if ((amount <= (MAX_WEIGHT - weight)) && alive) {
            foodAmount = foodAmount + amount;
            weight = weight + amount;
            if (weight > MAX_WEIGHT) {
                alive = false;
                catCount--;
            }
        }
    }

    public void drink(Double amount) {
        if (weight <= MAX_WEIGHT && alive) {
            weight = weight + amount;
            foodAmount = foodAmount + amount;
            if (weight > MAX_WEIGHT) {
                alive = false;
                catCount--;
            }
        }
    }
    public void poo() {
        if (alive && weight >= MIN_WEIGHT) {
            weight = weight - 1000 * Math.random();
            System.out.println("UFF" + weight);
            if (weight < MIN_WEIGHT) {
                alive = false;
                catCount--;
            }
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
        if(weight < MIN_WEIGHT) {
            if (alive) {
                catCount--;
                alive = false;
            }

            return "Dead";
        }
        else if (weight > MAX_WEIGHT) {
            if (alive) {
                catCount--;
                alive = false;
            }
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