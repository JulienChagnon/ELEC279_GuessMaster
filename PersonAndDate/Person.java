package PersonAndDate;

public class Person extends Entity {
    private String gender;

    //Constructor
    public Person(String name, Date born, String gender, double difficulty) {
        super(name, born, difficulty);
        this.gender = gender;
    }

    //Copy Constructor
    public Person(Person other) {
        super(other);
        this.gender = other.gender;
    }

    //Accessor method
    public String getGender() {
        return gender;
    }

    //Mutator method
    public void setGender(String gender) {
        this.gender = gender;
    }

    //Abstract method implementation
    public String entityType() {
        return "This entity is a person!";
    }

    //Clone method implementation
    public Person clone() {
        return new Person(this);
    }

    //Override toString method
    public String toString() {
        return "\nName: " + getName() + "\nBorn at: " + getBorn().toString() + "\nGender: " + gender;
    }
}
