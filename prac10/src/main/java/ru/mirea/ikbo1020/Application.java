package ru.mirea.ikbo1020;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.mirea.ikbo1020.components.HarryPotter;
import ru.mirea.ikbo1020.components.RonWeesly;
import ru.mirea.ikbo1020.components.Voldemort;
import ru.mirea.ikbo1020.interfaces.Magican;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        try {
            //context.getBean(args[0], Magican.class).doMagic();
            context.getBean(Voldemort.class).doMagic();
            context.getBean(HarryPotter.class).doMagic();
            context.getBean(RonWeesly.class).doMagic();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            System.err.println("Expected 1 command line argument, found 0!");
        }

    }

}
