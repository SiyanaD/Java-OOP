package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.cocktails.interfaces.Cocktail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CocktailRepositoryImpl implements CocktailRepository<Cocktail> {
    private Collection<Cocktail> models;

    public CocktailRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public Cocktail getByName(String name) {
        //Returns an entity with that name

        return this.models.stream().filter(n->n.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Cocktail> getAll() {
        //Returns all entities (unmodifiable
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Cocktail cocktail) {
        //Adds an entity in the collection.
        this.models.add(cocktail);

    }
}
