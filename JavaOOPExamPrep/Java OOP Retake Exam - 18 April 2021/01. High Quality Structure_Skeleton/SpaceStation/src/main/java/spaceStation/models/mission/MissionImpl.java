package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission{

    //Here is how the Explore method works:
    //•	The astronauts start going out into open space one by one. They can't go if they don't have any oxygen left.
    //•	An astronaut lands on a planet and starts collecting its items one by one.
    //•	He finds an item and he takes a breath.
    //•	He adds the item to his backpack and respectively the item must be removed from the planet.
    //•	Astronauts can't keep collecting items if their oxygen becomes 0.
    //•	If it becomes 0, the next astronaut starts exploring.
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        for (Astronaut astronaut : astronauts) {
            //•	The astronauts start going out into open space one by one. They can't go if they don't have any oxygen left.
            while (astronaut.getOxygen()>0){
                for (String item : planet.getItems()) {
                   astronaut.getBag().getItems().add(item);
                   if (item==null){
                       break;
                   }
                   astronaut.canBreath();
                   planet.getItems().remove(item);
                }
            }
        }
    }
}
