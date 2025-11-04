package PersonAndDate;

public class Country extends Entity {
    private String capital;

    //Constructor
    public Country(String name, Date born, String capital, double difficulty) {
        super(name, born, difficulty);
        this.capital = capital;
    }

    //Copy Constructor
    public Country(Country other) {
        super(other);
        this.capital = other.capital;
    }

    //Acessor method
    public String getCapital() {
        return capital;
    }

    //Mutator method
    public void setCapital(String capital) {
        this.capital = capital;
    }

    //abstract method
    public String entityType() {
        return "country";
    }

    //Clone method
    public Country clone() {
        return new Country(this);
    }

    //Overriding toString method
    public String toString() {
        return super.toString() + ", Capital: " + capital;
    }
}
