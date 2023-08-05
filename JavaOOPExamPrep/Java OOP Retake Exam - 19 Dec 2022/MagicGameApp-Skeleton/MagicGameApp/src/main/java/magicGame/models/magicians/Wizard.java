package magicGame.models.magicians;

import magicGame.models.magics.Magic;

public class Wizard extends MagicianImpl{

    //The constructor should take the following values upon initialization:
    //(String username, int health, int protection, Magic magic)

    public Wizard(String username, int health, int protection, Magic magic) {
        super(username, health, protection, magic);
    }
}
