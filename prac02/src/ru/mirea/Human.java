package ru.mirea;

import java.time.LocalDate;

public class Human {
    public int age;
    public String firstName;
    public String lastName;
    public LocalDate birthDate;
    public int weight;

    public Human(int age, String firstName, String lastName, LocalDate birthDate, int weight) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return firstName + " ";
    }
}