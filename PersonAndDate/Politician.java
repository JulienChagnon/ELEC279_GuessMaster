package PersonAndDate;

public class Politician extends Person {
    private String party;

    //Constructor
    public Politician(String name, Date born, String gender, String party, double difficulty) {
        super(name, born, gender, difficulty);
        this.party = party;
    }

    //Copy Constructor
    public Politician(Politician other) {
        super(other);
        this.party = other.party;
    }

    //Accessor method
    public String getParty() {
        return party;
    }

    //Mutator method
    public void setParty(String party) {
        this.party = party;
    }

    // Implement abstract method entityType
    public String entityType() {
        return "This entity is a politician!";
    }

    //Clone method
    public Politician clone() {
        return new Politician(this);
    }

    //Overriding toString method
    public String toString() {
        return "\nName: " + super.getName() + "\nGender: " + getGender() + "\nParty: " + party;
    }
}
