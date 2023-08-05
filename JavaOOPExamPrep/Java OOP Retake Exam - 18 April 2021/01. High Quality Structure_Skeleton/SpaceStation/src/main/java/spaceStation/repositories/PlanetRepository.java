package spaceStation.repositories;

import spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PlanetRepository implements Repository<Planet>{
    private Collection<Planet> planets;


    //създаваме празен конструктор и инициализираме нов списък - за да избегнем проблема
    //"java.util.Collection.add(Object)" because "this.astronauts" is null
    //трябва ни за ControllerImpl
    public PlanetRepository() {
        this.planets = new ArrayList<>();
    }


    //•	Returns collection of planets (unmodifiable)
    @Override
    public Collection<Planet> getModels() {
        return Collections.unmodifiableCollection(this.planets);
    }


    //•	Adds a planet for exploration.
    //•	Every planet is unique and it is guaranteed that there will not be a planet with the same name.
    @Override
    public void add(Planet model) {
            this.planets.add(model);

    }

    //•	Removes a planet from the collection. Returns true if the deletion was successful
    @Override
    public boolean remove(Planet model) {
        return this.planets.remove(model);
    }


    //•	Returns a planet with that name.
    //•	It is guaranteed that the planet exists in the collection.
    @Override
    public Planet findByName(String name) {
        return this.planets.stream().filter(n->n.getName().equals(name)).findFirst().orElse(null);
    }
}
