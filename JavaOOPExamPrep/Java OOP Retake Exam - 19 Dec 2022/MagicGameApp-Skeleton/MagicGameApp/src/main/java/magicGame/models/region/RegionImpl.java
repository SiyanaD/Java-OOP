package magicGame.models.region;

import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RegionImpl implements Region{


    //Separates the magicians into two types - Wizard and Black Widow.
    // The game continues until one of the teams is completely dead (all magicians have 0 health).
    // Both magician groups take a turn shooting at each other – first is the Wizards,
    // then the Black Widows inflict damage equal to their bullet fired from their Magic.
    // Make sure the Magician has enough bullets before he/she tries to attack!
    //The damage they deal comes from each magic property of each Magician.
    //If Wizards win return "Wizards win!" otherwise return "Black widows win!"
    @Override
    public String start(Collection<Magician> magicians) {
        List<Magician> wizardList = new ArrayList<>();//списък за Wizard
        List<Magician> blackWidowList = new ArrayList<>();//списък за BlackWidow

        for (Magician magician :magicians) {//итерираме Magician и добавяна всеки един от Wizard и BlackWidow в техните списъци
            if (magician.getClass().getSimpleName().equals("Wizard")){
                wizardList.add(magician);
            } else if (magician.getClass().getSimpleName().equals("BlackWidow")) {
                blackWidowList.add(magician);
            }
        }
        // then the Black Widows inflict damage equal to their bullet fired from their Magic.
        // Make sure the Magician has enough bullets before he/she tries to attack!
        //The damage they deal comes from each magic property of each Magician.
        while (!wizardList.isEmpty() && !blackWidowList.isEmpty()){
            Wizard wizard = (Wizard) wizardList.get(0);
            BlackWidow blackWidow = (BlackWidow) blackWidowList.get(0);
            if (blackWidow.isAlive()){
           // then the Black Widows inflict damage equal to their bullet fired from their Magic.
            blackWidow.takeDamage(blackWidow.getMagic().fire());
            if (!wizard.isAlive()){
                wizardList.remove(wizard);
            }
        }
            else {
                blackWidowList.remove(blackWidow);
            }
        }

        if (wizardList.size()>blackWidowList.size()){
            return "Wizards win!";
        }
        else {
            return "Black widows win!";
        }

    }
}
