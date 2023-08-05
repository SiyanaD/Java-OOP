package football.repositories;

import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SupplementRepositoryImpl implements SupplementRepository{

    private Collection<Supplement> supplements;

    public SupplementRepositoryImpl() {
        this.supplements = new ArrayList<>();
    }

    //•	Added a supplement to the collection
    @Override
    public void add(Supplement supplement) {
        this.supplements.add(supplement);

    }


    //•	Removes a supplement from the collection. Returns true if the deletion was successful, otherwise - false
    @Override
    public boolean remove(Supplement supplement) {
        return this.supplements.remove(supplement);
    }

    //•	Returns the first supplement of the given type, if there is. Otherwise, returns null.
    @Override
    public Supplement findByType(String type) {
        return this.supplements.stream().filter(s->s.getClass().getSimpleName().equals(type)).findFirst().orElse(null);
    }
}
