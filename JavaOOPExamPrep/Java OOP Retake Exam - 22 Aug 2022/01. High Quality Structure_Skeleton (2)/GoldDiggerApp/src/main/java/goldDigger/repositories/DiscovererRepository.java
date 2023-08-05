package goldDigger.repositories;

import goldDigger.models.discoverer.Discoverer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DiscovererRepository implements Repository<Discoverer>{
    private Collection<Discoverer> discoverers;

    public DiscovererRepository() {
        this.discoverers = new ArrayList<>();
    }

    public Collection<Discoverer> getDiscoverers() {
        return discoverers;
    }

    public void setDiscoverers(Collection<Discoverer> discoverers) {
        this.discoverers = discoverers;
    }

    @Override
    public Collection<Discoverer> getCollection() {
        //•	Returns an unmodifiable collection of discoverers.
        return Collections.unmodifiableCollection(this.discoverers);
    }

    @Override
    public void add(Discoverer entity) {
        //•	Adds a discoverer to the base.
        //•	Every discoverer is unique in the collection.
        //o	It is guaranteed that there will not be a discoverer with the same name.
        this.discoverers.add(entity);

    }

    //•	Removes a discoverer from the collection. Returns true if the deletion was successful
    @Override
    public boolean remove(Discoverer entity) {
        return this.discoverers.remove(entity);
    }

    @Override
    public Discoverer byName(String name) {
        //•	Returns a discoverer with that name.
        //•	If the discoverer is not in the collection, return null.
        return this.discoverers.stream().filter(n->n.getName().equals(name)).findFirst().orElse(null);
    }
}
