package vehicleShop.repositories;

import vehicleShop.models.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

//Repository<T> interface - <T> той е generic т.е. може да съхраняваме всякакви типове,
//The vehicle repository is a repository for vehicles that await to be made.
public class VehicleRepository implements Repository<Vehicle>{
    private Collection<Vehicle> vehicles;

    public VehicleRepository() {
        this.vehicles = new ArrayList<>();
    }

    //•	Returns a collection of workers (unmodifiable).
    @Override
    public Collection<Vehicle> getWorkers() {
        return Collections.unmodifiableCollection(vehicles);
    }

    //•	Adds a vehicle to be making.
    //•	There will be no vehicle of the same name
    @Override
    public void add(Vehicle vehicle) {
        this.vehicles.add(vehicle);

    }
    //•	Removes a vehicle from the collection.
    //•	Returns true if the deletion was successful.
    @Override
    public boolean remove(Vehicle vehicle) {
        return vehicles.remove(vehicle);
    }

    //•	Returns a vehicle with that name if such exists.
    //•	It is guaranteed that the vehicle exists in the collection.
    @Override
    public Vehicle findByName(String name) {
        return vehicles.stream().filter(v->v.getName().equals(name)).findFirst().orElse(null);
    }
}
