package inheritanceExerP01Person;

public class Child extends Person{//Person->super class, защото той е наследен

    //създаваме конструктор на Child->Alt+Insert  и взима полетата на Person
    public Child(String name, int age) {
        super(name, age);
    }
}
