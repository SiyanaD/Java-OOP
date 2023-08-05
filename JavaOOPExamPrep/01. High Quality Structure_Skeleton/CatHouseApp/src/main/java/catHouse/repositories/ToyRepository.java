package catHouse.repositories;

import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;

public class ToyRepository implements Repository{
    //The toy repository is a repository for the toys that are in the house.

    //•	toys - Collection<Toy>
    private Collection<Toy> toys;

    //празен списък конструктор с играчки
    public ToyRepository() {
        this.toys = new ArrayList<>();
    }


    //•	Adds a toy to the collection
    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);

    }

    //•	Removes a toy from the collection. Returns true if the deletion was successful, otherwise - false.
    @Override
    public boolean removeToy(Toy toy) {
        return this.toys.remove(toy);
    }

    //•	Returns the first toy of the given type, if there is. Otherwise, returns null.
    // return vehicles.stream().filter(v->v.getName().equals(name)).findFirst().orElse(null);
    @Override
    public Toy findFirst(String type) {
        //t.getClass().getSimpleName()-в списъка оставяме само тези играчки на който като им взема класа ми отговарят на този клас който имам във филтъра type
        return this.toys.stream().filter(t->t.getClass().getSimpleName().equals(type)).findFirst().orElse(null);
    }


}
