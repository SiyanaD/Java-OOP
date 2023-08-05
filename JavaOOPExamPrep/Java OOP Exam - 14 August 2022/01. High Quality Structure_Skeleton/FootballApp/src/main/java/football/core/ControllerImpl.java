package football.core;


import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

import static football.common.ConstantMessages.*;
import static football.common.ExceptionMessages.INVALID_PLAYER_TYPE;
import static football.common.ExceptionMessages.NO_SUPPLEMENT_FOUND;

public class ControllerImpl implements Controller {

    private SupplementRepository supplement;
    private Collection<Field> fields;
    //The constructor of ControllerImpl does not take any arguments
    public ControllerImpl() {
        this.supplement= new SupplementRepositoryImpl();
        this.fields=new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        //Adds a Field. Valid types are: "ArtificialTurf" and "NaturalGrass".
        //If the Field type is invalid, you have to throw a NullPointerException with the following message:
        //•	"Invalid field type."
        //If the Field is added successfully, the method should return the following String:
        //•	"Successfully added {fieldType
        Field field;
        if (fieldType.equals("ArtificialTurf")){
            field=new ArtificialTurf(fieldName);
            fields.add(field);

        }
        else if (fieldType.equals("NaturalGrass")) {
            field=new NaturalGrass(fieldName);
            fields.add(field);

        }
        else {
            throw new NullPointerException(ExceptionMessages.INVALID_FIELD_TYPE);
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FIELD_TYPE,fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        //Creates a supplement of the given type and adds it to the SupplementRepository.
        // Valid types are "Powdered" and "Liquid". If the supplement type is invalid, throw an IllegalArgumentException with a message:
        //•	"Invalid supplement type."
        //The method should return the following String if the operation is successful:
        //•	"Successfully added {supplementType}."
        Supplement supplement1;
        if (type.equals("Powdered")){
            supplement1=new Powdered();
            supplement.add(supplement1);
        } else if (type.equals("Liquid")) {
            supplement1=new Liquid();
            supplement.add(supplement1);
        }
        else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FIELD_TYPE,type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        //Adds the desired Supplement to the Field with the given name. You have to remove the Supplement from the
        // SupplementRepository if the insert is successful.
        //If there is no such supplement, you have to throw an IllegalArgumentException with the following message:
        //•	"There isn't a Supplement of type {supplementType}."
        //If no exceptions are thrown return the String:
        //•	"Successfully added {supplementType} to {fieldName}."

        Field field = getFieldByName(fieldName);
        Supplement supplement = this.supplement.findByType(supplementType);
        if (supplement == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND,supplementType));
        }
        field.addSupplement(supplement);

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD,supplementType , fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {

        //Check if the player type is valid. Valid Player types are: "Men", "Women". Adds the desired Player to the Field with the given name.
        //If the Player type is invalid, you have to throw an IllegalArgumentException with the following message:
        //•	"Invalid player type." - if the Player type is invalid.
        //If no errors are thrown, return one of the following strings:
        //•	"The pavement of the terrain is not suitable." - if the Player cannot play in the Field
        //•	"Successfully added {playerType} to {fieldName}." - if the Player is added successfully in the Field

        Field field = getFieldByName(fieldName);
        Player player;
        switch (playerType) {
            case "Women":
                player = new Women(playerName, nationality, strength);
                break;
            case "Men":
                player = new Men(playerName, nationality, strength);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }
        if (field.getClass().getSimpleName().equals("ArtificialTurf") && playerType.equals("Women")) {
            field.addPlayer(player);
        } else if (field.getClass().getSimpleName().equals("NaturalGrass") && playerType.equals("Men")) {
            field.addPlayer(player);
        } else {
            return FIELD_NOT_SUITABLE;
        }
        return String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
    }

    private Field getFieldByName(String fieldName) {
        return this.fields.stream().filter(n->n.getName().equals(fieldName)).findFirst().orElse(null);
    }

    @Override
    public String dragPlayer(String fieldName) {
        //Drag all Player in the Field with the given name.
        //Returns a string with information about how many players
        // were successfully dragged in the following format:
        //•	"Player drag: {dragCount}"
        Field field = getFieldByName(fieldName);
        for (Player p : field.getPlayers()) {
            p.stimulation();
        }
        return String.format(PLAYER_DRAG, field.getPlayers().size());
    }

    @Override
    public String calculateStrength(String fieldName) {
        //Calculates the value of the Field with the given name.
        // It is calculated by the sum of all Players's strengths in the Field.
        //Return a string in the following format:
        //•	"The strength of Field {fieldName} is {value}."
        Field field = getFieldByName(fieldName);
        int sumStrength = 0;
        for (Player p : field.getPlayers()) {
            sumStrength += p.getStrength();
        }

        return String.format(STRENGTH_FIELD, fieldName, sumStrength);
    }

    @Override
    public String getStatistics() {
        //Returns information about each field. You can use the overridden
        // .getInfo Field method.
        //"{fieldName} ({fieldType}):
        //Player: {playerName1} {playerName2} {playerName3} (…) / Player: none
        //Supplement: {supplementsCount}
        //Energy: {sumEnergy}
        //{fieldName} ({fieldType}):
        //Player: {playerName1} {playerName2} {playerName3} (…) / Player: none
        //Supplement: {supplementsCount}
        //Energy: {sumEnergy}
        // (…)"
        //Note: Use \n or System.lineSeparator() for a new line.
        StringBuilder sb=new StringBuilder();
        for (Field field : this.fields) {
            sb.append(field.getInfo());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
