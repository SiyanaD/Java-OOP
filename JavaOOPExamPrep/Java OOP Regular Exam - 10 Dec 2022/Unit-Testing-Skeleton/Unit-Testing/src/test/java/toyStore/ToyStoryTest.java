package toyStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class ToyStoryTest {

    private ToyStore toyStore;

    @Before
    public void createMapEveryMethod(){
        toyStore=new ToyStore();
    }
    @Test
    public void testToyStoreAndGetToyShelf(){
        Map<String,Toy> toyShelf;
        toyShelf=new LinkedHashMap<>();
        toyShelf.put("A",null);
        toyShelf.put("B",null);
        toyShelf.put("C",null);
        toyShelf.put("D",null);
        toyShelf.put("E",null);
        toyShelf.put("F",null);
        toyShelf.put("G",null);
        Assert.assertEquals(toyShelf,toyStore.getToyShelf());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddToyPart1() throws OperationNotSupportedException {
        Toy one = new Toy("TestOwner","TestItem");
        Toy two = new Toy("TestOwner","TestItem2");
        toyStore.addToy("A",one);
       long exist = toyStore.getToyShelf().values().
               stream().filter(Objects::nonNull).count();
       Assert.assertEquals(1,exist);
       toyStore.addToy("A",two);

    }

    @Test (expected = OperationNotSupportedException.class)
    public void testAddToyPart2() throws OperationNotSupportedException{
        Toy one = new Toy("TestOwner","TestItem");

        toyStore.addToy("A",one);
        toyStore.addToy("B",one);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddToyPart3() throws OperationNotSupportedException{
        Toy two = new Toy("TestOwner","TestItem2");
        toyStore.addToy("A23",two);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToyPart1() throws OperationNotSupportedException {
        Toy one = new Toy("TestOwner","TestItem");
        Toy two = new Toy("TestOwner","TestItem2");
        toyStore.addToy("A",one);
        toyStore.addToy("B",two);
        //if (!this.toyShelf.containsKey(shelf)
        // if (this.toyShelf.get(shelf) != toy)
        toyStore.removeToy("A",two);

        // throw new IllegalArgumentException("Shelf doesn't exists!");
        long exist = toyStore.getToyShelf().values().stream().filter(Objects::nonNull).count();
        Assert.assertEquals(1,exist);


    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToyShelfDoesNotExist(){
        String nonShelf = null;
        Toy toy = new Toy(null,"sToy");
        toyStore.removeToy(null,toy);
    }

    @Test
    public void testRemoveToyPart2() throws OperationNotSupportedException {
        Toy one = new Toy("TestOwner","TestItem");
        Toy two = new Toy("TestOwner","TestItem2");
        toyStore.addToy("A",one);
        toyStore.addToy("B",two);
        String result = toyStore.removeToy("B",two);
        long exist = toyStore.getToyShelf().values().stream().filter(Objects::nonNull).count();
        Assert.assertEquals(1,exist);
        Assert.assertEquals("Remove toy:TestItem2 successfully!",result);
    }

}