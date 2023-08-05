package magicGame.models.magicians;

import magicGame.common.ExceptionMessages;
import magicGame.models.magics.Magic;

public abstract class MagicianImpl implements Magician{
    //MagicianImpl is a base class for any type of magician, and it should not be able to be instantiated. -  abstract
    private String username;
    private int health;
    private int protection;
    private boolean isAlive;
    private Magic magic;

    public MagicianImpl(String username, int health, int protection, Magic magic) {
        this.setUsername(username);
        this.setHealth(health);
        this.setProtection(protection);
        this.isAlive=true;//пишем го вътре в конструктора
        this.setMagic(magic);
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        //o	If the username is null or whitespace,
        // throw a NullPointerException with a message: "Username cannot be null or empty."
        //o	All names are unique.
        if ((username==null || username.equals(""))){
            throw new NullPointerException(ExceptionMessages.INVALID_MAGICIAN_NAME);
        }
        this.username = username;
    }

    @Override
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        //o	If the health is below 0,
        // throw an IllegalArgumentException with a message: "Magician health cannot be below 0."
        if (health<0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_HEALTH);
        }
        this.health = health;
    }

    @Override
    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        //o	If the protection is below 0,
        // throw an IllegalArgumentException with a message: "Magician protection cannot be below 0."
        if (protection<0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_PROTECTION);
        }
        this.protection = protection;
    }

    //o	If the health is above zero
    @Override
    public boolean isAlive() {
        return isAlive;
    }



    public void setAlive(boolean alive) {

        isAlive = alive;
    }

    @Override
    public Magic getMagic() {
        return magic;
    }

    public void setMagic(Magic magic) {
        //o	If the magic object is null,
        // throw a NullPointerException with a message: "Magic cannot be null."
        if (magic==null){
            throw new NullPointerException(ExceptionMessages.INVALID_MAGIC);
        }
        this.magic = magic;
    }

    //The takeDamage() method decreases the Magician's protection and health. First, you need to reduce the protection.
    // If the protection reaches 0, transfer the damage to health points.
    // If the health points are less than or equal to zero, the magician is dead.
    @Override
    public void takeDamage(int points) {
        // First, you need to reduce the protection.
        this.protection-=points;
        // If the protection reaches 0, transfer the damage to health points.
        if (this.protection<0){
            health+=this.protection;
        }
        // If the health points are less than or equal to zero, the magician is dead.
      if (health<=0){
          isAlive=false;
      }


    }
}
