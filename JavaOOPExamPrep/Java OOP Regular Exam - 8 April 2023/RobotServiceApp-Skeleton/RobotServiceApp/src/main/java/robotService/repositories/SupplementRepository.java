package robotService.repositories;

import robotService.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;

public class SupplementRepository implements Repository {
    //The supplement repository is a repository for the supplements that are in the services
    private Collection<Supplement> supplements;

    public SupplementRepository() {
        this.supplements = new ArrayList<>();
    }

//•	Adds a supplement to the collection.
    @Override
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);

    }

    //•	Removes a supplement from the collection. Returns true if the deletion was successful, otherwise - false.
    @Override
    public boolean removeSupplement(Supplement supplement) {
        return this.supplements.remove(supplement);
    }

    //•	Returns the first supplement of the given type, if there is any. Otherwise, returns null.
    @Override
    public Supplement findFirst(String type) {
        //t.getClass().getSimpleName()-в списъка оставяме само тези добавки на който като им взема класа ми отговарят на този клас който имам във филтъра type
        return this.supplements.stream().filter(s->s.getClass().getSimpleName().equals(type)).findFirst().orElse(null);
    }
}
