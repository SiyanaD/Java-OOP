package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.booths.interfaces.Booth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BoothRepositoryImpl implements BoothRepository<Booth>{
    private Collection<Booth> models;

    public BoothRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public Booth getByNumber(int number) {
        //Returns an entity with that name.

        return this.models.stream().filter(i->i.getBoothNumber()==number).findFirst().orElse(null);
    }

    @Override
    public Collection<Booth> getAll() {
        //Returns all entities (unmodifiable)
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Booth booth) {
        //Adds an entity in the collection
        this.models.add(booth);

    }
}
