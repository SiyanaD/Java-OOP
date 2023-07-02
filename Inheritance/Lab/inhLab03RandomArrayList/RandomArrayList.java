package inhLab03RandomArrayList;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {
   private final Random random;
    //викаме базовия конструктор на ArrayList
    public  RandomArrayList(){
        super();
        this.random=new Random();
    }
    //Add an additional function that returns and removes a random element from the list.
    public T getRandomElement(){

        int index = random.nextInt(super.size());
        T result = super.get(index);
        super.remove(index);
        return result;
    }
}
