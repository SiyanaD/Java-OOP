package hero;

public class Hero {

    private String username;
    private int level;

    public Hero(String username, int level) {
        this.username = username;
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public int getLevel() {
        return level;
    }

    //  this.getClass()->получаваме на обекта неговият клас Hero + адреса в паметта,
    //когато напишем this.getClass().getName() -> взимаме само името на класа в случая Hero
    @Override
    public String toString() {
        return String.format("Type: %s Username: %s Level: %s",
               this.getClass().getName(),//връще Hero
                this.getUsername(),
                this.getLevel());
    }
}
