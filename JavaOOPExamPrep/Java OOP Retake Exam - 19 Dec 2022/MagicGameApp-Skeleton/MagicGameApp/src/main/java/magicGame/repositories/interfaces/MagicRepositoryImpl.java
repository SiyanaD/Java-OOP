package magicGame.repositories.interfaces;

import magicGame.common.ExceptionMessages;
import magicGame.models.magics.Magic;

import java.util.ArrayList;
import java.util.Collection;

public class MagicRepositoryImpl implements MagicRepository<Magic>{
    //•	data - a Collection of magics
private Collection<Magic> data;


    public MagicRepositoryImpl() {
        this.data = new ArrayList<>();
    }

    @Override
    public Collection<Magic> getData() {
        return this.data;
    }

    @Override
    public void addMagic(Magic model) {

        //•	If the magic is null, throw a
        // NullPointerException with a message: "Cannot add null in Magic Repository."
        //•	Adds magic to the collection.
        if (model==null){
            throw new NullPointerException(ExceptionMessages.INVALID_MAGIC_REPOSITORY);
        }
        this.data.add(model);
    }

    @Override
    public boolean removeMagic(Magic model) {
        //•	Removes magic from the collection. Returns true if the removal was successful, otherwise - false.
        return this.data.remove(model);
    }

    @Override
    public Magic findByName(String name) {
        //•	Returns the first magic with the given name, if there is such a magic. Otherwise, returns null.
        return data.stream().filter(m->m.getName().equals(name)).findFirst().orElse(null);
    }
}
