package goldDigger.models.operation;

import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.spot.Spot;

import java.util.Collection;

public class OperationImpl implements Operation{
    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {
        //Here is how the startOperation method works:
        //•	Discoverers cannot go on expeditions if their energy is below 0.
        //•	They leave the base and start collecting exhibits one by one.
        //•	If they find an exhibit, their energy is decreased.
        //•	They add the exhibit to their museum. The exhibit should then be removed from the state.
        //•	Discoverers cannot continue collecting exhibits if their energy drops to 0.
        //o	If their energy drops to 0, the next discoverer starts inspecting

        for (Discoverer discoverer : discoverers) {

            while (discoverer.getEnergy()>0){
                //•	Discoverers cannot go on expeditions if their energy is below 0.
                //•	They leave the base and start collecting exhibits one by one.
                for (String exhibit : spot.getExhibits()) {
                    discoverer.getMuseum().getExhibits().add(exhibit);
                    if (exhibit==null){
                        break;
                    }
                    discoverer.canDig();
                    spot.getExhibits().remove(exhibit);
                }

            }

        }

    }
}
