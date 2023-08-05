package magicGame.models.magics;

import magicGame.common.ExceptionMessages;

public abstract class MagicImpl implements Magic{
    //MagicImpl is a base class of any type of magic and it should not be able to be instantiated. -  abstract
    private String name;
    private int bulletsCount;

    public MagicImpl(String name, int bulletsCount) {
        this.setName(name);
        this.setBulletsCount(bulletsCount);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        //o	If the name is null or whitespace,
        // throw a NullPointerException with a message: "Magic cannot be null or empty."
        //o	All names are unique.
        if (name==null || name.equals("")){
            throw new NullPointerException(ExceptionMessages.INVALID_MAGIC_NAME);
        }
        this.name = name;
    }

    @Override
    public int getBulletsCount() {
        return bulletsCount;
    }

    //The fire() method fires the number of bullets the Magic has and reduces its available amount.
    // RedMagic can fire only 1 bullet and the BlackMagic only 10 at once, not more, not less.
    // If there are not enough bullets, the method should return 0.
    @Override
    public abstract int fire();//правим метода abstract защото ще държи по различен начин от класовете който ще наследява



    public void setBulletsCount(int bulletsCount) {
        //o	If the bullet count is below zero,
        // throw an IllegalArgumentException with a message: "Bullets cannot be below 0."
        if (bulletsCount<0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGIC_BULLETS_COUNT);
        }
        this.bulletsCount = bulletsCount;
    }
}
