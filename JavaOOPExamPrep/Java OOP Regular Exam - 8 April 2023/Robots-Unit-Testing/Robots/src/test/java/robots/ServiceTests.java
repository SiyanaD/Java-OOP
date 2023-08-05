package robots;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class ServiceTests {
    //1.Тестваме конструктора
//1.1 тестваме невалидно capacity
    @Test(expected = IllegalArgumentException.class)
    public void testServiceWithInvalidCapacity(){
        new Service("Service1",-1);//capacity < 0
    }

    //1.2 невалидно name което е null
    @Test(expected = NullPointerException.class)
    public void testCreatingServiceWithInvalidName(){
        new Service(null,4);
    }
    //1.3 невалидно name което е isEmpty()
    @Test(expected = NullPointerException.class)
    public void testCreatingServiceWithEmptyName(){
        new Service(" ",4);
    }
    //1.4 тестваме ако имаме валидни стойности
    @Test
    public void testCreateRobot(){
        Service service = new Service("Service1",5);
        Assert.assertEquals("Service1",service.getName());
        Assert.assertEquals(5,service.getCapacity());
    }
    //2 public void add(Robot robot)
    //2.1 успешно добавяме робот
    @Test
    public void testAddRobot(){
        //създаваме услуга
        Service service = new Service("Service1",5);
        Robot robot1 = new Robot("Robot1");
        Assert.assertEquals(0,service.getCount());
        service.add(robot1);
        Assert.assertEquals(1,service.getCount());
    }

    //2.2 добавяме изработка на робот за който няма капацитет
    @Test(expected = IllegalArgumentException.class)
    public void testAddRobotThrowFilledService(){
        //създаваме услуга с робот с 1 капацитет
        Service service = new Service("Service1",1);
        Robot robot1 = new Robot("Robot1");
        service.add(robot1);

        //създаваме втори робот и хвърля exception
        Robot robot2 = new Robot("Robot2");
        service.add(robot2);
    }


    //3.public void remove(String name)
    //3.1 Успешно премахваме робота
    @Test
    public void testRemoveRobot(){
        Service service = new Service("Service1",7);
        Robot robot1 = new Robot("Robot1");
        Robot robot2 = new Robot("Robot2");
        service.add(robot1);
        service.add(robot2);
        //проверяваме след добавянето дали броя на роботите в Service е 2
        Assert.assertEquals(2,service.getCount());

        service.remove("Robot1");
        Assert.assertEquals(1,service.getCount());
        service.remove("Robot2");
        Assert.assertEquals(0,service.getCount());
    }

    //3.2 Няма такъв robot в Service
    @Test(expected = IllegalArgumentException.class)
    public void removeNonExistingRobot(){
        //създаваме Service с капацитет 10 но не сме добавяли Robot
        Service service = new Service("Service1",4);
        service.remove("Ivan");
    }

  //public Robot forSale(String name)
  //4.1 успешно да продадем Robot - isReadyForSale()
    @Test
    public void robotForSale(){
        Service service = new Service("Service1",4);
        Robot robot1 = new Robot("Robot1");
        service.add(robot1);
        Robot returnRobot = service.forSale("Robot1");
        Assert.assertFalse(returnRobot.isReadyForSale());
    }

    //4.2 нямаме робот в дадено име
    @Test(expected = IllegalArgumentException.class)
    public void testForSaleNonExistingRobot(){
        Service service = new Service("Service1",5);
        service.forSale("Ivan");
    }

    //5.public String report()
    @Test
    public void testReport(){
        Service service = new Service("Service1",5);
        Robot robot1 = new Robot("Robot1");
        service.add(robot1);


        Assert.assertEquals("The robot Robot1 is in the service Service1!",
                service.report());
    }
}
