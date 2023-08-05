package spaceStation.models.planets;

import spaceStation.common.ExceptionMessages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlanetImpl implements Planet{
    //The PlanetImpl is a class that holds information about the items that can be found on its surface. It should be able to be instantiated - public class

    private String name;
    private Collection<String> items;


    //The constructor should take the following values upon initialization:
    //String name
    public PlanetImpl(String name) {
        this.setName(name);
        this.items=new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    //o	If the name is null or whitespace, throw a NullPointerException with the message: "Invalid name!"
    public void setName(String name) {
        if ((name==null || name.equals(""))){
            throw new NullPointerException(ExceptionMessages.PLANET_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getItems() {
        return items;
    }

    public void setItems(Collection<String> items) {
        this.items = items;
    }
}
