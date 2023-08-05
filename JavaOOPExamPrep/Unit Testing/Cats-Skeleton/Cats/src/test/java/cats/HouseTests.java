package cats;

import org.junit.Assert;
import org.junit.Test;

public class HouseTests {

    //1 Тестваме конструктора
    //1.1 тестваме невалидно capacity

    @Test(expected = IllegalArgumentException.class)
    public void testCreateHouseWithInvalidCapacity(){
        new House("House1",-4);//capacity < 0
    }
    //1.2 невалидно name което е null
    @Test(expected = NullPointerException.class)
    public void testCreatingHouseWithInvalidName(){
        new House(null,3);
    }
    //1.3 невалидно name което е празно
    @Test(expected = NullPointerException.class)
    public void testCreatingHouseWithEmptyName(){
        new House(" ",5);
    }

    //1.4 тестваме ако имаме валидни стойности
    @Test
    public void testCreateHouse(){
        House house = new House("House1",10);
        Assert.assertEquals("House1",house.getName());
        Assert.assertEquals(10,house.getCapacity());
    }

    //2.a2.ddCat
    //2.1 успешно добавяме котка
    @Test
    public void testAddCat(){
        //създаваме къща
        House house = new House("House1",10);
        Cat mike = new Cat("Mike");
        Assert.assertEquals(0,house.getCount());

        house.addCat(mike);
        Assert.assertEquals(1,house.getCount());
    }
    //2.2 добавяме котката в пълна къща(няма място за котката)
    @Test(expected = IllegalArgumentException.class)
    public void testAddCatThrowFilledHouse(){
        //създаваме къща с котка с 1 капацитет
        House house = new House("House1",1);
        Cat mike = new Cat("Mike");
        house.addCat(mike);

        //създаваме втора котка и хвърля exception
        Cat betty = new Cat("Betty");
        house.addCat(betty);

    }

    //3.removeCat
    //3.1 успешно премахваме котката
    @Test
    public void testRemoveCat(){
        House house = new House("House1",10);
        Cat mike = new Cat("Mike");
        Cat betty = new Cat("Betty");
        house.addCat(mike);
        house.addCat(betty);
        //проверяваме след добавянето дали броя на котките в къщата е 2
        Assert.assertEquals(2,house.getCount());


        house.removeCat("Betty");
        Assert.assertEquals(1,house.getCount());

        house.removeCat("Mike");
        Assert.assertEquals(0,house.getCount());
    }
    //3.2 няма такава котка в къщата
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistingCat(){
        //създаваме къща с капацитет 10 но не сме добавяли котки
        House house = new House("House1",10);
        house.removeCat("Ivan");

    }

    //catForSale
    //4.1 успешно да продадем котката->гладна
    @Test
    public void catForSale(){
        House house = new House("House1",10);
        Cat mike = new Cat("Mike");
        house.addCat(mike);
      Cat returnCat =  house.catForSale("Mike");
      Assert.assertFalse(returnCat.isHungry());
    }
    //4.2 нямаме котка с даденото име
    @Test(expected = IllegalArgumentException.class)
    public void testForSaleNonExistingCat(){
        House house = new House("House1",10);
        house.catForSale("Ivan");

    }

    //5.statistics
    @Test
    public void testStatistics(){
        House house = new House("House1",10);
        Cat mike = new Cat("Mike");
        Cat betty = new Cat("Betty");
        Cat john = new Cat("John");
        house.addCat(mike);
        house.addCat(betty);
        house.addCat(john);

        Assert.assertEquals("The cat Mike, Betty, John is in the house House1!",
                house.statistics());



    }


}
