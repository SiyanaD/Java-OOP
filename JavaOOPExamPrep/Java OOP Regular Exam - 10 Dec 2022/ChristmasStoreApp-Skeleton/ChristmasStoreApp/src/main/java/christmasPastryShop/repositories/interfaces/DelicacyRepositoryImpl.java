package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DelicacyRepositoryImpl implements DelicacyRepository<Delicacy> {
    private Collection<Delicacy> models;


    public DelicacyRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public Delicacy getByName(String name) {
        //Returns an entity with that name.
        return this.models.stream().filter(n->n.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Delicacy> getAll() {
//Returns all entities (unmodifiable
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Delicacy delicacy) {
        //Adds an entity in the collection.
        this.models.add(delicacy);
    }
}
