package magicGame.models.magics;

public class RedMagic extends MagicImpl {
    private static final int BULLETS=1;



    public RedMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    private int allBullets= getBulletsCount();

//The fire() method fires the number of bullets the Magic has and reduces its available amount.
// RedMagic can fire only 1 bullet and the BlackMagic only 10 at once, not more, not less.
// If there are not enough bullets, the method should return 0.
    @Override
    public int fire() {
       if (allBullets-BULLETS<0){
           allBullets=0;
        // If there are not enough bullets, the method should return 0.
           return 0;

       }
       else {
           allBullets-=BULLETS;
           // RedMagic can fire only 1 bullet
           return BULLETS;
       }
    }
}
