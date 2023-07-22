package vehicleShop.repositories;

import java.util.Collection;

public interface Repository<T> {
    //Repository<T> - <T> той е generic т.е. може да съхраняваме всякакви типове,
    Collection<T> getWorkers();

    void add(T model);

    boolean remove(T model);

    T findByName(String name);
}
