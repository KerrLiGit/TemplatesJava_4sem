package ru.mirea.builder;

public class ToyotaBuilder implements Builder {
    Car car = new Car();

    @Override
    public void BuildEngine() {
        car.buildEngine("Gas engine");
    }

    @Override
    public void SetDirector() {
        car.setDirector("Toyota");
    }

    @Override
    public Car GetResult() {
        return car;
    }
}
