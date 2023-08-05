package magicGame.core;

import magicGame.common.ExceptionMessages;
import magicGame.common.OutputMessages;
import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;
import magicGame.models.magics.BlackMagic;
import magicGame.models.magics.Magic;
import magicGame.models.magics.RedMagic;
import magicGame.models.region.Region;
import magicGame.models.region.RegionImpl;
import magicGame.repositories.interfaces.MagicRepository;
import magicGame.repositories.interfaces.MagicRepositoryImpl;
import magicGame.repositories.interfaces.MagicianRepository;
import magicGame.repositories.interfaces.MagicianRepositoryImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller{
    private MagicRepository<Magic> magics;
    private MagicianRepository<Magician> magicians;
    private Region region;

    public ControllerImpl() {
        this.magics = new MagicRepositoryImpl();
        this.magicians = new MagicianRepositoryImpl();
        this.region = new RegionImpl();
    }

    @Override
    public String addMagic(String type, String name, int bulletsCount) {
        //Adds a Magic and adds it to the MagicRepositoryImpl. Valid types are "RedMagic" and "BlackMagic".
        //If the Magic type is invalid, you have to throw an IllegalArgumentException with the following message:
        //•	"Invalid magic type!"
        //If the Magic is added successfully, the method should return the following String:
        //•	"Successfully added magic {magicName}."
        Magic magic;//създаваме magic
        if (type.equals("RedMagic")){
            magic=new RedMagic(name,bulletsCount);

        }
        else if (type.equals("BlackMagic")) {
            magic = new BlackMagic(name,bulletsCount);


        }
        else{
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_TYPE);
        }

        magics.addMagic(magic);
        return String.format(OutputMessages.SUCCESSFULLY_ADDED_MAGIC,name);
    }

    @Override
    public String addMagician(String type, String username, int health, int protection, String magicName) {
        //Creates a Magician of the given type and adds it to the MagicianRepositoryImpl. Valid types are: "Wizard" and "BlackWidow".
        //If the magic is not found throw NullPointerException with a message:
        //•	"Magic cannot be found!"
        //If the magician type is invalid, throw an IllegalArgumentException with the message:
        //•	"Invalid magician type!"
        //The method should return the following String if the operation is successful:
        //•	"Successfully added magician {username}."

        Magician magician;//създаваме magician
        //създаваме Magic с даденото magicName в метода
        Magic magic = (Magic) magics.findByName(magicName);//If the magic is not found throw NullPointerException with a message:
        if (magic==null){
            throw new NullPointerException(ExceptionMessages.MAGIC_CANNOT_BE_FOUND);
        }
        if (type.equals("Wizard")){

            magician=new Wizard(username,health,protection,magic);

        }
        else if (type.equals("BlackWidow")) {
            magician=new BlackWidow(username,health,protection,magic);

        }
        else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGIC_TYPE);
        }

        magicians.addMagician(magician);
        return String.format(OutputMessages.SUCCESSFULLY_ADDED_MAGICIAN,username);
    }

    @Override
    public String startGame() {
//The game starts with all magicians that are alive! Returns the result from the start() method.
        return region.start(magicians.getData());
    }

    @Override
    public String report() {
        //Returns information about each magician separated with a new line.
        // Order then by health ascending, then by username alphabetically,
        // then by type alphabetically. You can use the overridden .toString() Magician method.
        //"{magician type}: {magician username}
        // Health: {magician health}
        // Protection: {magician protection}
        // Magic: {magician magic name}"
        //Note: Use System.lineSeparator() for a new line and don't forget to trim if you use StringBuilder.

        StringBuilder sb = new StringBuilder();
        List<Magician> magicianList = magicians.getData().stream().sorted(Comparator.comparing(Magician::getHealth).
                                        thenComparing(Magician::getUsername)).collect(Collectors.toList());
        for (Magician magician : magicianList) {
            int health = magician.getHealth();
            if (magician.getHealth()<0){
                health=0;
            }
            int protection = magician.getProtection();
            if (magician.getProtection()<0){
                protection = 0;

            }
            sb.append(String.format("%s: %s",magician.getClass().getSimpleName(),magician.getUsername())).append(System.lineSeparator());
                    sb.append(String.format("Health: %s",health)).append(System.lineSeparator()).
                            append(String.format("Protection: %s",protection)).append(System.lineSeparator())
                            .append(String.format(" Magic: %s",magician.getMagic().getName())).append(System.lineSeparator());

        }

        return sb.toString().trim();
    }
}
