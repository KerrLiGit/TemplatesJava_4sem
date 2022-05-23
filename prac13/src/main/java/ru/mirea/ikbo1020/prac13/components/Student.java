package ru.mirea.ikbo1020.prac13.components;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Data
@Component
@Log4j2
public class Student {
    @Value("${student.name}")
    String name;
    @Value("${student.last_name}")
    String last_name;
    @Value("${student.group}")
    String group;

    @PostConstruct
    private void init() {
        System.out.println(this);
    }
}
