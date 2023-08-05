package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeroRepositoryTests {
    // ще ни трябва по един обект от двата класа който трябва да тестваме
   private HeroRepository heroRepository;
   private Hero hero;

   @Before//изпълнява се преди всеки един тест
    public void setUp(){
       this.heroRepository=new HeroRepository();
       this.hero=new Hero("Desi",2);
   }

    //тестваме  public String create(Hero hero)
    //-create(Hero hero), herro = null
    //-duplicate name
    //-successful
    // if (hero == null)
    @Test(expected = NullPointerException.class)
    public void testCreateHeroIsNull(){
       this.heroRepository.create(null);
    }

    //if (this.data.stream().anyMatch(h -> h.getName().equals(hero.getName())))
    @Test(expected = IllegalArgumentException.class)
    public void testCreateHeroAlreadyExist(){
       //създаваме 2 героя с едно и също име
       this.heroRepository.create(this.hero);
       this.heroRepository.create(this.hero);
    }

    //  this.data.add(hero);  Successfully added hero
    @Test
    public void testCreateSuccessfulHero(){
       //проверяваме дали сме създали успешно героя и в същото време проверяваме и
        //тези 2 метода->
        // public int getCount() - в същото време проверяваме и този метод
        //public Hero getHero(String name) - проверяваме и този метод
       //проверяваме дали първо heroRepository няма никви герой
        Assert.assertEquals(0,this.heroRepository.getCount());
        //добавяме герой
        this.heroRepository.create(this.hero);
        //следкато сме го добавили, трябва да имаме един герой в списъка

        Assert.assertEquals(1,this.heroRepository.getCount());
        Hero createdHero = this.heroRepository.getHero("Desi");
        //след това проверяваме дали моя герой се е създал правилно
        Assert.assertEquals(createdHero.getName(),this.hero.getName());
        //след това проверяваме level,
        //като му вземем lewela е  същия който сме подали в create
        Assert.assertEquals(createdHero.getLevel(),this.hero.getLevel());

    }


    // public boolean remove(String name) - имаме 3 тест
    // - if (name == null
    // - name.trim().isEmpty()
    // - isRemoved
    @Test(expected = NullPointerException.class)
    public void testRemoveWithNullName(){
       this.heroRepository.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveWithEmptyName(){
       this.heroRepository.remove("");
    }
    @Test
    public  void testSuccessfulIsRemoved(){
       //проверяваме дали в началото започваме с 0 героя
        Assert.assertEquals(0,this.heroRepository.getCount());
       //първо трябва да добавим някакви герой в списъка че да ги премахнем
        this.heroRepository.create(this.hero);//"Desi
        //1 герой
        Assert.assertEquals(1,this.heroRepository.getCount());

        //след като сме създали 1 геро го премахваме
        this.heroRepository.remove("Desi");

        //проверка дали броя е равен на 0
        Assert.assertEquals(0,this.heroRepository.getCount());
        //проверяваме че в heroRepository нямаме такова име
        //и трябва да вземем изтрития герой
        Hero removedHero = this.heroRepository.getHero("Desi");//null
        Assert.assertNull(removedHero);



    }


    //public Hero getHeroWithHighestLevel()
    @Test
    public void testGetHereWithHighestLevel(){
       //създаваме 3 героя
        Hero hero1 = new Hero("Zdravko",3);
        Hero hero2 = new Hero("Valery",6);
        Hero hero3 = new Hero("Ivo",4);
        this.heroRepository.create(hero1);
        this.heroRepository.create(hero2);
        this.heroRepository.create(hero3);

        //тестваме дали реално ние ги получаваме тези герой
      Assert.assertEquals(3,this.heroRepository.getHeroes().size());
      //взимаме най високия левел на героя
      Hero highestHero = this.heroRepository.getHeroWithHighestLevel();//hero2


        //сравняваме дали highestHero == hero2
        //сравняваме първо имената
        Assert.assertEquals(highestHero.getName(),hero2.getName());
        //сравняваме level
        Assert.assertEquals(highestHero.getLevel(),hero2.getLevel());

    }
}
