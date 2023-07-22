package vehicleShop.repositories;

import vehicleShop.models.worker.Worker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
//Repository<T> interface - <T> той е generic т.е. може да съхраняваме всякакви типове,
//The worker repository is a repository for the worker working at Vehicle’s Shop.
public class WorkerRepository implements Repository<Worker> {
    //депо за съхранение на работници
    private Collection<Worker> workers;
//създаваме конструктор на Collection<Worker> и правим нов списък new ArrayList<>()
    public WorkerRepository() {
        this.workers =new ArrayList<>();

    }

    //•	Returns a collection of workers (unmodifiable).- колекция която неможе да се модифицира
    @Override
    public Collection<Worker> getWorkers() {
        return Collections.unmodifiableCollection(workers);
    }

    //•	Adds a worker to the collection.
    //•	There will be no workers of the same name.
    @Override
    public void add(Worker worker) {
        this.workers.add(worker);
    }

//•	Removes a worker from the collection.
//•	Returns true if the deletion was successful.
    @Override
    public boolean remove(Worker worker) {
        return workers.remove(worker);
    }

    //•	Returns a worker with that name if such exists. If it doesn't exist - return null
    @Override
    public Worker findByName(String name) {
        return workers.stream().
                filter(w->w.getName().equals(name)).
                findFirst().orElse(null);
    }
}
