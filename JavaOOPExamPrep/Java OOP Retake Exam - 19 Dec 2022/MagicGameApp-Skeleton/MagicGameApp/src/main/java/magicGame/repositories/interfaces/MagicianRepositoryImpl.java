package magicGame.repositories.interfaces;

import magicGame.common.ExceptionMessages;
import magicGame.models.magicians.Magician;

import java.util.ArrayList;
import java.util.Collection;

public class MagicianRepositoryImpl implements MagicianRepository<Magician>{
    //•	data - a collection of magicians
    private Collection<Magician> data;

    public MagicianRepositoryImpl() {
        this.data = new ArrayList<>();

    }

    @Override
    public Collection<Magician> getData() {
        return this.data;
    }

    @Override

    public void addMagician(Magician model) {
        //•	If the magician is null, throw a .
        // NullPointerException with a message: "Cannot add null in Magician Repository.".
        //•	Adds a magician to the collection.
        if (model==null){
            throw new NullPointerException(ExceptionMessages.INVALID_MAGICIAN_REPOSITORY);
        }
        this.data.add(model);

    }

    @Override
    public boolean removeMagician(Magician model) {
        //•	Removes a magician from the collection.
        // Returns true if the removal was successful, otherwise - false.
        return this.data.remove(model);
    }

    @Override
    public Magician findByUsername(String name) {
        //•	Returns the first magician with the given username, if there is such a magician. Otherwise, returns null.
        return this.data.stream().filter(d->d.getUsername().equals(name)).findFirst().orElse(null);
    }
}
