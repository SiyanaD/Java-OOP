package magicGame;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MagicianTests {
    //1.Тестваме конструктора
//1.1 тестваме невалиден health
@Test(expected = IllegalArgumentException.class)
    public void testMagicWithInvalidHealthWith(){
    new Magician("Magic1",-5);//health < 0
}
//1.2 invalid username
    @Test(expected = NullPointerException.class)
    public void testInvalidUsername(){
    new Magician(null,4);
    }
    //1.3 невалидно име което е празно
    @Test(expected = NullPointerException.class)
    public void testCreatingMagicWithEmptyName(){
    new Magician(" ",8);
    }
//1.4 Тестваме ако имаме валидни стойности
    @Test
    public void testCreateMagic(){
    Magician magician = new Magician("Magic1",5);
        Assert.assertEquals("Magic1",magician.getUsername());
        Assert.assertEquals(5,magician.getHealth());

    }

    //2 addMagic
    //2.1 успешно добавяме addMagic
    @Test
    public void testAddMagic(){
    //създаваме магия
        Magician magician = new Magician("Magic1",5);
        Magic magic1 = new Magic("M1",6);
        magician.addMagic(magic1);

        //създаваме втора магия и хвърля exception
        Magic magic2 = new Magic("M2",56);
        magician.addMagic(magic2);

    }
    //2.2 добавяме null магия
    @Test(expected = NullPointerException.class)
    public void testAddMagicThrowFilledMagic() {
        Magician magician = new Magician("Magic1",5);
        magician.addMagic(null);

    }
    // public boolean removeMagic
    @Test
    public void testRemoveMagic(){
        Magician magician = new Magician("Magic1",5);
        Magic magic1 = new Magic("M1",6);
        magician.addMagic(magic1);
        magician.removeMagic(magic1);
    }

    //3.1 takeDamage should work
    @Test
    public void testTakeDamageWork(){
        Magician magician = new Magician("Magic1",50);
      magician.takeDamage(6);
      Assert.assertEquals(44,magician.getHealth());
    }
    @Test(expected = IllegalStateException.class)
    public void testTakeDamageThrowException(){
        Magician magician = new Magician("Magic1",0);
        magician.takeDamage(5);
    }
    @Test
    public void testTakeDamageW2(){
        Magician magician = new Magician("Magic1",50);
        magician.takeDamage(50);
        Assert.assertEquals(0,magician.getHealth());
    }

    @Test
    public void testDamageIsNegativeNumber(){
        Magician magician = new Magician("Magic1",30);
        magician.takeDamage(50);
        Assert.assertEquals(0,magician.getHealth());
    }
    @Test
    public void testGetMagicExistingMagic(){
        Magician magician = new Magician("Magic1",50);
        Magic magic = new Magic("M1",6);
        magician.addMagic(magic);
        Assert.assertEquals(magic,magician.getMagic("M1"));
    }
    @Test
    public void testGetMagicThrowNull(){
        Magician magician = new Magician("Magic1",50);
        Magic magic = new Magic("M1",6);
        magician.addMagic(magic);
        Assert.assertEquals(null,magician.getMagic("K1"));
    }


    //public List<Magic> getMagics()
    @Test
    public void testGetMagics(){
        Magic magic = new Magic("M1",6);
        Magician magician = new Magician("Magic1",50);
        magician.addMagic(magic);
        List<Magic> expected = List.of(magic);
        Assert.assertEquals(expected,magician.getMagics());
    }

    @Test
    public void testHealthShouldWork(){
    Magician magician = new Magician("M1",5);
    Assert.assertEquals(5,magician.getHealth());

    }
}
