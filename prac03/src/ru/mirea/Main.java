package ru.mirea;

public class Main {
    public static void main(String[] args) {
        SMap map = new SMap();
        map.add("id05", "Крылов Андрей Маркович");
        map.add("id02", "Беляев Григорий Давидович");
        map.add("id10", "Смирнов Михаил Елисеевич");
        map.add("id07", "Родионова Вероника Львовна");
        map.add("id01", "Самсонова Полина Дмитриевна");
        map.add("id09", "Новиков Ярослав Николаевич");
        map.add("id04", "Зайцев Никита Матвеевич");
        map.add("id08", "Зверева Вероника Сергеевна");
        map.add("id03", "Прокофьева Ксения Макаровна");
        map.add("id06", "Лебедева Ксения Романовна");
        map.delete("id09");
        map.change("id01", "Смирнов Михаил Елисеевич");
        System.out.println(map.find("id01"));

        LList list = new LList();
        list.add("Крылов Андрей Маркович");
        list.add("Беляев Григорий Давидович");
        list.add("Смирнов Михаил Елисеевич");
        list.add("Родионова Вероника Львовна");
        list.add("Самсонова Полина Дмитриевна");
        list.add("Новиков Ярослав Николаевич");
        list.add("Зайцев Никита Матвеевич");
        list.add("Зверева Вероника Сергеевна");
        list.add("Прокофьева Ксения Макаровна");
        list.add("Лебедева Ксения Романовна");

        System.out.println(list.contains("Родионова Вероника Львовна"));
        System.out.println(list.get(6));
    }
}

