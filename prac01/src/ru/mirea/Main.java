package ru.mirea;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(new Student("Крылов Андрей Маркович", "02"));
        students.add(new Student("Беляев Григорий Давидович", "01"));
        students.add(new Student("Смирнов Михаил Елисеевич", "03"));
        students.add(new Student("Родионова Вероника Львовна", "03"));
        students.add(new Student("Самсонова Полина Дмитриевна", "02"));
        students.add(new Student("Новиков Ярослав Николаевич", "03"));
        students.add(new Student("Зайцев Никита Матвеевич", "01"));
        students.add(new Student("Зверева Вероника Сергеевна", "03"));
        students.add(new Student("Прокофьева Ксения Макаровна", "02"));
        students.add(new Student("Лебедева Ксения Романовна", "01"));

        Function<ArrayList<Student>, HashMap<String, ArrayList<Student>>> grouper = list -> {
            HashMap<String, ArrayList<Student>> map = new HashMap<String, ArrayList<Student>>();
            for (Student person : list) {
                if (!map.containsKey(person.group)) {
                    map.put(person.group, new ArrayList<Student>());
                }
                map.get(person.group).add(person);
            }
            return map;
        };
        HashMap<String, ArrayList<Student>> map = grouper.apply(students);
        for (String group : map.keySet()) {
            System.out.println("Группа: " + group);
            for (Student student : map.get(group)) {
                System.out.println(student.name);
            }
        }

    }
}
