package ru.mirea;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ArrayList<Human> input = new ArrayList<>();
        input.add(new Human(
                26, "Андрей", "Крылов", LocalDate.of(1996, 4, 12), 66));
        input.add(new Human(
                64, "Григорий", "Беляев", LocalDate.of(1958, 7, 18), 78));
        input.add(new Human(
                18, "Михаил", "Смирнов", LocalDate.of(2004, 1, 26), 57));
        input.add(new Human(
                32, "Вероника", "Родионова", LocalDate.of(1990, 11, 8), 55));
        input.add(new Human(
                35, "Полина", "Самсонова", LocalDate.of(1987, 3, 21), 63));
        Stream<Human> stream = input.stream();
        stream.sorted((h1, h2) -> h1.getBirthDate().compareTo(h2.getBirthDate()))
                .filter(hm -> hm.age < 50)
                .sorted(Comparator.comparingInt(Human::getWeight))
                .forEach(System.out::print);
    }
}

