package spaceStation.models.bags;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Backpack implements Bag {

    //The Backpack is a class that holds a collection of items. It should be able to be instantiated

    //•	items – a collection of Strings
    private Collection<String> items;

    //The constructor should not take any values upon initialization.
    public Backpack() {
        this.items = new ArrayList<>();
    }

    @Override
    public Collection<String> getItems() {
        return this.items;
    }
}
