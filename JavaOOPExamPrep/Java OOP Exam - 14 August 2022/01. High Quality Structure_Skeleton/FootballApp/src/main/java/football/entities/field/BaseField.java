package football.entities.field;

import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseField implements Field{
    //BaseField is a base class of any type of Field, and it should not be able to be instantiated. - abstract

    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    public BaseField(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.supplements=new ArrayList<>();
        this.players=new ArrayList<>();

    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        //o	If the name is null or whitespace,
        // throw a NullPointerException with a message:
        //"Field name cannot be null or empty."
        if ((name==null || name.equals(""))){
            throw new NullPointerException(ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return supplements;
    }

    public void setSupplements(Collection<Supplement> supplements) {
        this.supplements = supplements;
    }

    //Returns the sum of each supplement's energy in the Field.
    @Override
    public int sumEnergy() {
        int sum = 0;
        for (Supplement supplement : this.getSupplements()) {
            sum+=supplement.getEnergy();
        }
        return sum;
    }

    //Adds a Player on the Field if there is a capacity for it.
    //If there is not enough capacity to add the Player in the Field throw
    // an IllegalStateException with the following message:
    //•	"Not enough capacity."
    @Override
    public void addPlayer(Player player) {
        if (this.getPlayers().size()>=this.capacity){
            throw new IllegalArgumentException(ConstantMessages.NOT_ENOUGH_CAPACITY);
        }

        this.getPlayers().add(player);
    }

    //Removes a Player from the Field.
    @Override
    public void removePlayer(Player player) {

        this.getPlayers().remove(player);
    }

    //Adds a Supplement in the Field
    @Override
    public void addSupplement(Supplement supplement) {
        this.getSupplements().add(supplement);

    }

    //The drag() method stimulated all players on the field
    @Override
    public void drag() {
        for (Player player :this.getPlayers()) {
            player.stimulation();

        }

    }

    //Returns a String with information about the Field in the format below.
    // If the Field doesn't have a player, print "none" instead.
    //"{fieldName} ({fieldType}):
    //Player: {playerName1} {playerName2} {playerName3} (…) / Player: none
    //Supplement: {supplementsCount}
    //Energy: {sumEnergy}"
    @Override
    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%s %s:%n",this.getName(),this.getClass().getSimpleName())).append(System.lineSeparator());
        stringBuilder.append("Player: ");
        if (this.getPlayers().isEmpty()){
            stringBuilder.append("none");
            stringBuilder.append(System.lineSeparator());
        }
        else {
            stringBuilder.append(this.getPlayers().stream().map(Player::getName).collect(Collectors.joining(", ")).trim());
            stringBuilder.append(System.lineSeparator());
        }

        //Supplement: {supplementsCount}
        stringBuilder.append(String.format("Supplement: %d",this.getSupplements().size())).append(System.lineSeparator());
        //Energy: {sumEnergy}"
        stringBuilder.append(String.format("Energy: %d",this.sumEnergy())).append(System.lineSeparator());

        return stringBuilder.toString().trim();
    }

    @Override
    public Collection<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Collection<Player> players) {
        this.players = players;
    }
}
