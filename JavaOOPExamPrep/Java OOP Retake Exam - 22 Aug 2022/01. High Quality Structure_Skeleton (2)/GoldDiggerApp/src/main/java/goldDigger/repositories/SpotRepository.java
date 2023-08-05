package goldDigger.repositories;

import goldDigger.models.spot.Spot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SpotRepository implements Repository<Spot>{
    private Collection<Spot> spots;

    public SpotRepository() {
        this.spots = new ArrayList<>();
    }

    public Collection<Spot> getSpots() {
        return spots;
    }

    public void setSpots(Collection<Spot> spots) {
        this.spots = spots;
    }

    @Override
    public Collection<Spot> getCollection() {
        //•	Returns an unmodifiable collection of spots
        return Collections.unmodifiableCollection(this.spots);
    }

    @Override
    public void add(Spot entity) {

        //•	Adds a spot for inspection.
        //•	Every spot is unique in the collection.
        //o	It is guaranteed that there will not be a state with the same name.
        this.spots.add(entity);

    }

    @Override
    public boolean remove(Spot entity) {
        //•	Removes a spot from the collection. Returns true if the deletion was successful.
        return this.spots.remove(entity);
    }

    @Override
    public Spot byName(String name) {
        //•	Returns a spot with that name.
        //•	If the spot is not in the collection, return null.
        return this.spots.stream().filter(s->s.getName().equals(name)).findFirst().orElse(null);
    }
}
