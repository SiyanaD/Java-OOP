package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ExcavationTests {
    //1.тестваме конструктора
    //1.2 тестваме невалидно capacity
    @Test(expected = IllegalArgumentException.class)
    public void testExcavationWithInvalidCapacity(){
        new Excavation("Ex1",-1);
    }
    //1.2 невалидно име null
    @Test(expected = NullPointerException.class)
    public void testNameWhichIsNull(){
        new Excavation(null,5);
    }
    //1.3 невалидно име което е isEmpty()
    @Test(expected = NullPointerException.class)
    public void testNameWhichIsEmpty(){
        new Excavation(" ",5);
    }
    //1.4 тестваме ако имаме валидно стойности
    @Test
    public void testCreateExcavation(){

        Excavation excavation = new Excavation("Ex1",6);
        Assert.assertEquals("Ex1",excavation.getName());
        Assert.assertEquals(6,excavation.getCapacity());



    }
    //2.
    //2.1 Тестваме  Archaeologist
    @Test
    public void testCreateArchaeologist(){

                Archaeologist archaeologist = new Archaeologist("Arch1",8.0);
        Assert.assertEquals("Arch1",archaeologist.getName());
        assertEquals((String)null, 8.0, archaeologist.getEnergy());//when is double
    }
    //2.2 addArchaeologist
    @Test
    public void testAddArch(){
        Excavation excavation = new Excavation("Ex1",6);
        Archaeologist archaeologist = new Archaeologist("Ar",6.0);
        Assert.assertEquals(0,excavation.getCount());
        excavation.addArchaeologist(archaeologist);
        Assert.assertEquals(1,excavation.getCount());

    }
    //2.3 добавяме Archaeologist в който няма Excavation
    @Test(expected = IllegalArgumentException.class)
    public void testAddArchThrowFillExcavation(){
        //създаваме Excavation с капацитет на един Archaeologist
        Excavation excavation = new Excavation("Ex1",0);
        Archaeologist archaeologist = new Archaeologist("Ar",6.0);
        excavation.addArchaeologist(archaeologist);
    }
    //2.4 добавяме съществуващ Archaeologist
    @Test(expected = IllegalArgumentException.class)
    public void testArchaeologistExist(){
        //създаваме Excavation с капацитет 2 Archaeologist
        Excavation excavation = new Excavation("Ex1",2);
        Archaeologist archaeologist = new Archaeologist("Ar",6.0);
        excavation.addArchaeologist(archaeologist);

        //създаваме същия втори Archaeologist и хвърля exception
        Archaeologist archaeologist2 = new Archaeologist("Ar",6.0);
        excavation.addArchaeologist(archaeologist2);
    }
    //2.5

    //3 public boolean removeArchaeologist(String archeologistName)
    @Test
    public void testRemoveArchaeologist(){
        Excavation excavation = new Excavation("Ex1",2);
        Archaeologist archaeologist = new Archaeologist("Ar",6.0);
        excavation.addArchaeologist(archaeologist);
        boolean isRemoved =excavation.removeArchaeologist("Ar");
        Assert.assertTrue(isRemoved);
        Assert.assertEquals(0,excavation.getCount());

    }

}
