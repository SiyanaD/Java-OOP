package football;

import org.junit.Assert;
import org.junit.Test;

public class FootballTeamTests {

    //1 Тестваме отбора
    //1,1 тестваме с невалидно setVacantPositions

@Test(expected = IllegalArgumentException.class)
    public void testCreateFootballTeamWithInvalidPosition(){
    new FootballTeam("P",-1);
}

//1.2 невалидно име което е null
    @Test(expected = NullPointerException.class)
    public void testNameWithNull(){
    new FootballTeam(null,4);
    }
    //1.3 празно име
    @Test(expected = NullPointerException.class)
    public void testWithEmptyName(){
    new FootballTeam(" ",6);
    }

    //1.4 тестваме ако имаме валидни стойност
    @Test
    public void testCreateFootballTeam(){
    FootballTeam footballTeam = new FootballTeam("F",10);
        Assert.assertEquals("F",footballTeam.getName());
        Assert.assertEquals(10,footballTeam.getVacantPositions());
    }

    //2 addFootballer
    //2.1 успешно добавяме човек
    @Test
    public void testAddFootballer() {
        FootballTeam footballTeam = new FootballTeam("F", 10);
        Footballer footballer = new Footballer("G");
        Assert.assertEquals(0,footballTeam.getCount());
        footballTeam.addFootballer(footballer);
        Assert.assertEquals(1,footballTeam.getCount());

    }
//2.2 добавяме човек в пълен отбор
    @Test(expected = IllegalArgumentException.class)
    public void testAddFootballThrowFilledFootballTeam(){
    //създаваме отбор от 1 играч
        FootballTeam footballTeam = new FootballTeam("F", 1);
        Footballer footballer = new Footballer("G");
        footballTeam.addFootballer(footballer);

        //добавяме 2 играч и хвърля exception
        Footballer footballer2 = new Footballer("H");
        footballTeam.addFootballer(footballer2);
    }

    //3. removeFootballer
    //3.1 успешно премахваме играч
    @Test
    public void testRemoveFootballer(){
        FootballTeam footballTeam = new FootballTeam("F", 10);
        Footballer footballer = new Footballer("G");
        Footballer footballer2 = new Footballer("U");
        footballTeam.addFootballer(footballer);
        footballTeam.addFootballer(footballer2);
        //проверяваме дали след добавянето броя на играчите са 2
        Assert.assertEquals(2,footballTeam.getCount());

        footballTeam.removeFootballer("G");
        Assert.assertEquals(1,footballTeam.getCount());

        footballTeam.removeFootballer("U");
        Assert.assertEquals(0,footballTeam.getCount());
    }

    //3.2 няма такъв играч в отбора
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistingFootballer(){
        FootballTeam footballTeam = new FootballTeam("F", 10);
        footballTeam.removeFootballer("U");
    }

    //4 footballerForSale
    //успешно продаваме играча
    @Test
    public void testFootballerForSale(){
        FootballTeam footballTeam = new FootballTeam("F", 10);
        Footballer footballer = new Footballer("G");
        footballTeam.addFootballer(footballer);
        Footballer returnFootballer = footballTeam.footballerForSale("G");
        Assert.assertFalse(returnFootballer.isActive());

    }

    //няма играч с дадено име
    @Test(expected = IllegalArgumentException.class)
    public void testForSaleNonExistingFootballer(){
        FootballTeam footballTeam = new FootballTeam("F", 10);
        footballTeam.footballerForSale("P");

    }

    //5.getStatistics
    @Test
    public void testGetStatistics(){
        FootballTeam footballTeam = new FootballTeam("F", 10);
        Footballer footballer = new Footballer("G");
        Footballer footballer2 = new Footballer("U");
        Footballer footballer3 = new Footballer("S");
        footballTeam.addFootballer(footballer);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);

        Assert.assertEquals("The footballer G, U, S is in the team F."
                ,footballTeam.getStatistics());

    }



}
