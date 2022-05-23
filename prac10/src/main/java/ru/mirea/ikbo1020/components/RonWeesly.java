package ru.mirea.ikbo1020.components;

import org.springframework.stereotype.Component;
import ru.mirea.ikbo1020.interfaces.Magican;

@Component
public class RonWeesly implements Magican {
    @Override
    public void doMagic() {
        System.out.println("RonWeesly magic");
    }
}
