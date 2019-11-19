package core;

import java.util.HashMap;

public class Camera
{
    public static HashMap<String, Integer> carsSpeed = new HashMap<>();

    public static Car getNextCar()
    {
        //String рандомный номер для генерируемой машины
        String randomNumber = Double.toString(Math.random()).substring(2, 5);
        //Integer рандомная высота машины для генерируемой машины
        int randomHeight = (int) (1000 + 3500. * Math.random());
        //Double рандомный вес машины для генерируемой машины
        double randomWeight = 600 + 10000 * Math.random();
        Car car = new Car(randomNumber, randomHeight, randomWeight, Math.random() > 0.5);
        if(Math.random() < 0.15) {
            car.setIsSpecial();
        }
        Police.resetCalled();

        return car;
    }

    public static int getCarSpeed(Car car)
    {
        String carNumber = car.getNumber();
        if(!carsSpeed.containsKey(carNumber)) {
            carsSpeed.put(carNumber, (int) (180 * Math.random()));
        }
        return carsSpeed.get(carNumber);
    }
}