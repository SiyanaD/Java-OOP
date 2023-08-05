package goldDigger.core;

import goldDigger.common.ConstantMessages;
import goldDigger.common.ExceptionMessages;
import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.models.museum.BaseMuseum;
import goldDigger.models.museum.Museum;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.SpotRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller{
    private DiscovererRepository discovererRepository;
    private SpotRepository spotRepository;
    private int inspectSpotCount;


   // The constructor of ControllerImpl does not take any arguments
    public ControllerImpl() {
        this.discovererRepository=new DiscovererRepository();
        this.spotRepository=new SpotRepository();

    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        //Creates a discoverer with the given name of the given kind and saves it in the repository.
        // If the kind is invalid, throw an IllegalArgumentException with the following message:
        //"Discoverer kind doesn't exists."
        //Otherwise, the method should return the following message:
        //•	"Added {kind}: {discovererName}."
        Discoverer discoverer;//създаваме discoverer
        //kind
        //Archaeologist
        //Anthropologist
        //Geologist
        if (kind.equals("Archaeologist")){
            discoverer=new Archaeologist(discovererName);
        } else if (kind.equals("Anthropologist")) {
            discoverer=new Anthropologist(discovererName);

        } else if (kind.equals("Geologist")) {
            discoverer=new Geologist(discovererName);

        }
        else {
            throw new IllegalArgumentException(ExceptionMessages.DISCOVERER_INVALID_KIND);
        }
        discovererRepository.add(discoverer);//съхраняваме discoverer в discovererRepository

        return String.format(ConstantMessages.DISCOVERER_ADDED,kind,discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        //Creates a spot with the provided exhibits and name and save it in the repository.
        //The method should return the following message:
        //•	"Added spot: {spotName}."
        Spot spot = new SpotImpl(spotName);
        spot.getExhibits().addAll(Arrays.asList(exhibits));
        this.spotRepository.add(spot);//добавяме в spotRepository добавеният Spot
        return String.format(ConstantMessages.SPOT_ADDED,spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        //Exclude the discoverer from diggings by removing them from the repository.
        // If a discoverer with that name doesn’t exist, throw IllegalArgumentException with the following message:
        //•	"Discoverer {discovererName} doesn't exists."
        // If a discoverer is successfully excluded, remove them from the repository and return the following message:
        //•	"Discoverer {discovererName} has excluded!"

        //взимаме списъка с discoverer и проверяваме дали подаденот име го няма noneMatch
        if (this.discovererRepository.getDiscoverers().stream().noneMatch(d->d.getName().equals(discovererName))){
            //getDiscoverers() - взима всички discoverer
            throw new IllegalArgumentException(String.format(ExceptionMessages.DISCOVERER_DOES_NOT_EXIST,discovererName));
        }
        Discoverer discovererToRemove = this.discovererRepository.byName(discovererName);
        this.discovererRepository.remove(discovererToRemove);
        return String.format(ConstantMessages.DISCOVERER_EXCLUDE,discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {
        //When the inspect command is called, the action happens. You should start inspecting the given spot by
        // sending the discoverers that are most suitable for the mission:
        //•	You call each of the discoverers and pick only the ones that have energy above 45 units.
        //•	If you don't have any suitable discoverers, throw an IllegalArgumentException with the following message:
        // "You must have at least one discoverer to inspect the spot."
        //•	After a mission, you must return the following message with the name of the inspected spot and the count of
        // the discoverers that had excluded on the mission:
        //"The spot {spotName} was inspected. {excludedDiscoverer} discoverers have been excluded on this operation."

        //взимаме всички discoverers с енергия над 45
        List<Discoverer> suitableDiscoverer = this.discovererRepository.getDiscoverers().stream()
                .filter(n->n.getEnergy()>45).collect(Collectors.toList());


        if (suitableDiscoverer.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }
        int discovererBeforeMission = suitableDiscoverer.size();
      //взимаме една операция
       Operation operation = new OperationImpl();

       Spot spot = this.spotRepository.byName(spotName);
        //след това искаме мисията да изпълни startOperation върху spotName със списъка от discovery suitableDiscoverer
       operation.startOperation(spot,suitableDiscoverer);
       inspectSpotCount++;
       int discovererAfterMission = suitableDiscoverer.size();

        return String.format(ConstantMessages.INSPECT_SPOT,spotName,discovererBeforeMission-discovererAfterMission);
    }

    @Override
    public String getStatistics() {
        //Returns the information about the discoverers in the following format:
        //•	If the discoverers don't have any museum exhibits, print "None" in their place.
        //"{inspectedSpotCount} spots were inspected.
        //Information for the discoverers:
        //Name: {discovererName}
        //Energy: {discovererName}
        //Museum exhibits: {museumExhibits1, museumExhibits2, museumExhibits3, …, museumExhibits n}"
        //…
        //Name: {discovererName}
        //Energy: {discovererEnergy}
        //Museum exhibits: museumExhibits1, museumExhibits2, museumExhibits3, …, museumExhibits n}"

        StringBuilder sb = new StringBuilder();
        sb.append(String.format(ConstantMessages.FINAL_SPOT_INSPECT,inspectSpotCount)).append(System.lineSeparator());
        //след това трябва да обходим всички discoverers и за всеки един трябва да вземем съответните неща
        sb.append(ConstantMessages.FINAL_DISCOVERER_INFO).append(System.lineSeparator());
        this.discovererRepository.getDiscoverers().forEach(d->{
            //Name: {discovererName}
            sb.append(String.format(ConstantMessages.FINAL_DISCOVERER_NAME,d.getName())).append(System.lineSeparator());
            //Energy: {discovererName}
            sb.append(String.format(ConstantMessages.FINAL_DISCOVERER_ENERGY,d.getEnergy())).append(System.lineSeparator());
            //Museum exhibits: museumExhibits1, museumExhibits2, museumExhibits3, …, museumExhibits n}"
            //проверяваме дали няма нищо
            if (d.getMuseum().getExhibits().size()==0){
                sb.append(String.format(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS,"None")).append(System.lineSeparator());
            }

            //ако име нещо
            else {
                Collection<String> museumExhibits = d.getMuseum().getExhibits();
                sb.append(String.format(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS,String.join(", ",museumExhibits)))
                        .append(System.lineSeparator());
            }
        });




        return sb.toString().trim();
    }
}
