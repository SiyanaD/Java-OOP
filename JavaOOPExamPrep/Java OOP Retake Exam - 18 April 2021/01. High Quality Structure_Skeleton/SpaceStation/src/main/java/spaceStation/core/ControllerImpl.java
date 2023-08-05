package spaceStation.core;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private AstronautRepository astronautRepository;//мястото за съхранение на астронавти
    private PlanetRepository planetRepository;//мястото за съхранение на планети
   private int exploredPlanetsCount; // трябва ни за public String report() метода



    //The constructor of ControllerImpl does not take any arguments
    public ControllerImpl() {
        //поставяме нещата който сме добавили
        this.astronautRepository=new AstronautRepository();
        this.planetRepository=new PlanetRepository();

    }




    @Override
    public String addAstronaut(String type, String astronautName) {
        //Creates an astronaut with the given name of the given type. If the astronaut is invalid, throw an IllegalArgumentException with a message:
        //"Astronaut type doesn't exists!"
        //The method should return the following message:
        //•	"Successfully added {astronautType}: {astronautName}!"
        Astronaut astronaut ;//създаваме астронавт
        if (type.equals("Biologist")){
            astronaut=new Biologist(astronautName);
        }
        else if (type.equals("Geodesist")) {
            astronaut=new Geodesist(astronautName);
        } else if (type.equals("Meteorologist")) {
            astronaut=new Meteorologist(astronautName);
        }
        else {
            throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }
        astronautRepository.add(astronaut);//съхраняваме в astronautRepository създадения астронавт

        return String.format(ConstantMessages.ASTRONAUT_ADDED,type,astronautName);
    }



    @Override
    public String addPlanet(String planetName, String... items) {
        //Creates a planet with the provided items and name.
        //The method should return the following message:
        //•	"Successfully added Planet: {planetName}!"

        Planet planet = new PlanetImpl(planetName);
        //List<String> itemsList = Arrays.asList(items);//String... items преобразуваме items в лист и след това добавяме
        // planet.getItems().addAll(itemsList);
        planet.getItems().addAll(Arrays.asList(items));//или Arrays.asList(items)
        this.planetRepository.add(planet);//добавяме в planetRepository създадената планета

        return String.format(ConstantMessages.PLANET_ADDED,planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        //Retires the astronaut from the space station by removing it from its repository.
        // If an astronaut with that name doesn't exist, throw IllegalArgumentException with the following message:
        //•	"Astronaut {astronautName} doesn't exists!"
        // If an astronaut is successfully retired, remove it from the repository and return the following message:
        //•	"Astronaut {astronautName} was retired!"


        //взимаме списъка с астронавтите и проверяваме дали подаденот име го няма noneMatch
        if (this.astronautRepository.getModels().stream().noneMatch(а->а.getName().equals(astronautName))){//getModels() - взима всички астронавти
            throw new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST,astronautName));

        }

        Astronaut astronautToRemove = this.astronautRepository.findByName(astronautName);//взимаме нашия астронавт astronautName от Astronaut
        this.astronautRepository.remove(astronautToRemove);//и след това го изтриваме от списъка с астронавти

        return String.format(ConstantMessages.ASTRONAUT_RETIRED,astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        //When the explore command is called, the action happens. You should start exploring the given planet,
        // by sending the astronauts that are most suitable for the mission:
        //•	You call each of the astronauts and pick only the ones that have oxygen above 60 units.
        //•	You send suitable astronauts on a mission to explore the planet.
        //•	If you don't have any suitable astronauts, throw IllegalArgumentException with the following message:
        // "You need at least one astronaut to explore the planet!"
        //•	After a mission, you must return the following message,
        // with the name of the explored planet and the count of the astronauts that had given their lives for the mission:
        //"Planet: {planetName} was explored! Exploration finished with {deadAstronauts} dead astronauts!"

        //взимаме всички астронавти с кислород над 60
        List<Astronaut> suitableAstronaut = this.astronautRepository.getModels().stream()
                .filter(a->a.getOxygen()>60).collect(Collectors.toList());

        if (suitableAstronaut.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        int astronautsBeforeMission = suitableAstronaut.size();//броя на астронавтите преди мисията, за да намерим загиналите астронавти след това
        //взимаме една мисия
        Mission mission = new MissionImpl();
        //взимаме коя планета искаме да explore
        Planet planet = this.planetRepository.findByName(planetName);
        //след това искаме мисията да изпълни explore върху planetName със списъка от астронавти suitableAstronaut
        mission.explore(planet,suitableAstronaut);
        exploredPlanetsCount++;
        int astronautsAfterMission = suitableAstronaut.size();//броя на астронавтите след мисията


        return String.format(ConstantMessages.PLANET_EXPLORED,planetName,astronautsBeforeMission-astronautsAfterMission);
    }

    @Override
    public String report() {
        //Returns the information about the astronauts. If any of them doesn't have bag items, print "none" instead:
        //"{exploredPlanetsCount} planets were explored!
        //Astronauts info:
        //Name: {astronautName One}
        //Oxygen: {astronautOxygen One}
        //Bag items: {bagItem1, bagItem2, bagItem3, …, bagItemn \ none}
        //…
        //Name: {astronautName N}
        //Oxygen: {astronautOxygen N}
        //Bag items: {bagItem1, bagItem2, bagItem3, …, bagItemn \ none}"

        StringBuilder sb = new StringBuilder();
        sb.append(String.format(ConstantMessages.REPORT_PLANET_EXPLORED,exploredPlanetsCount)).append(System.lineSeparator());
        sb.append(ConstantMessages.REPORT_ASTRONAUT_INFO).append(System.lineSeparator());
        //след това трябва да обходим всички астронавти и за всеки един астронавт трябва да отпечатаме съответните неща
        this.astronautRepository.getModels().forEach(a->{
            //Name: {astronautName One}
            sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_NAME,a.getName())).append(System.lineSeparator());
            //Oxygen: {astronautOxygen One}
            sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_OXYGEN,a.getOxygen())).append(System.lineSeparator());
            //Bag items: {bagItem1, bagItem2, bagItem3, …, bagItemn \ none}
            //проверяваме дали в чантата няма нищо
            if (a.getBag().getItems().size()==0){
                sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS,"none")).append(System.lineSeparator());
            }
            //ако астронавта има нещо в чантата
            else {
                //взимаме списъка с Bag items
                Collection<String> items = a.getBag().getItems();

                sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS,String.join(", ",items))).append(System.lineSeparator());
            }
        });

        return sb.toString().trim();
    }
}
