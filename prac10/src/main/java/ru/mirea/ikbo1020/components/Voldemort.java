package ru.mirea.ikbo1020.components;

import org.springframework.stereotype.Component;
import ru.mirea.ikbo1020.interfaces.Magican;

@Component
public class Voldemort implements Magican {
    @Override
    public void doMagic() {
        System.out.println("Voldemort magic");
    }
}
