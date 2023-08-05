package carShop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CarShopTests {
private CarShop carShop;
private Car car;

@Before
    public void setUp(){
    this.carShop=new CarShop();
    this.car=new Car("Opel",150,553.45);

}

// public void add(Car car)
    //-if (car == null)
    //- addCar
    @Test(expected = NullPointerException.class)
    public void testAddCarIsNull(){
    this.carShop.add(null);
    }
    @Test
    public void testAddSuccessfullyCar(){
    //пороверяваме дали първо няма никакви коли
        Assert.assertEquals(0,this.carShop.getCount());
        //добавяме кола
        this.carShop.add(this.car);
    }


   // public boolean remove(Car car)
    @Test
    public void isRemovedCar(){
        //проверяваме дали в началото започваме с 0 cars
        Assert.assertEquals(0,this.carShop.getCount());

        //първо добавяме кола в списъка зада я премахнем
        this.carShop.add(this.car);//"Opel",150,553.45
        //1 cars
        Assert.assertEquals(1,this.carShop.getCount());
        //след като сме създали 1 кола я премахваме
       Assert.assertTrue(carShop.remove(this.car));
    }
    @Test
    public void testGetTheMostLuxuryCar(){

    Car car1 = new Car("Opel",90,5222.2);
    Car car2 = new Car("Toyota",150,7895.65);
    Car car3 = new Car("Tesla",250,20257.55);
    this.carShop.add(car1);
    this.carShop.add(car2);
    this.carShop.add(car3);

    //тестваме дали реално ги получаваме тази коли
        Assert.assertEquals(3,this.carShop.getCars().size());

        //взимаме най скъпата кола
        Car mostLuxuryCar = this.carShop.getTheMostLuxuryCar();//car3

        //сравняваме дали mostLuxuryCar == car3
        //сравняваме първо model
        Assert.assertEquals(mostLuxuryCar.getModel(),car3.getModel());
        //horsePower
        Assert.assertEquals(mostLuxuryCar.getHorsePower(),car3.getHorsePower());
        //price
        Assert.assertEquals(mostLuxuryCar.getPrice(),mostLuxuryCar.getPrice(),car3.getPrice());
    }

    // public List<Car> findAllCarByModel(String model)
    @Test
    public void testFindAllCarByModel(){
    //правим списък с 1 кола
        List<Car> cars = this.carShop.findAllCarByModel("Opel");
        //създаваме колата и я добавяме в списъка
        Car car1 = new Car("Opel",150,553.45);
        cars.add(car1);

        Assert.assertEquals(1,cars.size());
    }


// public List<Car> findAllCarsWithMaxHorsePower(int horsePower)
    @Test
    public void testFindAllCarsWithMaxHorsePower(){

        Car car1 = new Car("Opel",90,5222.2);
        Car car2 = new Car("Toyota",150,7895.65);
        Car car3 = new Car("Tesla",250,20257.55);
        this.carShop.add(car1);
        this.carShop.add(car2);
        this.carShop.add(car3);

        List<Car> cars = this.carShop.findAllCarsWithMaxHorsePower(250);
        Car car4 = new Car("Tesla",250,20257.55);
        cars.add(car4);

        Assert.assertEquals(1,cars.size());

    }





}

