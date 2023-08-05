package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AstronautRepository implements Repository<Astronaut>{
    private Collection<Astronaut> astronauts;


    //създаваме празен конструктор и инициализираме нов списък - за да избегнем проблема
    //"java.util.Collection.add(Object)" because "this.astronauts" is null
    //трябва ни за ControllerImpl
    public AstronautRepository() {
        this.astronauts = new ArrayList<>();
    }


    //•	Returns collection of astronauts (unmodifiable)
    @Override
    public Collection<Astronaut> getModels() {
        return Collections.unmodifiableCollection(this.astronauts);
    }

    //•	Adds an astronaut in the Space Station.
    //•	Every astronaut is unique and it is guaranteed that there will not be an astronaut with the same name.
    @Override
    public void add(Astronaut model) {
      // if(this.astronauts.stream().noneMatch(a->a.getName().equals(model.getName()))){- ако трябва да проверяваме дали има еднакви имена
           this.astronauts.add(model);

    }

    //•	Removes an astronaut from the collection. Returns true if the deletion was successful
    @Override
    public boolean remove(Astronaut model) {
        return this.astronauts.remove(model);
    }


    //•	Returns an astronaut with that name
    @Override
    public Astronaut findByName(String name) {
        return this.astronauts.stream().filter(n->n.getName().equals(name)).findFirst().orElse(null);
    }
}
