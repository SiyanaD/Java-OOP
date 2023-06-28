package EncapsulationLabJune.P04FirstAndReserveTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    //The class should have private fields for:
    //• name: String
    //• firstTeam: List<Person>
    //• reserveTeam: List<Person>
    private String name;
    private List<Person> firstTeam;
    private List<Person> reserveTeam;


    public Team(String name) {
        setName(name);
        this.firstTeam=new ArrayList<>();
        this.reserveTeam = new ArrayList<>();
    }
    //The class should also have private method for setName and public methods for:
    //• getName(): String
    //• addPlayer(Person person): void
    //• getFirstTeam(): List<Person> (Collections.unmodifiableList)
    //• getReserveTeam(): List<Person> (Collections.unmodifiableList)
    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void addPlayer(Person person){
        if (person.getAge()<40){
            this.firstTeam.add(person);
        }
        else {
            this.reserveTeam.add(person);
        }

    }

    public List<Person> getFirstTeam() {

        return Collections.unmodifiableList(firstTeam);
    }

    public List<Person> getReserveTeam() {
        return Collections.unmodifiableList(reserveTeam);
    }
}
